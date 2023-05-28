package ru.surok.myfirstapplication.Data.DataSources;

import android.content.ContentValues;

import androidx.annotation.NonNull;
import androidx.room.OnConflictStrategy;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.surok.myfirstapplication.R;

public class DataBaseFiller extends RoomDatabase.Callback {
    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
        ContentValues values = new ContentValues();
        for(int j = 65; j <= 70; j++) {
            for (int i = 65; i <= 90; i++) {
                values.put("name", "Song " + (char) i);
                values.put("band", "Band " + (char) j);
                values.put("img", R.drawable.ic_launcher_background);
//                                            SongEntity song = new SongEntity(
//                                                    "Song " + (char) i,
//                                                    "Band " + (char) j,
//                                                    R.drawable.ic_launcher_background
//                                            );
                db.insert("songs", OnConflictStrategy.REPLACE, values);
            }
        }
    }
}
