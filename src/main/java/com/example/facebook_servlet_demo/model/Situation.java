package com.example.facebook_servlet_demo.model;

public class Situation {
    private int id;
    private String name;

    public Situation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Situation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
