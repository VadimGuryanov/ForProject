package com.example.project.second_activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

public class RoomHolder extends RecyclerView.ViewHolder {

    private TextView name1;
    private ImageView image1;
    private TextView name2;
    private ImageView image2;
    private TextView name3;
    private ImageView image3;

    public RoomHolder(@NonNull View itemView) {
        super(itemView);
        this.name1 = itemView.findViewById(R.id.name1);
        this.name2 = itemView.findViewById(R.id.name2);
        this.name3 = itemView.findViewById(R.id.name3);
        this.image1 = itemView.findViewById(R.id.image1);
        this.image2 = itemView.findViewById(R.id.image2);
        this.image3 = itemView.findViewById(R.id.image3);
    }

    public void bind(Room room) {
        this.name1.setText(room.getLeader());
        this.name2.setText(room.getOne());
        this.name3.setText(room.getTwo());
        this.image1.setImageResource(room.getPhoto1());
        this.image2.setImageResource(room.getPhoto2());
        this.image3.setImageResource(room.getPhoto3());
    }

}