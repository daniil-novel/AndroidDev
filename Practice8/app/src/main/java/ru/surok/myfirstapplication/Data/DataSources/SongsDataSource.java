package ru.surok.myfirstapplication.Data.DataSources;

import android.os.Build;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.R;

public class SongsDataSource {

    private final LinkedList<SongModel> songs = new LinkedList<>();

    private final ListIterator<SongModel> songsIter;

    private final MutableLiveData<SongModel> current = new MutableLiveData<>(null);

    public SongsDataSource() {
        for(int j = 65; j <= 70; j++) {
            for (int i = 65; i <= 90; i++) {
                SongModel song = new SongModel("Song " + (char) i, "Band " + (char) j,
//                        String.format("song %s from band %s", (char) i, (char) j),
                        R.drawable.ic_launcher_background
//                        , 300
                );
                songs.add(song);
            }
        }
        songsIter = songs.listIterator();
        current.setValue(songsIter.next());
    }

    public MutableLiveData<SongModel> getCurrent() {
        return current;
    }

    public void nextTrack(){
        if(songsIter.hasNext())
            current.setValue(songsIter.next());
    }

    public void prevTrack(){
        if(songsIter.hasPrevious())
            current.setValue(songsIter.previous());
    }

    public MutableLiveData<List<SongModel>> getSongs() {
        return new MutableLiveData<>(songs);
    }
}
