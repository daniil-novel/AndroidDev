package ru.surok.myfirstapplication.Data.DataSources.room.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.surok.myfirstapplication.Data.DataSources.room.Entity.UserEntity;
import ru.surok.myfirstapplication.Data.DataSources.room.dao.UserDao;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
