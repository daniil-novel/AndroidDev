package com.example.practice6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "channel_id";
    private final int NOTIFICATION_ID = 1;

    private Button showNotificationButton;
    private TextView mainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNotificationButton = findViewById(R.id.show_notification_button);
        mainTextView = findViewById(R.id.main_textview);

        showNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Пример уведомления")
                .setContentText("Текст уведомления.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void onShowBannerButtonClick(View view) {
        Intent intent = new Intent(this, BannerService.class);
        startService(intent);
    }

    public void stopBannerService() {
        Intent intent = new Intent(this, BannerService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopBannerService();
    }
}
