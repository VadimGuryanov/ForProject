package com.example.project.three_activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.project.R;

public class ThreeActivity extends AppCompatActivity {

    private String json = " ";
    private int id;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ThreeActivityFragment threeActivityFragment;
    private TextView tv_time;
    private TextView tv_where_from;
    private TextView tv_where_to;
    public static int number;
    private Button button;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        threeActivityFragment = ThreeActivityFragment.newInstance();
        manager = getSupportFragmentManager();
        id = getIntent().getIntExtra("id", 0);
        number = getIntent().getIntExtra("н", 4);
        String time = getIntent().getStringExtra("время");
        String where_from = getIntent().getStringExtra("откуда");
        String where_to = getIntent().getStringExtra("куда");
        tv_time = findViewById(R.id.time_group);
        tv_where_from = findViewById(R.id.where_from_group);
        tv_where_to = findViewById(R.id.where_to_group);
        tv_time.setText(time);
        tv_where_from.setText(where_from);
        tv_where_to.setText(where_to);
        reloud_group(this.getCurrentFocus());

        button = findViewById(R.id.btn_go);
        button.setBackgroundColor(Color.rgb(215,215,215));

        button.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setText("вызвано");
                button.setBackgroundColor(Color.rgb(255, 187, 51));
            }
        }, 25000);

    }

    public void reloud_group(View view) {
        json = " ";
        if (json != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            threeActivityFragment.setArguments(bundle);
            openFragment(threeActivityFragment);
        }
    }

    private void openFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container_group, fragment)
                .commit();
    }


    public boolean onOptionsItemSelected(MenuItem item){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("")
                    .setMessage("Вы действительно хотите выйти из комнаты?")
                    .setCancelable(false)
                    .setPositiveButton("Да", (dialog, id) -> {onBackPressed();})
                    .setNegativeButton("Отмена",(dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        return true;
    }


}
