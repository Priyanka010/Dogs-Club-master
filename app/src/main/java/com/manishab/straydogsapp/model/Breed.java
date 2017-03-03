package com.manishab.straydogsapp.model;

import java.io.Serializable;

public class Breed implements Serializable {
    private String breed_name;
    private String breed_info;
    private String breed_img;
    private int breed_id;
    private String breed_feed;

    public Breed(String breed_name, String breed_info, String breed_img, int breed_id, String breed_feed) {
        this.breed_name = breed_name;
        this.breed_info = breed_info;
        this.breed_img = breed_img;
        this.breed_id = breed_id;
        this.breed_feed = breed_feed;
    }

    public Breed() {

    }

    public String getBreed_name() {
        return breed_name;
    }

    public void setBreed_name(String breed_name) {
        this.breed_name = breed_name;
    }

    public String getBreed_info() {
        return breed_info;
    }

    public void setBreed_info(String breed_info) {
        this.breed_info = breed_info;
    }

    public String getBreed_img() {
        return breed_img;
    }

    public void setBreed_img(String breed_img) {
        this.breed_img = breed_img;
    }

    public int getBreed_id() {
        return breed_id;
    }

    public void setBreed_id(int breed_id) {
        this.breed_id = breed_id;
    }

    public String getBreed_feed() {
        return breed_feed;
    }

    public void setBreed_feed(String breed_feed) {
        this.breed_feed = breed_feed;
    }
}
