package ru.surok.myfirstapplication.Domain;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public class ListSongModelToListListItem {
    public static List<ListItem> changeToIter(ListIterator<SongModel>items){
        List<ListItem> li = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            items.forEachRemaining(e->li.add(new ListItem(e.getName(), e.getBand(), e.getImg())));
        }
        return li;
    }

    public static List<ListItem> changeToList(List<SongModel> items){
        List<ListItem> li = new ArrayList<>();
        for (SongModel sm : items){
            li.add(new ListItem(sm.getName(), sm.getBand(), sm.getImg()));
        }
        return li;
    }
}
