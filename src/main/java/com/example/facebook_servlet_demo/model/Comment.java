package com.example.facebook_servlet_demo.model;

public class Comment {
    private int id ;
    private String content;
    private String image;
    private String date;
    private int idSituation;
    private int idCategory;
    private int idUse;

    public Comment(int id, String content, String image, String date, int idSituation, int idCategory, int idUse) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.date = date;
        this.idSituation = idSituation;
        this.idCategory = idCategory;
        this.idUse = idUse;
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

    public int getIdSituation() {
        return idSituation;
    }

    public void setIdSituation(int idSituation) {
        this.idSituation = idSituation;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdUse() {
        return idUse;
    }

    public void setIdUse(int idUse) {
        this.idUse = idUse;
    }
}
