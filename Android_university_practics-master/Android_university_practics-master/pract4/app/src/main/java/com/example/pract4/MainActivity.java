package com.example.pract4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarOverlayLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_placeholder, MainFragment.class, null)
                .commit();
    }
}