package com.example.project.three_activity;

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

public class ThreeActivity extends AppCompatActivity {

    private String json = " ";
    private int id;
    private int number;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ThreeActivityFragment threeActivityFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        threeActivityFragment = ThreeActivityFragment.newInstance();
        manager = getSupportFragmentManager();
        id = getIntent().getIntExtra("id", 0);
        number = getIntent().getIntExtra("номер", 0);
        reloud_group(this.getCurrentFocus());
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    public void reloud_group(View view) {
        json = " ";
        if (json != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            bundle.putInt("номер группы", number);
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
        onBackPressed();
        return true;
    }


}
