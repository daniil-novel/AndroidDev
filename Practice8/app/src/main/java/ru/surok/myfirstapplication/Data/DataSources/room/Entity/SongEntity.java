package ru.surok.myfirstapplication.Data.DataSources.room.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import ru.surok.myfirstapplication.Data.Models.SongModel;

@Entity(tableName = "songs")
public class SongEntity {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="band")
    public String band;

    @ColumnInfo(name="img")
    public int img;

    public SongEntity() {
    }

    public SongEntity(@NotNull String name, @NotNull String band, int img) {
        this.name = name;
        this.band = band;
        this.img = img;
    }

    public SongModel toDomainModel(){
        return new SongModel(name, band, img);
    }

}
