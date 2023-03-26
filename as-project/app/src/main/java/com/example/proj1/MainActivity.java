package com.example.proj1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = findViewById(R.id.BtnClick);
        txt.setBackgroundColor(getResources().getColor(R.color.purple_200));
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //txt.setText(count); // надо создать отдельный поток
                count++;
                System.out.println(count);



            }
        });
        txt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                txt.setBackgroundColor(getResour ces().getColor(R.color.purple_500));


                return false;
            }
        });
    }
}