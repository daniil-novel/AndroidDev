package com.example.practice4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FirstFragment extends Fragment {
    private Button goToSecondFragmentButton;
    private Button goToThirdFragmentButton;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        goToSecondFragmentButton = view.findViewById(R.id.btn_to_fragment_two);
        goToThirdFragmentButton = view.findViewById(R.id.btn_to_fragment_three);

        goToSecondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Going to Second Fragment", Toast.LENGTH_SHORT).show();
                Log.d("FirstFragment", "Going to Second Fragment");
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new SecondFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        goToThirdFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Going to Third Fragment", Toast.LENGTH_SHORT).show();
                Log.d("FirstFragment", "Going to Third Fragment");
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new ThirdFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
