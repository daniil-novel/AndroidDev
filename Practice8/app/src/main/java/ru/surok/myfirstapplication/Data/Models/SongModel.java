package ru.surok.myfirstapplication.Data.Models;

public class SongModel {

    private final String name;
    private final String band;
    private final int img;

    public SongModel(String name, String band, int img) {
        this.name = name;
        this.band = band;
        this.img = img;
    }

    public SongModel(SongModel model) {
        this.name = model.getName();
        this.band = model.getBand();
        this.img = model.getImg();
    }

    public String getName() {
        return name;
    }

    public String getBand() {
        return band;
    }

    public int getImg() {
        return img;
    }
}
