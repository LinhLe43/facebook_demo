package com.example.facebook_servlet_demo.model;

public class Post {
    private int id;
    private String content;
    private String image;
    private String time;
    private int Situation;
    private int Category;
    private int Use;

    public Post(int id, String content, String image, String time, int situation, int category, int use) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.time = time;
        Situation = situation;
        Category = category;
        Use = use;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSituation() {
        return Situation;
    }

    public void setSituation(int situation) {
        Situation = situation;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public int getUse() {
        return Use;
    }

    public void setUse(int use) {
        Use = use;
    }
}
