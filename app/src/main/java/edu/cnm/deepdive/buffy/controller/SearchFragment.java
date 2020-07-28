package edu.cnm.deepdive.buffy.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.model.entity.Search;
import edu.cnm.deepdive.buffy.view.MovieAdapter;
import edu.cnm.deepdive.buffy.view.WatchlistTitlesAdapter;
import edu.cnm.deepdive.buffy.viewmodel.SearchViewModel;
//import edu.cnm.deepdive.buffy.controller.R;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private AutoCompleteTextView searchText;
    private RecyclerView searchResults;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        searchText = root.findViewById(R.id.search_text);
        searchResults = root.findViewById(R.id.search_results);
        root.findViewById(R.id.search).setOnClickListener((v) ->
            searchViewModel.search(searchText.getText().toString().trim()));
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchViewModel = new ViewModelProvider(getActivity()).get(SearchViewModel.class);
        searchViewModel.getMovies().observe(getViewLifecycleOwner(), (movies) -> {
            MovieAdapter adapter = new MovieAdapter(getContext(), movies, (movie, watchlisted) -> {
                movie.setWatchlisted(watchlisted);
                searchViewModel.save(movie);
            });

            searchResults.setAdapter(adapter);
        });

        searchViewModel.getSearches().observe(getViewLifecycleOwner(), (searches) -> {
            ArrayAdapter<Search> adapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, searches);
            searchText.setAdapter(adapter);
        });
    }

}
