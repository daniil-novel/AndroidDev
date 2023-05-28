package ru.surok.myfirstapplication.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.R;

public class MyListViewAdapter extends ArrayAdapter<ListItem> {
    private LayoutInflater inflater;
    private int layout;
    private List<ListItem> items;

    public MyListViewAdapter(Context context, int resource, List<ListItem> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        ListItem item = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView img = view.findViewById(R.id.listImageView);
        img.setImageResource(item.getImg());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView = view.findViewById(R.id.songNameView);
        textView.setText(item.getName());
        return view;
    }

    public void updateData(List<ListItem> items){
        this.items = items;

        notifyDataSetChanged();
    }


}
