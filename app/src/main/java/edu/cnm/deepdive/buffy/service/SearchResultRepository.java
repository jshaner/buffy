package edu.cnm.deepdive.buffy.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.buffy.model.dao.MovieDao;
import edu.cnm.deepdive.buffy.model.dao.SearchDao;
import edu.cnm.deepdive.buffy.model.dao.SearchResultDao;
import edu.cnm.deepdive.buffy.model.entity.SearchResult;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


/**
 * This class contains methods, with convenience annotations,
 * which allow the user to save and delete information from search queries
 * returned from TMDB.
 */

public class SearchResultRepository {

  private final Context context;
  private final BuffyDatabase database;
  private final MovieDao movieDao;
  private final SearchDao searchDao;
  private final SearchResultDao searchResultDao;


  public SearchResultRepository(Context context) {
    this.context = context;
    database = BuffyDatabase.getInstance();
    movieDao = database.getMovieDao();
    searchDao = database.getSearchDao();
    searchResultDao = database.getSearchResultDao();
  }

  public Completable save(SearchResult searchResult) {
    if (searchResult.getId() == 0) {
      return Completable.fromSingle(searchResultDao.insert(searchResult))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(searchResultDao.update(searchResult))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(SearchResult searchResult) {
    if (searchResult.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());

    } else {
      return Completable.fromSingle(searchResultDao.delete(searchResult))
          .subscribeOn(Schedulers.io());

    }
  }

  public LiveData<List<SearchResult>> getAll() {
    return searchResultDao.selectAll();
  }

  //TODO Add other methods as necessary.

}


