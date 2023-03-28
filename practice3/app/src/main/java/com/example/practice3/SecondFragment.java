package com.example.practice3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("gg", "SecondFragment: onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("gg", "SecondFragment: onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("gg", "SecondFragment: onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("gg", "SecondFragment: onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("gg", "SecondFragment: onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("gg", "SecondFragment: onDestroy()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button btn2 = view.findViewById(R.id.constraint_layout_button_exc);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("gg", "SecondFragment: button pressed");
                Toast.makeText(getContext(), "SecondFragment: button pressed", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}
