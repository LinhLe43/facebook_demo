package com.example.facebook_servlet_demo.model;

public class Post {
    private int id;
    private String content;
    private String image;
    private String time;
    private Situation situation;
    private Category category;
    private User user;

    public Post(int id, String content, String image, String time, Situation situation, Category category, User user) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.time = time;
        this.situation = situation;
        this.category = category;
        this.user = user;
    }

    public Post(String content, String image, String time, Situation situation, Category category, User user) {
        this.content = content;
        this.image = image;
        this.time = time;
        this.situation = situation;
        this.category = category;
        this.user = user;
    }

    public Post(int id) {
        this.id = id;
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
