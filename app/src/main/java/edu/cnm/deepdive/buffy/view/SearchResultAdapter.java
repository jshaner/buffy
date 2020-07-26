package edu.cnm.deepdive.buffy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.buffy.BuildConfig;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.view.SearchResultAdapter.Holder;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<Holder>{

  private final Context context;
  private final List<Movie> movies;
  private final OnWatchlistedListener listener;


  public SearchResultAdapter(Context context,
      List<Movie> movies,
      OnWatchlistedListener listener) {
    this.context = context;
    this.movies = movies;
    this.listener = listener;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return movies.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView link;
    private final Switch watchlisted;

    private Holder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      link = itemView.findViewById(R.id.link);
      watchlisted = itemView.findViewById(R.id.watchlisted);
    }

    private void bind(int position) {
      Movie movie = movies.get(position);
      title.setText(movie.getTitle());
      link.setText(String.format(BuildConfig.WEBSITE_URL, movie.getExternalId()));
      watchlisted.setChecked(movie.isWatchlisted());
      watchlisted.setOnCheckedChangeListener(
          (buttonView, isChecked) -> listener.setWatchlisted(movie, isChecked));


    }
  }


  public interface OnWatchlistedListener {
    void setWatchlisted(Movie movie, boolean watchlisted);
  }

  }



