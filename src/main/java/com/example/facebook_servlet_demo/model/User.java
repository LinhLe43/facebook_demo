package com.example.facebook_servlet_demo.model;

public class User {
    private int id;
    private String name;
    private String image;
    private String sex;
    private String dob;
    private  String address;

    public User(int id, String name, String image, String sex, String dob, String address) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
