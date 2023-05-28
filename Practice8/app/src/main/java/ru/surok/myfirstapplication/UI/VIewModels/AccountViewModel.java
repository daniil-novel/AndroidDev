package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import ru.surok.myfirstapplication.Data.DataSources.ExternalStorageDataSource;
import ru.surok.myfirstapplication.Data.Repositories.ExternalInternalStorageRepository;
import ru.surok.myfirstapplication.R;

public class AccountViewModel extends AndroidViewModel {
    private final ExternalInternalStorageRepository storageRepository;

    public AccountViewModel(@NonNull Application application) {
        super(application);
        storageRepository = new ExternalInternalStorageRepository(application);
    }

    public void savePref(String key, boolean value){
        storageRepository.savePref(key, value);
    }

    public boolean getPref(String key){
        return storageRepository.getPref(key);
    }
}
