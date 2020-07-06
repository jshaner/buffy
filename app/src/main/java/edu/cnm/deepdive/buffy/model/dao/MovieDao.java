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
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

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

//  @Query("SELECT * FROM Search WHERE search_id = :search_Id")
//  Single<List<Movie>> selectBySourceId(Long sourceId);

//  @Transaction
 // @Query("SELECT * FROM Quote WHERE quote_id = :quoteId")
//  Single<QuoteWithSource > selectById(long quoteId);


}



