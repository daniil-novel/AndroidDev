package ru.surok.myfirstapplication.UI.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.CustomListViewBinding;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<ListItem> data;
    private final int resource;
    public MyRecyclerViewAdapter(Context context, int resource, List<ListItem> items) {
        this.data = items;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    public MyRecyclerViewAdapter(Context context, int resource){
        data = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }
    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(resource, parent, false);
        CustomListViewBinding mBinding = CustomListViewBinding.inflate(LayoutInflater
                .from(parent.getContext()));
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.binding.listImageView.setImageResource(data.get(position).getImg());
        holder.binding.songNameView.setText(data.get(position).getName());
        holder.binding.songBandView.setText(data.get(position).getBand());
    }
    @Override
    public int getItemCount() {
        return data.size();
    }



    public void updateData(List<ListItem> items){
        this.data = items;
        notifyItemRangeChanged(0, items.size());
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CustomListViewBinding binding;

        ViewHolder(View view){
            super(view);
            binding = CustomListViewBinding.bind(view);
        }
    }

}