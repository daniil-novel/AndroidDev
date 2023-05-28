package ru.surok.myfirstapplication.UI.Services;

import android.Manifest;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import ru.surok.myfirstapplication.UI.BroadcastReceivers.MediaBroadcastReceiver;
import ru.surok.myfirstapplication.R;

public class PlayMusicService extends Service implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private NotificationCompat.Builder builder;
    private NotificationManagerCompat notificationManager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();

        Intent testIntent = new Intent(this, MediaBroadcastReceiver.class);
        testIntent.setAction("Test Action");
        testIntent.putExtra("EXTRA_NOTIFICATION_ID", 1);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                testIntent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Action testAction = new NotificationCompat.Action.Builder(
                R.drawable.gear, "Pause", pendingIntent
        ).build();
        MediaSessionCompat mediaSession = new MediaSessionCompat(this, "Player service");
        androidx.media.app.NotificationCompat.MediaStyle mediaStyle =
                new androidx.media.app.NotificationCompat.MediaStyle()
                .setMediaSession(mediaSession.getSessionToken());

        builder = new NotificationCompat.Builder(this,
                getString(R.string.CHANNEL_ID))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Music App")
                .setStyle(mediaStyle);
        builder.addAction(testAction);

        notificationManager = NotificationManagerCompat
                .from(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                == PackageManager.PERMISSION_GRANTED) {
            notificationManager.notify(1, builder.build());
        }

//        mediaPlayer = MediaPlayer.create(getApplicationContext(), bundle.getInt("song"));
//        mediaPlayer.setOnPreparedListener(this);
//        mediaPlayer.prepareAsync();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onPrepared(MediaPlayer player) {
//        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        notificationManager.cancel(1);
    }
}
