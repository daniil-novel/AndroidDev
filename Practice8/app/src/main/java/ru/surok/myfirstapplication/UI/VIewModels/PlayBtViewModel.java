package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;
import ru.surok.myfirstapplication.R;

public class PlayBtViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;
    private LiveData<SongModel> songFromDB = new MutableLiveData<>();
    public PlayBtViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(application);
        songFromDB = trackRepository.getSongFromDB("Song A", "Band A");
    }

    public LiveData<SongModel> getSong(){
        return songFromDB;
    }

    public void play(){
        trackRepository.getDatabaseData();
        System.out.println("hello playbtviewmodel");
//        trackRepository.addSong(new SongModel("BloodHail", "Have A Nice Life", R.drawable.deathconsciousness));
    }

    //    private void showPlayingSongNotification(){
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(),
//                getString(R.string.CHANNEL_ID))
//                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setContentTitle(getString(R.string.next_track))
//                .setContentText(binding.playBtTextview.getText())
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        NotificationManagerCompat notificationManager = NotificationManagerCompat
//                .from(getActivity());
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.POST_NOTIFICATIONS)
//                == PackageManager.PERMISSION_GRANTED) {
//            notificationManager.notify(1, builder.build());
//        }
//    }

}
