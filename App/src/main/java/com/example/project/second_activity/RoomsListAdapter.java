package com.example.project.second_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.ArrayList;

public class RoomsListAdapter extends RecyclerView.Adapter<RoomHolder> {

    private RoomListCallBack callBack;
    public static ArrayList<Room> rooms;


    public RoomsListAdapter(ArrayList<Room> rooms, RoomListCallBack callBack) {
        this.callBack = callBack;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rooms_part, viewGroup, false);
        return new RoomHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder roomHolder, int position) {
        roomHolder.bind(rooms.get(position));
        roomHolder.itemView.setOnClickListener(view -> callBack.itemClick(rooms.get(position), position));
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }


}