package com.example.practice11;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_third, container, false);*/
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        TextView tv = view.findViewById(R.id.textView);
        tv.setText(getArguments().getString("amount"));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(getActivity(),
                "onStart", Toast.LENGTH_SHORT);
        toast.show();
        Log.i("life", "third start");
    }
}