package com.example.pract6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;
    private final String CHANNEL_ID="channelID";

    private Intent intent;

    @Override
    @SuppressLint("MissingPermission")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(getApplicationContext(), ChatHeadService.class);
        Button button = findViewById(R.id.message_btn);
        Button button1 = findViewById(R.id.service_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notificationText = "This text using in this message";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle(getString(R.string.notification_title))
                        .setContentText(notificationText)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(NOTIFY_ID, builder.build());
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SYSTEM_ALERT_WINDOW}, 100);
            }
        }
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {}
                else {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SYSTEM_ALERT_WINDOW}, 100);
                }
                return;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }

}