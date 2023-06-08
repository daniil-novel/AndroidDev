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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class Fragment1 extends Fragment {

    private NavController navController;
    private SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("amount", "Дата передается");
                navController.navigate(R.id.action_fragment1_to_fragment2, bundle);
            }
        });
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.animated_vector);
        AnimatedVectorDrawable animationDrawable = (AnimatedVectorDrawable) imageView.getBackground();
        imageView.setOnClickListener(v -> animationDrawable.start());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
}
