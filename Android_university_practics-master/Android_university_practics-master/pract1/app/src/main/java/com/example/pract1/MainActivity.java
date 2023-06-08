package com.example.pract1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        CharSequence text = "Hello onCreate!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onCreate");
        Log.w(TAG, "warning in onCreate");
        Log.i(TAG, "info in onCreate");
        Log.d(TAG, "debug in onCreate");
        Log.v(TAG, "verbose in onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        CharSequence text = "Hello onStart!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onStart");
        Log.w(TAG, "warning in onStart");
        Log.i(TAG, "info in onStart");
        Log.d(TAG, "debug in onStart");
        Log.v(TAG, "verbose in onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Context context = getApplicationContext();
        CharSequence text = "Hello onPause!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onPause");
        Log.w(TAG, "warning in onPause");
        Log.i(TAG, "info in onPause");
        Log.d(TAG, "debug in onPause");
        Log.v(TAG, "verbose in onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Context context = getApplicationContext();
        CharSequence text = "Hello onStop!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onStop");
        Log.w(TAG, "warning in onStop");
        Log.i(TAG, "info in onStop");
        Log.d(TAG, "debug in onStop");
        Log.v(TAG, "verbose in onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        CharSequence text = "Hello onResume!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onResume");
        Log.w(TAG, "warning in onResume");
        Log.i(TAG, "info in onResume");
        Log.d(TAG, "debug in onResume");
        Log.v(TAG, "verbose in onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Context context = getApplicationContext();
        CharSequence text = "Hello onDestroy!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onDestroy");
        Log.w(TAG, "warning in onDestroy");
        Log.i(TAG, "info in onDestroy");
        Log.d(TAG, "debug in onDestroy");
        Log.v(TAG, "verbose in onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Context context = getApplicationContext();
        CharSequence text = "Hello onRestart!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        Log.e(TAG, "error in onRestart");
        Log.w(TAG, "warning in onRestart");
        Log.i(TAG, "info in onRestart");
        Log.d(TAG, "debug in onRestart");
        Log.v(TAG, "verbose in onRestart");
    }
}