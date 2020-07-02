package edu.cnm.deepdive.buffy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(indices = @Index(value = "Search", unique = true))
public class Search {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "search_id")
  private long id;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private Date date;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String filter;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getDate() {
    return date;
  }

  public void setDate(@NonNull Date date) {
    this.date = date;
  }

  @NonNull
  public String getFilter() {
    return filter;
  }

  public void setFilter(@NonNull String filter) {
    this.filter = filter;
  }
}
