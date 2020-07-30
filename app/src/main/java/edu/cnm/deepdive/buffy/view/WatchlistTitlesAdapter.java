package edu.cnm.deepdive.buffy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.buffy.BuildConfig;
import edu.cnm.deepdive.buffy.R;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.view.WatchlistTitlesAdapter.Holder;
import java.util.List;

/**
 * This class contains methods, with convenience annotations,
 * which inflate the xml layouts and display a user's watchlist.
 */

public class WatchlistTitlesAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<Movie> watchlists;
//  private final OnWatchlistedListener listener;


  public WatchlistTitlesAdapter(Context context,
      List<Movie> movies) {
    this.context = context;
    this.watchlists = movies;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_watchlist, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return watchlists.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView watchlist_title;
    private final TextView watchlist_link;

    private Holder(@NonNull View itemView) {
      super(itemView);
      watchlist_title = itemView.findViewById(R.id.title);
      watchlist_link = itemView.findViewById(R.id.link);
    }

    private void bind(int position) {
      Movie movie = watchlists.get(position);
      watchlist_title.setText(movie.getTitle());
      watchlist_link.setText(String.format(BuildConfig.WEBSITE_URL, movie.getExternalId()));


    }
  }

}



