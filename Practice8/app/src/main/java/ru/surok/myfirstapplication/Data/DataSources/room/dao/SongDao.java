package ru.surok.myfirstapplication.Data.DataSources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.room.Entity.SongEntity;

@Dao
public interface SongDao {
    @Query("SELECT * FROM songs")
    LiveData<List<SongEntity>> getAll();
    @Query("SELECT * FROM songs WHERE uid IN (:songIds)")
    LiveData<List<SongEntity>> loadAllByIds(int[] songIds);
    @Query("SELECT * FROM songs WHERE name LIKE :name AND band LIKE :band LIMIT 1")
    LiveData<SongEntity> findByName(String name, String band);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<SongEntity> songs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SongEntity... song);
    @Delete
    void delete(SongEntity song);

    @Query("DELETE FROM songs")
    void deleteAll();
}
