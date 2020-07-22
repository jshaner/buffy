package edu.cnm.deepdive.buffy.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.controller.slideshow.WatchlistViewModel;
//import edu.cnm.deepdive.buffy.controller.R;

public class WatchlistFragment extends Fragment {

    private WatchlistViewModel watchlistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        watchlistViewModel =
                ViewModelProviders.of(this).get(WatchlistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_watchlist, container, false);
        final TextView watchlist1 = root.findViewById(R.id.watchlist_title1);
        final TextView watchlist2 = root.findViewById(R.id.watchlist_title2);
        final TextView watchlist3 = root.findViewById(R.id.watchlist_title3);
        final TextView watchlist4 = root.findViewById(R.id.watchlist_title4);
        final TextView watchlist5 = root.findViewById(R.id.watchlist_title5);
        final TextView watchlist6 = root.findViewById(R.id.watchlist_title6);
        final TextView watchlist7 = root.findViewById(R.id.watchlist_title7);
        final TextView watchlist8 = root.findViewById(R.id.watchlist_title8);



        watchlistViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                watchlist1.setText(s);
                watchlist2.setText(s);
                watchlist3.setText(s);
                watchlist4.setText(s);
                watchlist5.setText(s);
                watchlist6.setText(s);
                watchlist7.setText(s);
                watchlist8.setText(s);

            }
        });
        return root;
    }
}
