package com.example.pract8;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "string_table")
public class MyString {
    @PrimaryKey
    public int sid;

    @ColumnInfo(name = "my_string")
    public String myString;
}
