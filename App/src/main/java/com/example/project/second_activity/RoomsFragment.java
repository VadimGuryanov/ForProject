package com.example.project.second_activity;

import android.content.Intent;
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
import com.example.project.three_activity.ThreeActivity;

import java.util.ArrayList;

public class RoomsFragment extends Fragment implements RoomListCallBack {

    private int id;


    public static RoomsFragment newInstance() {
        RoomsFragment fragment = new RoomsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rooms_fragment, container, false);
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RoomsListAdapter(getList(), this);
        recyclerView.setAdapter(adapter);
        id = getArguments().getInt("id");
        return view;
    }

    @Override
    public void itemClick(Room room, int i) {
        Intent intent = new Intent(this.getContext(), ThreeActivity.class);
        intent.putExtra("номер", i);
        startActivity(intent);
    }

    public ArrayList<Room> getList() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Виталий Грошев", "Булат Гимазов", "Михаил Счастливцев", R.drawable.vitalia,
                R.drawable.bulat, R.drawable.mihail));
        rooms.add(new Room("Сергей Рыжаков", null, null, R.drawable.seriga,
                0, 0));
        return rooms;
    }


//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(v.getContext(), ListGroupActivity.class);
//        intent.putExtra("id", this.id);
//        startActivity(intent);
//    }
//
//    private void openFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.container_main, fragment)
//                .commit();
//    }

}
