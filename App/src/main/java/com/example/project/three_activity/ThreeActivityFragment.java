package com.example.project.three_activity;

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

public class ThreeActivityFragment extends Fragment implements GroupCallBack {

    private int myHour;
    private int myMinute;
    private Date currentTime;
    private int id;
    private int number;


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
        number = getArguments().getInt("номер группы");
        return view;
    }

    @Override
    public void itemClick(People people, int i) {

    }

    public ArrayList<People> getList() {
        ArrayList<People> people = new ArrayList<>();
        if (number == 3) {
            people.add(new People(id, "Гурьянов Вадим", R.drawable.my_ava));
        }
        if (number == 0) {
            people.add(new People(id, "Виталий Грошев", R.drawable.vitalia));
            people.add(new People(id, "Булат Гимазов", R.drawable.bulat));
            people.add(new People(id, "Михаил Счастливцев", R.drawable.mihail));
            people.add(new People(id, "Гурьянов Вадим", R.drawable.my_ava));
        }
        if (number == 1) {
            people.add(new People(id, "Сергей Рыжаков", R.drawable.seriga));
            people.add(new People(id, "Гурьянов Вадим", R.drawable.my_ava));
        }
        return people;
    }

}
