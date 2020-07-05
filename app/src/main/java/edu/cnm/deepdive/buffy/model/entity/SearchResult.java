package edu.cnm.deepdive.buffy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    indices = {
        @Index(value = {"search_result_id"}, unique = true),
//        @Index(value = {watchlistDate}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(
            entity = Search.class,
            childColumns = "search_id",
            parentColumns = "search_id"
        )
    }
)

public class SearchResult {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "search_result_id")
  private long id;

  @ColumnInfo(name = "search_id", index = true)
  private long searchId;

  @ColumnInfo(name = "movie_id", index = true)
  private long movieId;

  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private int order;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSearchId() {
    return searchId;
  }

  public void setSearchId(long searchId) {
    this.searchId = searchId;
  }

  public long getMovieId() {
    return movieId;
  }

  public void setMovieId(long movieId) {
    this.movieId = movieId;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }
}
