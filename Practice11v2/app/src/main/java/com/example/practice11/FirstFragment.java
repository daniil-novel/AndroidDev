package com.example.practice11;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class FirstFragment extends Fragment {

    private Button button1, button2;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle1.putString("amount", "я буратино");
        bundle2.putString("amount", "я Черепаха Тортилла");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.secondFragment, bundle1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_thirdFragment, bundle2);
            }
        });
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.animated_vector);
        AnimatedVectorDrawable animationDrawable = (AnimatedVectorDrawable) imageView.getBackground();
        imageView.setOnClickListener(v -> animationDrawable.start());
        return view;
    }
}