package com.example.facebook_servlet_demo.model;

public class Comment {
    private int id;
    private String content;
    private String image;
    private String date;
    private Post post;
    private User user;

    public Comment(int id, String content, String image, String date, Post post, User user) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.date = date;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}