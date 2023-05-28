package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.surok.myfirstapplication.UI.VIewModels.BottomPlayerViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.VIewModels.SongCoverNameViewModel;
import ru.surok.myfirstapplication.databinding.FragmentSongCoverNameBinding;

public class SongCoverNameFragment extends Fragment {

    private static int album_cover;
    private static String song_name;
    private FragmentSongCoverNameBinding binding;
    private SongCoverNameViewModel model;

    public SongCoverNameFragment() {
        super(R.layout.fragment_song_cover_name);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(SongCoverNameViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSongCoverNameBinding.inflate(inflater, container, false);
        model.getCurrent().observe(getViewLifecycleOwner(), s->{
                binding.songName.setText(s.getName());
                binding.albumImage.setImageResource(s.getImg());
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
