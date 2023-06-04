package com.example.myapplication7.data;

import android.content.Context;


import com.example.myapplication7.ui.adapters.MyListAdapter;

import java.util.ArrayList;

public class Model {

    private ArrayList<MyObject> myData;
    private MyListAdapter adapter;

    public Model()
    {
        myData = new ArrayList<>();
        myData.add(new MyObject(0, "Hello World"));
    }

    public ArrayList<MyObject> getMyData() {
        return myData;
    }

    public void addMyData(String string)
    {
        myData.add(new MyObject(myData.size(), string));
    }

    public MyListAdapter getAdapter(Context context)
    {
        adapter = new MyListAdapter(context, myData);
        return adapter;
    }
}
