package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class BottomPlayerViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;

    private final LiveData<SongModel> song;
//    private final LiveData<SongModel> songFromDB;

    public BottomPlayerViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(getApplication());
        song = trackRepository.getCurrent();
//        songFromDB = trackRepository.getSongFromDB();
    }

    public LiveData<SongModel> getSong() {
        return song;
    }

    public void nextTrack(){
        trackRepository.nextTrack();
    }
}
