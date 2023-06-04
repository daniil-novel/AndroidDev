package com.example.myapplication7.data.DataSourses;

import com.example.myapplication7.data.MyObject;

import java.util.ArrayList;
import java.util.List;

public class ListFiller {
    public static List<MyObject> createList(int num){
        List<MyObject> objects = new ArrayList<>();
        for (int i = 0; i < num; i++){
            objects.add(new MyObject(i, "hi"));
        }
        return objects;
    }
}
