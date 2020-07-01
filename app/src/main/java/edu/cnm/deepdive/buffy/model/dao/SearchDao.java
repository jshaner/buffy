package edu.cnm.deepdive.buffy.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;
import edu.cnm.deepdive.buffy.model.entity.Movie;
import edu.cnm.deepdive.buffy.model.entity.Search;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface SearchDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Search search);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Search> search);

  @Update
  Single<Integer> update(Search... search);

  @Delete
  Single<Integer> delete(Search... search);

//  @Transaction
//  @Query("SELECT * FROM Quote ORDER BY text")
//  LiveData<List<QuoteWithSource>> selectAll();

//  @Query("SELECT * FROM Quote WHERE source_id = :sourceId")
//  Single<List<Quote>> selectBySourceId(Long sourceId);

//  @Transaction
  // @Query("SELECT * FROM Quote WHERE quote_id = :quoteId")
//  Single<QuoteWithSource > selectById(long quoteId);


}


