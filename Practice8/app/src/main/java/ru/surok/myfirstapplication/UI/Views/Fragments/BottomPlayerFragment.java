package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Iterator;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.UI.VIewModels.BottomPlayerViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentBottomPlayerBinding;

public class BottomPlayerFragment extends Fragment {

    private BottomPlayerViewModel model;

    public BottomPlayerFragment() {
        super(R.layout.fragment_bottom_player);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(BottomPlayerViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentBottomPlayerBinding binding = FragmentBottomPlayerBinding.inflate(inflater, container,
                false);
        model.getSong().observe(getViewLifecycleOwner(), s ->{
            binding.songName.setText(s.getName());
            binding.songBand.setText(s.getBand());
            binding.songCover.setImageResource(s.getImg());
        });
        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.nextTrack();
            }
        });
        return binding.getRoot();
    }
}
