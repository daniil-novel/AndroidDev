package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class PlayingNextViewModel extends AndroidViewModel {
    private final TrackRepository trackRepository;

    private final MutableLiveData<List<SongModel>> songs;
    private final MutableLiveData<SongModel> current;

    public PlayingNextViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(getApplication());
        songs = trackRepository.getSongs();
        current = trackRepository.getCurrent();
    }

    public MutableLiveData<SongModel> getCurrent() {
        return current;
    }

    public MutableLiveData<List<SongModel>> getSongs() {
        return songs;
    }
}
