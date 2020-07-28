package edu.cnm.deepdive.buffy.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.Search;
import edu.cnm.deepdive.buffy.model.entity.SearchResult;
import edu.cnm.deepdive.buffy.service.MovieRepository;
import edu.cnm.deepdive.buffy.service.SearchRepository;
import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    private final LiveData<List<Movie>> movies;
    private final MutableLiveData<Search> search;
    private final SearchRepository searchRepository;
    private final MovieRepository movieRepository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        searchRepository = new SearchRepository(application);
        movieRepository = new MovieRepository(application);
        search = new MutableLiveData<>();
        movies = Transformations.switchMap(search, (s) -> searchRepository.getMovies(s.getId()));
        //TODO initialize live data fields
    }

    public void search (String filter) { //TODO invoke in view model
        searchRepository.search(filter)
            .subscribe(
                (search) -> this.search.postValue(search)
            );

    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void save(Movie movie) {
        movieRepository.save(movie)
            .subscribe();
    }

    public LiveData<List<Search>> getSearches() {
        return searchRepository.getAll();
    }
}

