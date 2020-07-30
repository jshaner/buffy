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
import edu.cnm.deepdive.buffy.model.entity.Search;
import io.reactivex.Maybe;
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

  @Transaction
  @Query("SELECT * FROM Search ORDER BY search_id")
  LiveData<List<Search>> selectAll();

  @Transaction
  @Query("SELECT * FROM Search WHERE search_id = :searchId")
  Single<Search> selectById(long searchId);

  @Query("SELECT * FROM Search WHERE filter = :filter")
  Maybe<Search> selectByFilter(String filter);




}


