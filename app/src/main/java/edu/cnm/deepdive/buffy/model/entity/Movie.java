package edu.cnm.deepdive.buffy.model.entity;


import android.view.ViewDebug.ExportedProperty;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

@Entity(
    indices = {
        @Index(value = {"title"}, unique = true),

    }
)

/**
 * This class contains  methods, with convenience annotations,
 * for defining database tables and retrieving information.
 */

public class Movie {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "movie_id")
  private long id;

  @Expose
  @SerializedName("id")
  @ColumnInfo(name = "external_id")
  private long externalId;

  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private Date date;

  @Expose
  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String title;

  private boolean watchlisted;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getExternalId() {
    return externalId;
  }

  public void setExternalId(long externalId) {
    this.externalId = externalId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  public boolean isWatchlisted() {
    return watchlisted;
  }

  public void setWatchlisted(boolean watchlisted) {
    this.watchlisted = watchlisted;
  }

  public static class Result{

    @Expose
    private List<Movie> results;

    public List<Movie> getResults() {
      return results;
    }

    public void setResults(List<Movie> results) {
      this.results = results;
    }
  }
}
