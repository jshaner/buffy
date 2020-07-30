package edu.cnm.deepdive.buffy.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.Search;
import edu.cnm.deepdive.buffy.service.MovieRepository;
import edu.cnm.deepdive.buffy.service.SearchRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class SearchViewModel extends AndroidViewModel implements LifecycleObserver {

  private final LiveData<List<Movie>> movies;
  private final MutableLiveData<Search> search;
  private final SearchRepository searchRepository;
  private final MovieRepository movieRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public SearchViewModel(@NonNull Application application) {
    super(application);
    searchRepository = new SearchRepository(application);
    movieRepository = new MovieRepository(application);
    search = new MutableLiveData<>();
    movies = Transformations.switchMap(search, (s) -> searchRepository.getMovies(s.getId()));
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();

  }

  public void search(String filter) { //TODO invoke in view model
    pending.add(
        searchRepository.search(filter)
            .subscribe(
                (search) -> this.search.postValue(search),
                (throwable) -> this.throwable.postValue(throwable)
            )
    );

  }

  public LiveData<List<Movie>> getMovies() {
    return movies;
  }

  public void save(Movie movie) {
    throwable.setValue(null);
    pending.add(
    movieRepository.save(movie)
        .subscribe(
            () -> {},
            (throwable) -> this.throwable.postValue(throwable)
        )
    );
  }

  public LiveData<List<Search>> getSearches() {
    return searchRepository.getAll();
  }

  public LiveData<List<Movie>> getWatchlist() {
    return searchRepository.getWatchlist();
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}

