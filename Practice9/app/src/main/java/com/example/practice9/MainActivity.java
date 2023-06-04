package com.example.practice9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textMessage = findViewById(R.id.message);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.text);
        button.setOnClickListener(view -> {
            String message = textMessage.getText().toString();
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            shareIntent.setType("text/plain");
            startActivity(Intent.createChooser(shareIntent, "Поделиться с друзьями:)"));
        });

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent, textView);
            }
        }
    }

    void handleSendText(Intent intent, TextView textView) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            textView.setText(sharedText);
        }
    }
}