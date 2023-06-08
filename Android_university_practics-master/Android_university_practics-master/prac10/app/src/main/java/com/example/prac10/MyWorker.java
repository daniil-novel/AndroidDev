package com.example.prac10;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.TimeUnit;

public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            TimeUnit.SECONDS.sleep(10);
            return Result.success();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
