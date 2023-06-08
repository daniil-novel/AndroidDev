package com.example.pract4;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ClipData.Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<ClipData.Item> items;
    public ListAdapter(Context context, int resource, List<ClipData.Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        ImageView imageView = view.findViewById((android.R.id.icon));
        TextView textView = view.findViewById(android.R.id.text1);
        ClipData.Item item = items.get(position);
        textView.setText(item.getText());
        imageView.setImageResource(R.drawable.rtx4090);
        return view;
    }
}
