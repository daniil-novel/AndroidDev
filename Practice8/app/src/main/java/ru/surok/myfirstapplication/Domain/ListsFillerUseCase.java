package ru.surok.myfirstapplication.Domain;

import java.util.ArrayList;
import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.R;

public class ListsFillerUseCase {

    public List<ListItem> generateList(){
        List<ListItem> list = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            list.add(new ListItem("Sample Text", "Sample Text", R.drawable.deathconsciousness));
        }
        return list;
    }
}
