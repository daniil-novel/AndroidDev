package com.example.pract7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvPartName, tvLoginResult;
    EditText etEmail, etPassword;
    Button bLogin;
    ProgressBar progressBar;
    Button bGetPart;

    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPartName = findViewById(R.id.tvDrinkName);
        progressBar = findViewById(R.id.progressBar);
        bGetPart = findViewById(R.id.bGetDrink);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvLoginResult = findViewById(R.id.tvLoginResult);
        bLogin = findViewById(R.id.bLogin);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer visibility) {
                progressBar.setVisibility(visibility);
            }
        });

        mViewModel.getDrink().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String drinkName) {
                tvPartName.setText(drinkName);
            }
        });

        bGetPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.suggestNewDrink();
            }
        });

        mViewModel.getLoginResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvLoginResult.setText(s);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.login(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

    }


}