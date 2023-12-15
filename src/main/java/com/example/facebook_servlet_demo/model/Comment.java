package com.example.facebook_servlet_demo.model;

public class Comment {
    private int id;
    private String content;
    private String time;
    private Post post;
    private User user;

    public Comment(int id, String content, String time, Post post, User user) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.post = post;
        this.user = user;
    }

    public Comment(String content, String time, Post post, User user) {
        this.content = content;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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