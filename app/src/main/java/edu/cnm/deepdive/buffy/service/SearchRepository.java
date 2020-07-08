package edu.cnm.deepdive.buffy.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.buffy.model.dao.MovieDao;
import edu.cnm.deepdive.buffy.model.dao.SearchDao;
import edu.cnm.deepdive.buffy.model.dao.SearchResultDao;
import edu.cnm.deepdive.buffy.model.entity.Search;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class SearchRepository {

  private final Context context;
  private final BuffyDatabase database;
  private final MovieDao movieDao;
  private final SearchDao searchDao;
  private final SearchResultDao searchResultDao;


  public SearchRepository(Context context) {
    this.context = context;
    database = BuffyDatabase.getInstance();
    movieDao = database.getMovieDao();
    searchDao = database.getSearchDao();
    searchResultDao = database.getSearchResultDao();
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

  //TODO Add other methods as necessary.

}


