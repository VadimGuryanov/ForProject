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
import com.example.project.first_activity.MainActivity;
import com.example.project.three_activity.ThreeActivity;

import java.util.ArrayList;
import java.util.List;

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
        intent.putExtra("н", i);
        intent.putExtra("время", ListGroupActivity.tv_time.getText());
        intent.putExtra("откуда", ListGroupActivity.tv_where_from.getText());
        intent.putExtra("куда", ListGroupActivity.tv_where_to.getText());
        startActivity(intent);
    }

    public ArrayList<Room> getList() {

        ArrayList<Room> rooms = new ArrayList<>();
        String[] names = new String[MainActivity.usersMap.size()];
        for(int i = 0; i < names.length; i++) {
            names[i] = MainActivity.usersMap.get(i).get("first_name").toString() + " " +
                    MainActivity.usersMap.get(i).get("last_name").toString();
        }
//        rooms.add(new Room(names[0], names[1], "Занято", "",  // name - имена
//                R.drawable.my_ava, R.drawable.my_ava, R.drawable.reloud, R.drawable.reloud ));
//        rooms.add(new Room(names[2], names[3], names[4], "",
//                R.drawable.reloud, R.drawable.reloud, R.drawable.reloud, R.drawable.reloud ));


        rooms.add(new Room(names[0], names[1], names[2], R.drawable.my_ava,
                R.drawable.bulat, R.drawable.vitalia));
        rooms.add(new Room(names[3], names[4], null, R.drawable.seriga,
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
