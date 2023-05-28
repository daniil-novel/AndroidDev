package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.VIewModels.AudioBtViewModel;
import ru.surok.myfirstapplication.databinding.FragmentAudioBtsBinding;

public class AudioBtFragment extends Fragment {

    private FragmentAudioBtsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAudioBtsBinding.inflate(inflater, container, false);
        AudioBtViewModel model = new ViewModelProvider(this).get(AudioBtViewModel.class);
        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_playingSong_to_playingNextFragment);
            }
        });
        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.nextTrack();
            }
        });
        binding.btPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.prevTrack();
            }
        });
        binding.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                model.likeTrack();
//                createFile();
            }
        });
        return binding.getRoot();
    }


}
