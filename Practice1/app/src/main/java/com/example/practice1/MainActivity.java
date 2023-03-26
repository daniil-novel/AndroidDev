package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.e("onCreate", "error in onCreate");
        Log.w("onCreate", "warning in onCreate");
        Log.i("onCreate", "info in onCreate");
        Log.d("onCreate", "debug in onCreate");
        Log.v("onCreate", "verbose in onCreate");
    }

    public void b_exitClick(View view) {
        System.exit(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.e("onStart", "error in onStart");
        Log.w("onStart", "warning in onStart");
        Log.i("onStart", "info in onStart");
        Log.d("onStart", "debug in onStart");
        Log.v("onStart", "verbose in onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.e("onPause", "error in onPause");
        Log.w("onPause", "warning in onPause");
        Log.i("onPause", "info in onPause");
        Log.d("onPause", "debug in onPause");
        Log.v("onPause", "verbose in onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.e("onStop", "error in onStop");
        Log.w("onStop", "warning in onStop");
        Log.i("onStop", "info in onStop");
        Log.d("onStop", "debug in onStop");
        Log.v("onStop", "verbose in onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.e("onResume", "error in onResume");
        Log.w("onResume", "warning in onResume");
        Log.i("onResume", "info in onResume");
        Log.d("onResume", "debug in onResume");
        Log.v("onResume", "verbose in onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.e("onDestroy", "error in onDestroy");
        Log.w("onDestroy", "warning in onDestroy");
        Log.i("onDestroy", "info in onDestroy");
        Log.d("onDestroy", "debug in onDestroy");
        Log.v("onDestroy", "verbose in onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
        Log.e("onRestart", "error in onRestart");
        Log.w("onRestart", "warning in onRestart");
        Log.i("onRestart", "info in onRestart");
        Log.d("onRestart", "debug in onRestart");
        Log.v("onRestart", "verbose in onRestart");
    }
}
