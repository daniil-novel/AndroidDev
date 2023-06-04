package com.example.myapplication7.ui.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication7.data.Model;
import com.example.myapplication7.ui.adapters.MyListAdapter;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> EditText = new MutableLiveData<>();

    public LiveData<String> getEditText() {
        return EditText;
    }

    public void updateEditText(String data) {
        EditText.setValue(data);
    }

    private MutableLiveData<String> TextView = new MutableLiveData<>();

    public LiveData<String> getTextView() {
        return TextView;
    }

    public void updateTextView(String data) {
        EditText.setValue(data);
    }


}
