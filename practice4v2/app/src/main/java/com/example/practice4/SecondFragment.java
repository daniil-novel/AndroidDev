package com.example.practice4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class SecondFragment extends Fragment {
    private ListView topPlayersListView;
    private String[] topPlayers = {"Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6", "Player 7", "Player 8", "Player 9", "Player 10"};

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        topPlayersListView = view.findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, topPlayers);
        topPlayersListView.setAdapter(adapter);

        topPlayersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String playerName = topPlayers[position];
                Toast.makeText(getContext(), "Clicked on " + playerName, Toast.LENGTH_SHORT).show();
                Log.d("SecondFragment", "Clicked on " + playerName);
            }
        });

        return view;
    }
}
