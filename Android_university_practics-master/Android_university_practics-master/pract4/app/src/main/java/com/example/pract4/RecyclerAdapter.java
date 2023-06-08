package com.example.pract4;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<ClipData.Item> items;
    private OnClickListener mOnClickListener;

    RecyclerAdapter(Context context, List<ClipData.Item> items, OnClickListener onClickListener) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.mOnClickListener = onClickListener;
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(android.R.layout.activity_list_item, parent, false);
        return new ViewHolder(view, mOnClickListener);
    }
    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        ClipData.Item item = items.get(position);
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(R.drawable.rtx4090);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView textView;
        final ImageView imageView;
        OnClickListener onClickListener;
        ViewHolder(View view, OnClickListener onClickListener){
            super(view);
            textView = view.findViewById(android.R.id.text1);
            imageView = view.findViewById(android.R.id.icon);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
