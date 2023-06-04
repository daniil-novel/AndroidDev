package com.example.myapplication7.ui.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication7.R;
import com.example.myapplication7.data.DataSourses.ListFiller;
import com.example.myapplication7.data.MyObject;
import com.example.myapplication7.ui.ViewModel.MyViewModel;
import com.example.myapplication7.ui.adapters.MyListAdapter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    private MyViewModel viewModel;
    private ListView listView;
    private EditText editText;
    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        editText = findViewById(R.id.editTextTextPersonName2);
        textView1 = findViewById(R.id.textView);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    viewModel.updateEditText(editText.getText().toString());
                    return true;
                }
                return false;
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        MyListAdapter myListAdapter = new MyListAdapter(getApplicationContext(), ListFiller.createList(10));
        listView.setAdapter(myListAdapter);

        viewModel.getEditText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String data) {
                textView1.setText(data);
            }
        });

    }

}