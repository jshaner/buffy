package edu.cnm.deepdive.buffy.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This class contains queries for retrieving movie information from the database.
 */

@Dao
public interface MovieDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Movie movie);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Movie> movie);

  @Update
  Single<Integer> update(Movie... Movie);

  @Delete
  Single<Integer> delete(Movie... movie);

  @Query("SELECT * FROM Movie ORDER BY movie_id")
  LiveData<List<Movie>> selectAll();

  @Transaction
  @Query("SELECT m.* FROM Movie AS m INNER JOIN SearchResult AS r ON m.movie_id = r.movie_id WHERE r.search_id = :searchId ORDER BY m.title")
  LiveData<List<Movie>> selectBySearchId(Long searchId);

  @Query("SELECT * FROM Movie WHERE movie_id = :movieId")
  Single<Movie > selectById(long movieId);

  @Query("SELECT * FROM Movie WHERE external_id = :externalId")
  Maybe<Movie>  selectByExternalId(long externalId);

  @Query("SELECT * FROM MOVIE WHERE watchlisted")
  LiveData<List<Movie>> selectWatchlist();


}



