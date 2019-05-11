package com.example.project.three_activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.second_activity.Room;
import com.example.project.second_activity.RoomsFragment;
import com.example.project.second_activity.RoomsListAdapter;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Date;

import static com.example.project.three_activity.ThreeActivity.number;

public class ThreeActivityFragment extends Fragment implements GroupCallBack {

    private int myHour;
    private int myMinute;
    private Date currentTime;
    private int id;


    public static ThreeActivityFragment newInstance() {
        ThreeActivityFragment fragment = new ThreeActivityFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_fragment, container, false);
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new GroupAdapter(getList(), this);
        recyclerView.setAdapter(adapter);
        id = getArguments().getInt("id");
        return view;
    }

    @Override
    public void itemClick(People people, int i) {
        Uri webpage = Uri.parse("http://www.vk.com/id" + people.getId());
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public ArrayList<People> getList() {
        ArrayList<People> people = new ArrayList<>();
        if (number == 3) {
            people.add(new People(id + "", "Михаил Счастливцев", R.drawable.mihail));
        } else if (number == 0) {
            people.add(new People("325636534", "Гурьянов Вадим", R.drawable.my_ava));
            people.add(new People("115021925", "Булат Гимазов", R.drawable.bulat));
            people.add(new People("105407349", "Виталий Грошев", R.drawable.vitalia));
            people.add(new People(id + "", "Михаил Счастливцев", R.drawable.mihail));
        } else if (number == 1) {
            people.add(new People("71341298", "Сергей Рыжаков", R.drawable.seriga));
            people.add(new People(id + "", "Михаил Счастливцев", R.drawable.mihail));
        }
        return people;
    }

}
