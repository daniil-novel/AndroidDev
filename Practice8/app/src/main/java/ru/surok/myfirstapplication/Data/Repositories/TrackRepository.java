package ru.surok.myfirstapplication.Data.Repositories;

import android.content.Context;
import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ru.surok.myfirstapplication.Data.DataSources.room.Entity.SongEntity;
import ru.surok.myfirstapplication.Data.DataSources.room.databases.SongDatabase;
import ru.surok.myfirstapplication.Data.DataSources.SongsDataSource;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public class TrackRepository {

    private final SongsDataSource songsDataSource;
    private final SongDatabase songDatabase;

    private static TrackRepository INSTANCE;

    public static TrackRepository getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new TrackRepository(context);
        }
        return INSTANCE;
    }

    public TrackRepository(Context context) {
        songsDataSource = new SongsDataSource();
        songDatabase = SongDatabase.getDatabase(context);
//        songDatabase.songDao().getAll();
    }

    public void nextTrack(){
        songsDataSource.nextTrack();
    }

    public void prevTrack(){
        songsDataSource.prevTrack();
    }

    public MutableLiveData<List<SongModel>> getSongs() {
        return songsDataSource.getSongs();
    }

    public MutableLiveData<SongModel> getCurrent(){
        return songsDataSource.getCurrent();
    }

    public LiveData<SongModel> getSongFromDB(String name, String band){
        return Transformations.map(songDatabase.songDao().findByName(name, band),
                SongEntity::toDomainModel);
    }

    public void addSong(SongModel songModel){
        SongDatabase.databaseWriteExecutor.execute(() ->{
            songDatabase.songDao().insert(
                    new SongEntity(songModel.getName(), songModel.getBand(), songModel.getImg()
                    ));
        });
    }

    public void deleteAll(){
        SongDatabase.databaseWriteExecutor.execute(()->
                songDatabase.songDao().deleteAll());
    }

    public LiveData<List<SongModel>> getDatabaseData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Transformations.map(
                    songDatabase.songDao().getAll(),
                    (values) -> values.stream().map(SongEntity::toDomainModel)
                            .collect(Collectors.toList())
            );
        }
        return null;
    }

}
