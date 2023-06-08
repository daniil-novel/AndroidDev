package com.example.pract2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textViewMain);
        textView.setText(R.string.text_view);
        ImageView imageView = findViewById(R.id.imageViewMain);
        imageView.setImageResource(R.drawable.rtx4090);
        Intent intent = new Intent(this, SecondActivity.class);
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Bundle argument = result.getData().getExtras();
                        String data = argument.get("Data").toString();
                        textView.append("\nData return from second activity:\n\""+data+"\"");
                    }
                });
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Prog","Start second activity!");
                intent.putExtra("Data","This is data from Main");
                mStartForResult.launch(intent);
            }
        };
        Button button = findViewById(R.id.buttonMain);
        button.setOnClickListener(listener);
    }

    //public void msg_in_Log(View view) { Log.i("Decl","Click on button!"); }
}