package com.example.project.three_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.second_activity.Room;
import com.example.project.second_activity.RoomHolder;
import com.example.project.second_activity.RoomListCallBack;

import java.security.acl.Group;
import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupHolder> {

    private GroupCallBack callBack;
    private ArrayList<People> people;


    public GroupAdapter (ArrayList<People> people, GroupCallBack callBack) {
        this.callBack = callBack;
        this.people = people;
    }

    @NonNull
    @Override
    public GroupHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.people, viewGroup, false);
        return new GroupHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupHolder holder, int position) {
        holder.bind(people.get(position));
        holder.itemView.setOnClickListener(view -> callBack.itemClick(people.get(position), position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

}