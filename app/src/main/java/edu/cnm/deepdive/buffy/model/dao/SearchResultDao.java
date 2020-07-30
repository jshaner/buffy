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
import edu.cnm.deepdive.buffy.model.entity.SearchResult;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This class contains queries for retrieving movie information from the database.
 */

@Dao
public interface SearchResultDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(SearchResult searchResult);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<SearchResult> searchResult);

  @Update
  Single<Integer> update(SearchResult... searchResult);

  @Delete
  Single<Integer> delete(SearchResult... searchResult);

  @Transaction
  @Query("SELECT * FROM SearchResult ORDER BY search_result_id")
  LiveData<List<SearchResult>> selectAll();

  @Query("SELECT * FROM SearchResult WHERE search_result_id = :searchResultId")
  Single<List<SearchResult>> selectBySearchResultId(Long searchResultId);

  @Transaction
   @Query("SELECT * FROM SearchResult WHERE search_result_id = :searchResultId")
  Single<SearchResult> selectById(long searchResultId);


}


