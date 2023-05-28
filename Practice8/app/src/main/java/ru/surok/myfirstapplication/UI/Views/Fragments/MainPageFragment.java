package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentMainPageBinding;


public class MainPageFragment extends Fragment {

    public MainPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainPageBinding binding = FragmentMainPageBinding.inflate(inflater, container, false);
        binding.playingTrackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("song_name", "Bloodhail");
                bundle.putInt("album_cover", R.drawable.deathconsciousness);
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_playingSong, bundle);
            }
        });
        return binding.getRoot();
    }
}