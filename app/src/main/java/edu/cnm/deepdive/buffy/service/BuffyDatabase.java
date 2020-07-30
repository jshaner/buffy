package edu.cnm.deepdive.buffy.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.buffy.model.dao.MovieDao;
import edu.cnm.deepdive.buffy.model.dao.SearchDao;
import edu.cnm.deepdive.buffy.model.dao.SearchResultDao;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.Search;
import edu.cnm.deepdive.buffy.model.entity.SearchResult;

import edu.cnm.deepdive.buffy.service.BuffyDatabase.Converters;
import java.util.Date;

@TypeConverters({Converters.class})
@Database(
    entities = {Movie.class, Search.class, SearchResult.class},
    version = 1,
    exportSchema = true
)

/**
 * This class contains static and abstract methods, with convenience annotations,
 * which communicate with the Daos and the database.
 */

public abstract class BuffyDatabase extends RoomDatabase {

  private static final String DB_NAME = "buffy_db";

  private static Application context;

  public static void setContext(Application context) {
    BuffyDatabase.context = context;
  }

  public abstract MovieDao getMovieDao();

  public abstract SearchDao getSearchDao();

  public abstract SearchResultDao getSearchResultDao();


  public static BuffyDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final BuffyDatabase INSTANCE =
        Room.databaseBuilder(context, BuffyDatabase.class, DB_NAME)
//            .addCallback(new Callback())
            .build();


  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }
}



