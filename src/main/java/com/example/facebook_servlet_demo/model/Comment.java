package com.example.facebook_servlet_demo.model;

public class Comment {
    private int id;
    private String content;
    private String image;
    private String date;
    private Situation situation;
    private  Category category;
    private User user;

    public Comment(int id, String content, String image, String date, Situation situation, Category category, User user) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.date = date;
        this.situation = situation;
        this.category = category;
        this.user = user;
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

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}