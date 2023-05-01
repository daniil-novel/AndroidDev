package com.example.practice6;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class BannerService extends Service {

    private WindowManager mWindowManager;
    private View mBannerView;
    private String mNotificationTitle;
    private String mNotificationText;
    private PendingIntent mPendingIntent;

    // Константа для запроса разрешения на использование сервиса оверлея
    private static final int REQUEST_CODE = 101;

    @Override
    public void onCreate() {
        super.onCreate();

        // Проверяем разрешение на использование сервиса оверлея
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                // Разрешение уже предоставлено, создаем вью и отображаем ее
                showBannerView();
            } else {
                // Запрашиваем разрешение у пользователя
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        } else {
            // Разрешения не требуются для Android версии ниже 6.0, создаем вью и отображаем ее
            showBannerView();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mNotificationTitle = intent.getStringExtra("notification_title");
        mNotificationText = intent.getStringExtra("notification_text");
        mPendingIntent = intent.getParcelableExtra("notification_intent");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Возвращаем null, поскольку сервис не поддерживает привязку
        return null;
    }

    private void showBannerView() {
        // Создаем новую вью для отображения баннера
        mBannerView = LayoutInflater.from(this).inflate(R.layout.banner_layout, null);

        // Устанавливаем текст заголовка и текст уведомления
        TextView titleView = mBannerView.findViewById(R.id.notification_title);
        titleView.setText(mNotificationTitle);
        TextView textView = mBannerView.findViewById(R.id.notification_message);
        textView.setText(mNotificationText);

        // Устанавливаем PendingIntent для перехода к запущенному приложению
        mBannerView.setOnClickListener(v -> {
            try {
                mPendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        });

        // Устанавливаем параметры для отображения баннера
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

        // Устанавливаем расположение баннера
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;

        // Добавляем вью в WindowManager и отображаем ее
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager

                .addView(mBannerView, params);
    }
}
