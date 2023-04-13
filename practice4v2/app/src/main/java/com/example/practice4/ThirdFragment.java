package com.example.practice4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ThirdFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> topPlayersList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_third, container, false);

        // Generate list of top players
        for (int i = 1; i <= 200; i++) {
            topPlayersList.add("Player " + i);
        }

        // Set up RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(topPlayersList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
        private List<String> topPlayers;

        public RecyclerViewAdapter(List<String> topPlayers) {
            this.topPlayers = topPlayers;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.playerNameTextView.setText(topPlayers.get(position));
            holder.playerImageView.setImageResource(R.drawable.bug);
        }

        @Override
        public int getItemCount() {
            return topPlayers.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView playerImageView;
            TextView playerNameTextView;

            public MyViewHolder(View itemView) {
                super(itemView);
                playerImageView = itemView.findViewById(R.id.player_image);
                playerNameTextView = itemView.findViewById(R.id.player_name);
            }
        }
    }
}
