package com.example.practice3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textView = view.findViewById(R.id.text_view1);
        ImageView imageView = view.findViewById(R.id.zero_two);
        Button btn1 = view.findViewById(R.id.constraint_layout_button);
        Button btn2 = view.findViewById(R.id.constraint_layout_button2);
        textView.setText(R.string.app_name_Zero);
        imageView.setImageResource(R.drawable.zero_two);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("gg", "button pressed");
                Fragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("gg", "button pressed declarative");
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("gg", "MainFragment: onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("gg", "MainFragment: onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("gg", "MainFragment: onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("gg", "MainFragment: onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("gg", "MainFragment: onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("gg", "MainFragment: onDestroy()");
    }

}
