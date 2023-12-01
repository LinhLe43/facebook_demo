package com.example.facebook_servlet_demo.model;

public class Comment {
    private int id;
    private String content;
    private String image;
    private String date;
    private int Situation;
    private int Category;
    private int Use;

    public Comment(int id, String content, String image, String date, int situation, int category, int use) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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