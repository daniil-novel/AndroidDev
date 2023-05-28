package ru.surok.myfirstapplication.Data.DataSources.room.databases;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.surok.myfirstapplication.Data.DataSources.DataBaseFiller;
import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.DataSources.room.Entity.SongEntity;
import ru.surok.myfirstapplication.Data.DataSources.room.dao.SongDao;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.R;

@Database(entities = {SongEntity.class}, version = 1)
public abstract class SongDatabase extends RoomDatabase {
    public abstract SongDao songDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile SongDatabase INSTANCE;

    public static SongDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            System.out.println("hello from database");
            synchronized (SongDatabase.class){
                if (INSTANCE == null){
                    DataBaseFiller dbf = new DataBaseFiller();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SongDatabase.class, "song_database")
                            .addCallback(dbf)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
