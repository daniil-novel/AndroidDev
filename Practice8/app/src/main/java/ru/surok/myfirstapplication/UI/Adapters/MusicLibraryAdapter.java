package ru.surok.myfirstapplication.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.databinding.CustomListViewBinding;

public class MusicLibraryAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private List<ListItem> data;

    private clickInterface clickInterface;
    private final int resource;
    public MusicLibraryAdapter(Context context, int resource, List<ListItem> items) {
        this.data = items;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    public MusicLibraryAdapter(Context context, int resource){
        data = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    public void setClickInterface(MusicLibraryAdapter.clickInterface clickInterface) {
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(resource, parent, false);
        CustomListViewBinding mBinding = CustomListViewBinding.inflate(LayoutInflater
                .from(parent.getContext()));
        return new MyRecyclerViewAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.binding.listImageView.setImageResource(data.get(position).getImg());
        holder.binding.songNameView.setText(data.get(position).getName());
        holder.binding.songBandView.setText(data.get(position).getBand());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListItem item = data.get(holder.getAdapterPosition());
                SongModel sm = new SongModel(item.getName(), item.getBand(), item.getImg());
                clickInterface.onClick(sm);
            }
        });
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

    public interface clickInterface{
        void onClick(SongModel sm);
    }
}
