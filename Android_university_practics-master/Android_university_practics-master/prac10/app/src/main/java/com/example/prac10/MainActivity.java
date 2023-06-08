package com.example.prac10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ExecutorService pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pool = Executors.newSingleThreadExecutor();
        Button button = findViewById(R.id.exec_service_btn);
        button.setOnClickListener(view -> pool.execute(new NetworkService()));
        Button button1 = findViewById(R.id.worker_btn);
        OneTimeWorkRequest myWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        button1.setOnClickListener(view -> {
            WorkManager.getInstance(getApplicationContext()).enqueue(myWorkRequest);
        });
        WorkManager.getInstance(getApplicationContext()).getWorkInfoByIdLiveData(myWorkRequest.getId())
                .observe(this, workInfo -> Toast.makeText(MainActivity.this, workInfo.getState().toString(), Toast.LENGTH_SHORT).show());
    }
    private class NetworkService implements Runnable {
        private Handler mHandler;
        public NetworkService(){
            mHandler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message inputMessage) {
                    String msg = (String) inputMessage.obj;
                    Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();
                }
            };
        }
        @Override
        public void run() {
            String str = "Imagine that this message from server";
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendMessage(1, str);
        }
        public void sendMessage(int what, String msg) {
            Message message = mHandler.obtainMessage(what , msg);
            message.sendToTarget();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pool.shutdown();
        Log.d("POOL", String.valueOf(pool.isShutdown()));
    }
}