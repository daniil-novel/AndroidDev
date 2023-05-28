package ru.surok.myfirstapplication.Data.DataSources;

public class ListItem {

    private int img;
    private String name;
    private String band;

    public ListItem(String name, String band, int img) {
        this.img = img;
        this.name = name;
        this.band = band;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getBand() {
        return band;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
