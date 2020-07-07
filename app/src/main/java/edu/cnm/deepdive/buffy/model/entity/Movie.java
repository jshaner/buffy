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
        @Index(value = {"title"}, unique = true),

    }
)

public class Movie {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "movie_id")
  private long id;

  @ColumnInfo(name = "external_id")
  private long externalId;

  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private Date date;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String title;

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
}
