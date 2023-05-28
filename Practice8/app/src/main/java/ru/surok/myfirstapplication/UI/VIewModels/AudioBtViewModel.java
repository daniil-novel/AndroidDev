package ru.surok.myfirstapplication.UI.VIewModels;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.ExternalInternalStorageRepository;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;
import ru.surok.myfirstapplication.R;

public class AudioBtViewModel extends AndroidViewModel {
    private final TrackRepository trackRepository;
    private final ExternalInternalStorageRepository storageRepository;

    public AudioBtViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(getApplication());
        this.storageRepository = new ExternalInternalStorageRepository(application.getApplicationContext());
    }

    public void nextTrack(){
        trackRepository.nextTrack();
    }

    public void prevTrack(){
        trackRepository.prevTrack();
    }

    public void likeTrack(){
        SongModel song = trackRepository.getCurrent().getValue();
        if (song != null){
            storageRepository.likeTrack(song);
        }
        storageRepository.createFile(getApplication());
    }


//    private void showLickedNotification(int img, String name){
//        Bitmap icon = BitmapFactory.decodeResource(getApplication().getResources(), img);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplication(),
//                getApplication().getString(R.string.CHANNEL_ID))
//                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setLargeIcon(icon)
//                .setContentTitle("You licked it")
//                .setContentText(name)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        NotificationManagerCompat notificationManager = NotificationManagerCompat
//                .from(getApplication());
//        if (ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.POST_NOTIFICATIONS)
//                == PackageManager.PERMISSION_GRANTED) {
//            notificationManager.notify(1, builder.build());
//        }
//    }
}
