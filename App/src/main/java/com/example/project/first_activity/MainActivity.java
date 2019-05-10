package com.example.project.first_activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.IdSaver;
import com.example.project.R;
import com.example.project.second_activity.ListGroupActivity;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private int id;
    private IdSaver idSaver;
    private int myHour;
    private int myMinute;
    private Date currentTime;
    private TimePicker timePicker;
    private TextView where_to;
    private TextView where_from;
    private RadioGroup radioGroup;
    private int btn_radio = 1;
    private Spinner spinner_to;
    private Spinner spinner_from;
    private int position_to = 0;
    private int position_from = 0;
    private ArrayAdapter<String> list_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        try {
            idSaver = new IdSaver(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        id = Integer.parseInt(idSaver.getText());

        if (id < 1) VK.login(this);
//        VKUserGet userGet = new VKUserGet();
//        userGet.get(id);
//        String name = userGet.getName();
//        where_to.setText(name);

        currentTime = Calendar.getInstance().getTime();
        myHour = currentTime.getHours();
        myMinute = currentTime.getMinutes();
        timePicker = findViewById(R.id.timePicker);
        timePicker.setCurrentHour(myHour);
        timePicker.setCurrentMinute(myMinute);
        timePicker.setIs24HourView(true);
//        where_from = findViewById(R.id.et_where_from);
//        where_to = findViewById(R.id.et_where_to);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Такси");
        RadioButton radioButton = findViewById(R.id.cb_1);
        radioButton.setChecked(true);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.cb_1:
                    btn_radio = 1;
                    break;
                case R.id.cb_2:
                    btn_radio = 2;
                    break;
                case R.id.cb_3:
                    btn_radio = 3;
                    break;
            }
        });

        String[] alert = { "DY", "Двойка", "Казань Арена", "Токмач"};
        spinner_to = findViewById(R.id.spinner_to);
        list_place = new ArrayAdapter<>(
                getApplicationContext(), android.R.layout.simple_spinner_item,
                alert);
        spinner_to.setAdapter(list_place);
        spinner_from = findViewById(R.id.spinner_from);
        spinner_from.setAdapter(list_place);
        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position_to = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position_from = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VK.onActivityResult(requestCode, resultCode, data, new VKAuthCallback() {
            @Override
            public void onLogin(VKAccessToken res) {
                int id = res.getUserId();
                idSaver.saveText(String.valueOf(id));
            }
            @Override
            public void onLoginFailed(int error) {
                finish();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ListGroupActivity.class);
        intent.putExtra("id", this.id);
        int h = timePicker.getHour();
        int m = timePicker.getMinute();
        String m_str = m + "";
        if (m < 10) m_str = "0" + m_str;
        intent.putExtra("время", h + ":" + m_str);
        intent.putExtra("откуда",  list_place.getItem(position_from).toString());
        intent.putExtra("куда",  list_place.getItem(position_to).toString());
        intent.putExtra("сколько вас", btn_radio);
        startActivity(intent);
    }

//                intent.putExtra("id", id);
//                startActivity(intent);
//                int id = res.getUserId();
//                idSaver.saveText(String.valueOf(id));
//                Bundle bundle = new Bundle();
//                bundle.putInt("id", id);
//                StartFragment startFragment = StartFragment.newInstance();
//                startFragment.setArguments(bundle);
//                openFragment(startFragment);


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


    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (!VK.onActivityResult(requestCode, resultCode, data, new VKAuthCallback() {
//            @Override
//            public void onLogin(VKAccessToken res) {
//                Toast.makeText(getApplicationContext(), res.getUserId().toString(), Toast.LENGTH_SHORT).show();
//
//            }
//            @Override
//            public void onLoginFailed(int error) {
//                finish();
//            }
//        })) {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }


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


//    public void onClick(View v) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//            builder.setTitle("")
//                    .setMessage("Мы едем?")
//                    .setCancelable(false)
//                    .setPositiveButton("Да",
//                            (dialog, id) -> {
//                                    Toast.makeText(v.getContext(), "поиск групп...", Toast.LENGTH_SHORT).show();
//                                    go(v);
//                                }
//                            )
//                    .setNegativeButton("Отмена",
//                            (dialog, id) -> dialog.cancel());
//            AlertDialog alert = builder.create();
//            alert.show();
//    }
//
//    public void onTimeClick(View view) {
//        showDialog(DIALOG_TIME);
//    }
//
//    protected Dialog onCreateDialog(int id) {
//        if (id == DIALOG_TIME) {
//            TimePickerDialog tpd = new TimePickerDialog(this, theme, myCallBack, myHour, myMinute, true);
//            return tpd;
//        }
//        return super.onCreateDialog(id);
//    }
//
//    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//            myHour = hourOfDay;
//            myMinute = minute;
//            editText.setText(myHour + ":" + myMinute);
//        }
//    };


}
