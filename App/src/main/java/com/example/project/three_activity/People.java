package com.example.project.three_activity;

public class People {

    private String id;
    private String name;
    private int photo;

    public People(String id, String name, int photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
