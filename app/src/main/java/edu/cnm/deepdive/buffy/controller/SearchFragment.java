package edu.cnm.deepdive.buffy.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.view.SearchResultAdapter;
import edu.cnm.deepdive.buffy.viewmodel.SearchViewModel;
//import edu.cnm.deepdive.buffy.controller.R;

public class SearchFragment extends Fragment implements OnQueryTextListener {

    private SearchViewModel searchViewModel;
    private SearchView searchText;
    private RecyclerView searchResults;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        searchText = root.findViewById(R.id.search_text);
        searchResults = root.findViewById(R.id.search_results);
        searchText.setOnQueryTextListener(this);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchViewModel = new ViewModelProvider(getActivity()).get(SearchViewModel.class);
        searchViewModel.getMovies().observe(getViewLifecycleOwner(), (movies) -> {
            SearchResultAdapter adapter = new SearchResultAdapter(getContext(), movies, (movie, watchlisted) -> {
                //TODO tell view model to update watchlisted status of movie
            });

            searchResults.setAdapter(adapter);
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchViewModel.search(query.trim());
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
