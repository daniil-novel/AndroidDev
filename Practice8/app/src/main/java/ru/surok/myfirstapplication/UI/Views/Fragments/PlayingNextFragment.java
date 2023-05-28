package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Domain.ListSongModelToListListItem;
import ru.surok.myfirstapplication.Domain.ListsFillerUseCase;
import ru.surok.myfirstapplication.UI.Adapters.MyListViewAdapter;
import ru.surok.myfirstapplication.UI.Adapters.MyRecyclerViewAdapter;
import ru.surok.myfirstapplication.UI.VIewModels.PlayingNextViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentPlayingNextBinding;

public class PlayingNextFragment extends Fragment {

    private FragmentPlayingNextBinding binding;
    private PlayingNextViewModel model;


    public PlayingNextFragment() {
        super(R.layout.fragment_playing_next);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayingNextBinding.inflate(inflater,
                container, false);
        model = new ViewModelProvider(this)
                .get(PlayingNextViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.playingNextList.setAdapter(new MyRecyclerViewAdapter(getActivity(), R.layout.custom_list_view));

        model.getCurrent().observe(getViewLifecycleOwner(), song->{
            int index = model.getSongs().getValue().indexOf(song) +1;
            List<ListItem> temp = ListSongModelToListListItem.changeToIter(
            model.getSongs().getValue().listIterator(index));
            ((MyRecyclerViewAdapter) binding.playingNextList.getAdapter()).updateData(temp);
        });
    }
}