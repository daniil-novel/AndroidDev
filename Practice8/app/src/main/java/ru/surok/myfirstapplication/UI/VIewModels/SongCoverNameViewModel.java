package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class SongCoverNameViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;
    private final MutableLiveData<SongModel> current;

    public SongCoverNameViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(getApplication());
        current = trackRepository.getCurrent();
    }

    public MutableLiveData<SongModel> getCurrent() {
        return current;
    }
}
