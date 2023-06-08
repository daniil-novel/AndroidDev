package com.example.pract8;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyStringDao {
    @Query("SELECT * FROM string_table")
    LiveData<List<MyString>> getAll();

    @Query("SELECT * FROM string_table WHERE sid IN (:stringsIds)")
    LiveData<List<MyString>> loadAllByIds(int[] stringsIds);

    @Query("SELECT * FROM string_table WHERE my_string LIKE :string LIMIT 1")
    MyString findByName(String string);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(MyString... strings);

    @Delete
    void delete(MyString string);

    @Query("DELETE FROM string_table")
    void deleteAll();
}
