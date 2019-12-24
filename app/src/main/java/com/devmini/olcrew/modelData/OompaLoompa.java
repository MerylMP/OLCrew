package com.devmini.olcrew.modelData;

public class OompaLoompa {

    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private int height;
    private String gender;
    private String email;
    private String country;
    private String image;
    private String profession;
    private String description;
    private String quota;
    private Favorite favorite;


    public OompaLoompa() {
    }


    // Constructor with all atributes
    public OompaLoompa(int id, String first_name, String last_name, int age, int height, String gender, String email, String country, String image,
                       String profession, String description, String quota, Favorite favorite) {
        this.id = id;
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
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
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

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
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
                ", favorite=" + favorite +
                '}';
    }
}
