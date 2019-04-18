package com.example.heroswiki.model;

public class Hero {
    private int id;
    private String fullName;
    private String image;

    public Hero() {
    }

    public Hero(int id, String fullName, String image) {
        this.id = id;
        this.fullName = fullName;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
