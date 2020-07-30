package edu.cnm.deepdive.buffy.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.controller.slideshow.WatchlistViewModel;
import edu.cnm.deepdive.buffy.view.MovieAdapter;
import edu.cnm.deepdive.buffy.view.WatchlistTitlesAdapter;
import edu.cnm.deepdive.buffy.viewmodel.SearchViewModel;
//import edu.cnm.deepdive.buffy.controller.R;

public class WatchlistFragment extends Fragment {

    private WatchlistViewModel watchlistViewModel;
    private RecyclerView watchlistArray;
    private SearchViewModel searchViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watchlist, container, false);
        watchlistArray = view.findViewById(R.id.watchlist_recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchViewModel = new ViewModelProvider(getActivity())
            .get(SearchViewModel.class);
        searchViewModel.getWatchlist().observe(getViewLifecycleOwner(), watchlists -> {
            if (watchlists != null) {
                watchlistArray.setAdapter(new MovieAdapter(getContext(), watchlists, (movie, watchlisted) -> {
                    movie.setWatchlisted(watchlisted);
                    searchViewModel.save(movie);
                }));
            }
        });
    }

//    @Override
//    public void onSelected(Movie movie) {
//        WatchlistFragment fragment = SearchResultFragment.newInstance(movie);
//        fragment.show(getChildFragmentManager(), fragment.getClass().getName());
//    }

    private void show(FragmentManager childFragmentManager, String name) {
    }
}

