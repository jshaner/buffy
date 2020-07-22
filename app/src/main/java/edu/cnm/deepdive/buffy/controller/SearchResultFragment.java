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
import com.google.android.material.textfield.TextInputLayout;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.controller.gallery.SearchResultViewModel;
//import edu.cnm.deepdive.buffy.controller.R;

public class SearchResultFragment extends Fragment {

    private SearchResultViewModel searchResultViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        searchResultViewModel =
                ViewModelProviders.of(this).get(SearchResultViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search_result, container, false);
        final TextView movie1 = root.findViewById(R.id.text_movie1);
        final TextView movie2 = root.findViewById(R.id.text_movie2);
        final TextView movie3 = root.findViewById(R.id.text_movie3);
        final TextView movie4 = root.findViewById(R.id.text_movie4);

        searchResultViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                movie1.setText(s);
                movie2.setText(s);
                movie3.setText(s);
                movie4.setText(s);

            }
        });
        return root;
    }
}
