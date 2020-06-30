package edu.cnm.deepdive.buffy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Search {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "quote_id")
  private long id;

  @ColumnInfo(name = "source_id", index = true)
  private Long sourceId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String text = "";


}
