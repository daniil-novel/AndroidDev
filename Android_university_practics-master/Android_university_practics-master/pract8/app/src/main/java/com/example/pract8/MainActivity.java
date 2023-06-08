package com.example.pract8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME = "settings.txt";

    private final static String FILE_NAME1 = "settings1.txt";

    private static final String PREF_FILE = "PreferencesName";
    private static final String PREF_NAME = "String3";
    SharedPreferences sharedPreferences;

    AppDatabase db;

    private MyStringViewModel myStringViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        Button save = findViewById(R.id.saveButton4);
        EditText stringBox4 = findViewById(R.id.stringBox4);
        myStringViewModel = new ViewModelProvider(this).get(MyStringViewModel.class);
        myStringViewModel.getAllMyStrings().observe(this, strings -> {
            stringBox4.setText(null);
            if (strings.size() > 0) {
                stringBox4.setHint(strings.get(0).myString);
            }
            else {
                stringBox4.setHint("Enter string to save it in DataBase");
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string4 = stringBox4.getText().toString();

                MyString myString = new MyString();
                myString.sid = 1;
                myString.myString = string4;
                myStringViewModel.insert(myString);
            }
        });
    }

    public void saveString1(View view) {
        FileOutputStream fos = null;
        try {
            EditText stringBox1 = findViewById(R.id.stringBox1);
            String string1 = stringBox1.getText().toString();

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(string1.getBytes());
            Toast.makeText(this, "File is saved", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME1);
    }
    public void saveString2(View view) {
        EditText stringBox2 = findViewById(R.id.stringBox2);
        String string2 = stringBox2.getText().toString();

        try(FileOutputStream fos = new FileOutputStream(getExternalPath())) {
            fos.write(string2.getBytes());
            Toast.makeText(this, "File is saved", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void saveString3(View view) {
        EditText stringBox3 = findViewById(R.id.stringBox3);
        String string3 = stringBox3.getText().toString();

        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(PREF_NAME, string3);
        prefEditor.apply();
    }

    public void getString1(View view) {
        FileInputStream fin = null;
        EditText stringBox1 = findViewById(R.id.stringBox1);
        stringBox1.setText(null);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String string1 = new String (bytes);
            stringBox1.setHint(string1);
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void getString2(View view) {
        EditText stringBox2 = findViewById(R.id.stringBox2);
        stringBox2.setText(null);
        File file = getExternalPath();
        // если файл не существует, выход из метода
        if(!file.exists()) return;
        try(FileInputStream fin =  new FileInputStream(file)) {
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String string2 = new String (bytes);
            stringBox2.setHint(string2);
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void getString3(View view) {
        EditText stringBox3 = findViewById(R.id.stringBox3);
        stringBox3.setText(null);
        stringBox3.setHint(sharedPreferences.getString(PREF_NAME, "default_value_from_sharedPreferences"));
    }
}