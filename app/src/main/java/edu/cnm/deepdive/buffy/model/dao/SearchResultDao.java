package edu.cnm.deepdive.buffy.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.SearchResult;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

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

//  @Transaction
//  @Query("SELECT * FROM Quote ORDER BY text")
//  LiveData<List<QuoteWithSource>> selectAll();

//  @Query("SELECT * FROM Quote WHERE source_id = :sourceId")
//  Single<List<Quote>> selectBySourceId(Long sourceId);

//  @Transaction
  // @Query("SELECT * FROM Quote WHERE quote_id = :quoteId")
//  Single<QuoteWithSource > selectById(long quoteId);


}


