package com.example.practice2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = this.findViewById(R.id.text_view1);
        ImageView imageView = this.findViewById(R.id.zero_two);
        Button btn2 = this.findViewById(R.id.constraint_layout_button2);
        textView.setText(R.string.app_name_Zero);
        imageView.setImageResource(R.drawable.zero_two);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("gg", "button pressed");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("","");
                startActivityForResult(intent, 1);
            }
        });
    }
    public void onClick(View view){
        Log.d("gg", "button pressed declarative");

   }


}