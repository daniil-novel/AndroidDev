package com.example.pract8;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyStringViewModel extends AndroidViewModel {

    private MyStringRepository mRepository;

    private final LiveData<List<MyString>> mAllMyStrings;

    public MyStringViewModel (Application application) {
        super(application);
        mRepository = new MyStringRepository(application);
        mAllMyStrings = mRepository.getAllMyStrings();
    }

    LiveData<List<MyString>> getAllMyStrings() { return mAllMyStrings; }

    public void insert(MyString string) { mRepository.insert(string); }
}
