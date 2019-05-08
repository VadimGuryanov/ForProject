package com.example.project;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private int DIALOG_TIME = 1;
    private int theme = 3;
    private int myHour;
    private int myMinute;
    private EditText editText;
    private Date currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button bnt = findViewById(R.id.btn_mainAct);
        editText = findViewById(R.id.et_time);
        currentTime = Calendar.getInstance().getTime();
        myHour = currentTime.getHours();
        myMinute = currentTime.getMinutes();
        if (myMinute < 10) {
            editText.setText(myHour + ":0" + myMinute);
        } else {
            editText.setText(myHour + ":" + myMinute);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void go(View view) {
        Intent intent = new Intent(view.getContext(), ListGroupActivity.class);

//        TextView text = findViewById(R.id.textView);
//        EditText editText = findViewById(R.id.editText);
//        try {
//            text.setText(new MyNetThread().execute(editText.getText().toString()).get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        intent.putExtra("name", event.getName());
//        intent.putExtra("point", event.getPoint());
//        intent.putExtra("image", event.getImage());
//        intent.putExtra("index", i);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }

//    public boolean onOptionsItemSelected(MenuItem item){
//        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivityForResult(myIntent, 0);
//        return true;
//    }

    /*
    public void click(View v) {
        TextView text = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        try {
            text.setText(new MyNetThread().execute(editText.getText().toString()).get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    */


    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("")
                    .setMessage("Мы едем?")
                    .setCancelable(false)
                    .setPositiveButton("Да",
                            (dialog, id) -> {
                                    Toast.makeText(v.getContext(), "поиск групп...", Toast.LENGTH_SHORT).show();
                                    go(v);
                                }
                            )
                    .setNegativeButton("Отмена",
                            (dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
    }

    public void onTimeClick(View view) {
        showDialog(DIALOG_TIME);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, theme, myCallBack, myHour, myMinute, true);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            editText.setText(myHour + ":" + myMinute);
        }
    };


}
