package ru.surok.myfirstapplication.Data.Repositories;

import android.content.Context;
import android.content.SharedPreferences;

import ru.surok.myfirstapplication.Data.DataSources.AppSpecificStorageDataSource;
import ru.surok.myfirstapplication.Data.DataSources.ExternalStorageDataSource;
import ru.surok.myfirstapplication.Data.DataSources.SharedPreferencesDataSource;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public class ExternalInternalStorageRepository{

    private final AppSpecificStorageDataSource appSpecificStorageDataSource;
    private final ExternalStorageDataSource externalStorageDataSource;
    private final SharedPreferencesDataSource preferencesDataSource;

    public ExternalInternalStorageRepository(Context context) {
        appSpecificStorageDataSource = new AppSpecificStorageDataSource(context);
        externalStorageDataSource = new ExternalStorageDataSource();
        preferencesDataSource = new SharedPreferencesDataSource(context);
    }

    public void likeTrack(SongModel song){
        appSpecificStorageDataSource.likeTrack(song);
    }

    public void createFile(Context context){
        externalStorageDataSource.createFile(context);
    }

    public void savePref(String key, boolean value){
        preferencesDataSource.SavePref(key, value);
    }

    public boolean getPref(String key){
        return preferencesDataSource.getPref(key);
    }
}
