package edu.cnm.deepdive.buffy.service;

import android.content.Context;
import androidx.room.Dao;
import edu.cnm.deepdive.buffy.model.dao.MovieDao;
import edu.cnm.deepdive.buffy.model.dao.SearchDao;
import edu.cnm.deepdive.buffy.model.dao.SearchResultDao;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class MovieRepository {

  private final Context context;
  private final BuffyDatabase database;
  private final MovieDao movieDao;
  private final SearchDao searchDao;
  private final SearchResultDao searchResultDao;


  public MovieRepository(Context context) {
    this.context = context;
    database = BuffyDatabase.getInstance();
    movieDao = database.getMovieDao();
    searchDao = database.getSearchDao();
    searchResultDao = database.getSearchResultDao();
  }
  public Completable save(Movie movie) {
    if (movie.getId() == 0) {
      return Completable.fromSingle(movieDao.insert(movie))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(movieDao.update(movie))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Movie movie) {
    if (movie.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());

    } else {
      return Completable.fromSingle(movieDao.delete(movie))
          .subscribeOn(Schedulers.io());

    }
  }
  //TODO Add other methods as necessary.

}


