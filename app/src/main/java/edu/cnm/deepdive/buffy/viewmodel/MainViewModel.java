package edu.cnm.deepdive.buffy.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.buffy.service.MovieRepository;
import edu.cnm.deepdive.buffy.service.SearchRepository;
import edu.cnm.deepdive.buffy.service.SearchResultRepository;
import io.reactivex.disposables.CompositeDisposable;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MovieRepository movieRepository;
  private final SearchRepository searchRepository;
  private final SearchResultRepository searchResultRepository;



  public MainViewModel(@NonNull Application application) {
    super(application);
    movieRepository = new MovieRepository(application);
    searchRepository = new SearchRepository(application);
    searchResultRepository = new SearchResultRepository(application);

  }



}
