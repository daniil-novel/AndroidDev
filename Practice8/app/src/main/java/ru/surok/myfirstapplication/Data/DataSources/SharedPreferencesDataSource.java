package ru.surok.myfirstapplication.Data.DataSources;

import android.content.Context;
import android.content.SharedPreferences;

import ru.surok.myfirstapplication.R;

public class SharedPreferencesDataSource {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesDataSource(Context context) {
        sharedPreferences = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public void SavePref(String key, boolean bool){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    public boolean getPref(String key){
        return sharedPreferences.getBoolean(key, false);
    }
}
