package edu.cnm.deepdive.buffy.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.SearchResult;
import edu.cnm.deepdive.buffy.service.SearchRepository;
import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Movie>> movies;
    private final SearchRepository searchRepository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        searchRepository = new SearchRepository(application);
        movies = new MutableLiveData<>();
        //TODO initialize live data fields
    }

    public void search (String filter) { //TODO invoke in view model
        searchRepository.search(filter)
            .subscribe(
                movies::postValue
            );

    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }
}

