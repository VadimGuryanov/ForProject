package com.example.project.second_activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.project.R;

public class ListGroupActivity extends AppCompatActivity{

    private TextView tv_time;
    private TextView tv_where_from;
    private TextView tv_where_to;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private RoomsFragment roomsFragment;
    private EmptyFragment emptyFragment;
    private String json;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_group_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Такси");
        id = getIntent().getIntExtra("id", 0);
        int people = getIntent().getIntExtra("сколько вас", 0);
        String time = getIntent().getStringExtra("время");
        String where_from = getIntent().getStringExtra("откуда");
        String where_to = getIntent().getStringExtra("куда");
        tv_time = findViewById(R.id.time_group);
        tv_where_from = findViewById(R.id.where_from_group);
        tv_where_to = findViewById(R.id.where_to_group);
        tv_time.setText(time);
        tv_where_from.setText(where_from);
        tv_where_to.setText(where_to);
        manager = getSupportFragmentManager();
        roomsFragment = RoomsFragment.newInstance();
        emptyFragment = EmptyFragment.newInstance();
        onClick(this.getCurrentFocus());

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void onClick(View view) {
        json = "  ";
        if (json != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                roomsFragment.setArguments(bundle);
                openFragment(roomsFragment);
        } else {
                openFragment(emptyFragment);
        }
    }

    private void openFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment)
                .commit();
    }




    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }


}
