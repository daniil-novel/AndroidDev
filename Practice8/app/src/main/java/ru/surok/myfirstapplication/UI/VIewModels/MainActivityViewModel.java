package ru.surok.myfirstapplication.UI.VIewModels;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.DataSources.room.Entity.SongEntity;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;
import ru.surok.myfirstapplication.R;

public class MainActivityViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(application);
        trackRepository.addSong(new SongModel(null, null, 0));
    }

    public void dropDB(){
        trackRepository.deleteAll();
    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getApplication().getString(R.string.CHANNEL_NAME);
            String description = getApplication().getString(R.string.CHANNEL_DESCRIPTION);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getApplication().getString(R.string.CHANNEL_ID), name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getApplication().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
