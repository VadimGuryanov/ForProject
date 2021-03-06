package com.example.project.second_activity;

public class Room {

    private String leader;
    private String one;
    private String two;
    private int photo1;
    private int photo2;
    private int photo3;

    public Room(String leader, String one, String two, int photo1, int photo2, int photo3) {
        this.leader = leader;
        this.one = one;
        this.two = two;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public int getPhoto1() {
        return photo1;
    }

    public void setPhoto1(int photo1) {
        this.photo1 = photo1;
    }

    public int getPhoto2() {
        return photo2;
    }

    public void setPhoto2(int photo2) {
        this.photo2 = photo2;
    }

    public int getPhoto3() {
        return photo3;
    }

    public void setPhoto3(int photo3) {
        this.photo3 = photo3;
    }
}
