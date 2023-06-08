package com.example.pract8;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyStringRepository {
    private MyStringDao myStringDao;
    private LiveData<List<MyString>> myAllStrings;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    MyStringRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        myStringDao = db.stringDao();
        myAllStrings = myStringDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<MyString>> getAllMyStrings() {
        return myAllStrings;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(MyString string) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            myStringDao.insertAll(string);
        });
    }
}
