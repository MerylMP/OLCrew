package com.devmini.olcrew.modelData;

public class Favorite {

    private String color;
    private String food;
    private String random_string;
    private String song;

    public Favorite() {
    }

    // Constructor with all atributes
    public Favorite(String color, String food, String random_string, String song) {
        this.color = color;
        this.food = food;
        this.random_string = random_string;
        this.song = song;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getRandom_string() {
        return random_string;
    }

    public void setRandom_string(String random_string) {
        this.random_string = random_string;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "color='" + color + '\'' +
                ", food='" + food + '\'' +
                ", random_string='" + random_string + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}
