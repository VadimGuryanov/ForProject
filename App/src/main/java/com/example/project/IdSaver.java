package com.example.project;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

public class IdSaver {

    private Context context;

//    public String id_str = "id";

    private final String ID = "id";
    private final String nameKey = "custom_id";

    private SharedPreferences sharedPrefs;

    public IdSaver(Context context) throws IOException {
        this.context = context;
    }

    public void saveText(String value) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(nameKey, value);
        editor.apply();
    }

    public String getText() {
        sharedPrefs = context.getSharedPreferences(ID, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(nameKey)) {
            return (sharedPrefs.getString(nameKey, ""));
        } return "-1";
    }


}
