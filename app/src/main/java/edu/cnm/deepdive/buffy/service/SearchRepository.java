package edu.cnm.deepdive.buffy.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.buffy.BuildConfig;
import edu.cnm.deepdive.buffy.model.dao.MovieDao;
import edu.cnm.deepdive.buffy.model.dao.SearchDao;
import edu.cnm.deepdive.buffy.model.dao.SearchResultDao;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.Search;
import edu.cnm.deepdive.buffy.model.entity.SearchResult;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class contains methods, with convenience annotations,
 * which perform the search query through the TMDB.
 */

public class SearchRepository {

  private final Context context;
  private final BuffyDatabase database;
  private final MovieDao movieDao;
  private final SearchDao searchDao;
  private final SearchResultDao searchResultDao;
  private final TmdbService tmdbService;
  private final ExecutorService pool;


  public SearchRepository(Context context) {
    this.context = context;
    tmdbService = TmdbService.getInstance();
    database = BuffyDatabase.getInstance();
    movieDao = database.getMovieDao();
    searchDao = database.getSearchDao();
    searchResultDao = database.getSearchResultDao();
    pool = Executors.newSingleThreadExecutor();
  }

  public Completable save(Search search) {
    if (search.getId() == 0) {
      return Completable.fromSingle(searchDao.insert(search))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(searchDao.update(search))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Search search) {
    if (search.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());

    } else {
      return Completable.fromSingle(searchDao.delete(search))
          .subscribeOn(Schedulers.io());

    }
  }

  public LiveData<List<Search>> getAll() {
    return searchDao.selectAll();
  }

  public LiveData<List<Movie>> getMovies(long searchId) {
    return movieDao.selectBySearchId(searchId);

  }

  public Single<Search> search(String query) {
    return searchDao.selectByFilter(query)
        .subscribeOn(Schedulers.io())
        .switchIfEmpty((SingleSource<? extends Search>) (observer) ->
            searchTmdb(query)
                .subscribe(observer)
        );
  }

  public Single<Search> searchTmdb(String query) {
    return tmdbService.search(BuildConfig.API_KEY, query)
        .subscribeOn(Schedulers.from(pool))
        .flatMap((result) -> {
          Search search = new Search();
          search.setDate(new Date());
          search.setFilter(query);
          return searchDao.insert(search)
              .map((searchId) -> {
                search.setId(searchId);
                List<SearchResult> searchResults = new LinkedList<>();
                for (Movie movie : result.getResults()) {
                  movieDao.selectByExternalId(movie.getExternalId())
                      .switchIfEmpty((SingleSource<Movie>) (observer) -> {
                        movieDao.insert(movie)
                            .map((movieId) -> {
                              movie.setId(movieId);
                              return movie;
                            })
                            .subscribe(observer);
                      })
                      .map((m) -> {
                        SearchResult searchResult = new SearchResult();
                        searchResult.setSearchId(searchId);
                        searchResult.setMovieId(m.getId());
                        searchResults.add(searchResult);
                        movie.setWatchlisted(m.isWatchlisted());
                        return movie;
                      })
                      .subscribe();
                }
                searchResultDao.insert(searchResults)
                    .subscribe();
                return search;
              });

        });
  }

  //TODO Add other methods as necessary.

  public LiveData<List<Movie>> getWatchlist() {

    return movieDao.selectWatchlist();
  }

}


