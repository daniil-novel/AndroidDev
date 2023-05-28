package ru.surok.myfirstapplication.Data.DataSources;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ru.surok.myfirstapplication.Data.Models.SongModel;

public class AppSpecificStorageDataSource {

    private final File app_specific_storage;

    public AppSpecificStorageDataSource(Context context) {
        app_specific_storage = context.getApplicationContext().getFilesDir();
    }

    public void likeTrack(SongModel song){
        if(app_specific_storage.canWrite()){
            File licked_song = new File(app_specific_storage, "licked_song.txt");
            try (FileWriter fileWriter = new FileWriter(licked_song)){
                fileWriter.write(song.getName());
                fileWriter.write(song.getBand());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello from appstorageRepo");
//            showLickedNotification(song.getValue().getImg(), song.getValue().getName());
        }else System.out.println("cant write");
    }
}
