package com.example.project.second_activity;

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

import java.util.ArrayList;
import java.util.Date;

public class RoomsFragment extends Fragment implements RoomListCallBack {

    private int myHour;
    private int myMinute;
    private Date currentTime;
    private int id;
    public static final String TAG = "RoomsFragmentTag";


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

    }

    public ArrayList<Room> getList() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Вадим Гурьянов", "Вадим", "Вадим", "Вадим",
                R.drawable.my_ava, R.drawable.my_ava, R.drawable.reloud, R.drawable.reloud ));
        rooms.add(new Room("Вадим", "Вадим", "Вадим", "Вадим",
                R.drawable.reloud, R.drawable.reloud, R.drawable.reloud, R.drawable.reloud ));
        rooms.add(new Room("Вадим", "Вадим", "Вадим", "Вадим",
                R.drawable.reloud, R.drawable.reloud, R.drawable.reloud, R.drawable.reloud ));
        rooms.add(new Room("Вадим", "Вадим", "Вадим", "Вадим",
                R.drawable.reloud, R.drawable.reloud, R.drawable.reloud, R.drawable.reloud ));
        rooms.add(new Room("Вадим", "Вадим", "Вадим", "Вадим",
                R.drawable.reloud, R.drawable.reloud, R.drawable.reloud, R.drawable.reloud ));
        rooms.add(new Room("Вадим", "Вадим", "Вадим", "Вадим",
                R.drawable.reloud, R.drawable.reloud, R.drawable.reloud, R.drawable.reloud ));
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
