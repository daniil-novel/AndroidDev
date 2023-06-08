package com.example.pract2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle argument = getIntent().getExtras();
        String data = argument.get("Data").toString();
        TextView textView = findViewById(R.id.second);
        textView.append("\n" + data);
        Intent intent = new Intent(this, String.class);
        intent.putExtra("Data", data);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1, intent);
                finish();
            }
        };
        Button button = findViewById(R.id.button_second);
        button.setOnClickListener(listener);
    }
}