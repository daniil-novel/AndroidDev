package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class SongLibraryViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;

    private final LiveData<List<SongModel>> songs;

    public SongLibraryViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(application);
        songs = trackRepository.getDatabaseData();
    }

    public LiveData<List<SongModel>> getSongs() {
        return songs;
    }
}
