package ru.surok.myfirstapplication.Data.DataSources.room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name="first_name")
    public String name;

    @ColumnInfo(name="last_name")
    public String lastname;

    @ColumnInfo(name="login")
    public String login;


}
