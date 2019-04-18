package com.example.heroswiki.model;

public class DetailHero {
    private int id;
    private String fullName;
    private String status;
    private String spicies;
    private String type;
    private String gender;
    private String origin;
    private String location;
    private String image;

    public DetailHero() {
    }


    public DetailHero(int id, String fullName, String status, String spicies, String type, String gender, String origin, String location, String image) {
        this.id = id;
        this.fullName = fullName;
        this.status = status;
        this.spicies = spicies;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
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

    public String getSpicies() {
        return spicies;
    }

    public void setSpicies(String spicies) {
        this.spicies = spicies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DetailHero{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", status='" + status + '\'' +
                ", spicies='" + spicies + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", origin='" + origin + '\'' +
                ", location='" + location + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
