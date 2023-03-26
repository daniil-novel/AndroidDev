package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Скрыть заголовок
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Сделать экран полноэкранным
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Создать FrameLayout для содержания GameView
        FrameLayout frameLayout = new FrameLayout(this);
        // Сделать GameView размером устройства
        gameView = new GameView(this);
        frameLayout.addView(gameView);
        setContentView(frameLayout);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}}