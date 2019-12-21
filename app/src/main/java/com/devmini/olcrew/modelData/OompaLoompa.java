package com.devmini.olcrew.modelData;

import java.util.List;

public class OompaLoompa {

    private String first_name;
    private String last_name;
    private String age;
    private String height;
    private String gender;
    private String email;
    private String country;
    private String image;
    private String profession;
    private String description;
    private String quota;
    private List<Favorite> favoriteThings;


    public OompaLoompa() {
    }


    // Constructor with all atributes
    public OompaLoompa(String first_name, String last_name, String age, String height, String gender, String email, String country, String image,
                       String profession, String description, String quota, List<Favorite> favoriteThings) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.email = email;
        this.country = country;
        this.image = image;
        this.profession = profession;
        this.description = description;
        this.quota = quota;
        this.favoriteThings = favoriteThings;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public List<Favorite> getFavoriteThings() {
        return favoriteThings;
    }

    public void setFavoriteThings(List<Favorite> favoriteThings) {
        this.favoriteThings = favoriteThings;
    }

    @Override
    public String toString() {
        return "OompaLoompa{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                ", profession='" + profession + '\'' +
                ", description='" + description + '\'' +
                ", quota='" + quota + '\'' +
                ", favoriteThings=" + favoriteThings +
                '}';
    }
}
