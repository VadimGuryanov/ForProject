package com.example.project.three_activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

public class GroupHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private ImageView photo;


    public GroupHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name_people);
        this.photo = itemView.findViewById(R.id.photo_people);
    }

    public void bind(People people) {
        this.name.setText(people.getName());
        this.photo.setImageResource(people.getPhoto());
    }
}
