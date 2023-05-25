package com.example.practice6;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;


    public class BannerService extends Service {

        private static final String NOTIFICATION_CHANNEL_ID = "banner_notification_channel";
        private static final int REQUEST_CODE = 100;

        private WindowManager mWindowManager;
        private View mBannerView;
        private String mNotificationTitle;
        private String mNotificationText;
        private PendingIntent mPendingIntent;
        private ActivityResultLauncher<String> mRequestPermissionLauncher;

        @Override
        public void onCreate() {
            super.onCreate();
            createNotificationChannel();
            mRequestPermissionLauncher = requestOverlayPermission(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    stopSelf();
                } else {
                    showBannerView();
                }
            });
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            mNotificationTitle = intent.getStringExtra("notification_title");
            mNotificationText = intent.getStringExtra("notification_text");
            mPendingIntent = intent.getParcelableExtra("pending_intent");
            if (checkSelfPermission(Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED) {
                mRequestPermissionLauncher.launch(Manifest.permission.SYSTEM_ALERT_WINDOW);
            } else {
                showBannerView();
            }
            return START_NOT_STICKY;
        }

        private void showBannerView() {
            mBannerView = LayoutInflater.from(this).inflate(R.layout.banner_layout, null);
            TextView titleView = mBannerView.findViewById(R.id.notification_title);
            titleView.setText(mNotificationTitle);
            TextView textView = mBannerView.findViewById(R.id.notification_message);
            textView.setText(mNotificationText);
            mBannerView.setOnClickListener(v -> {
                try {
                    mPendingIntent.send();
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
            });
            WindowManager.LayoutParams params;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                params = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                        PixelFormat.TRANSLUCENT);
            } else {
                params = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                        PixelFormat.TRANSLUCENT);
            }
            params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
            mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
            mWindowManager.addView(mBannerView, params);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();

            if (mWindowManager != null && mBannerView != null) {
                mWindowManager.removeView(mBannerView);
            }
        }

        private void createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = getString(R.string.notification_channel_name);
                String description = getString(R.string.notification_channel_description);
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                channel.setDescription(description);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }


    private void hideBannerView() {
        // Удаляем вью из WindowManager
        mWindowManager.removeView(mBannerView);
    }

    private void requestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, REQUEST_CODE);
        } else {
            showBannerView();
        }
    }
}
