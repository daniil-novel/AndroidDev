package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private String mSubjectArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn2 = this.findViewById(R.id.constraint_layout_button_exc);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("gg", "button pressed");
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("","");
                startActivityForResult(intent, 1);
            }
        });
/*
        Intent intent = getIntent();
        mSubjectArea = intent.getStringExtra("subject_area");
*/

    }
}
