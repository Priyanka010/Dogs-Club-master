package com.manishab.straydogsapp.model;

import java.io.Serializable;

public class Center implements Serializable {

    private String center_name;
    private String center_info;
    private String center_img;
    private int center_id;

    public Center() {

    }

    public Center(String center_name, String center_info, String center_img, int center_id) {

        this.center_name = center_name;
        this.center_info = center_info;
        this.center_img = center_img;
        this.center_id = center_id;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getCenter_info() {
        return center_info;
    }

    public void setCenter_info(String center_info) {
        this.center_info = center_info;
    }

    public String getCenter_img() {
        return center_img;
    }

    public void setCenter_img(String center_img) {
        this.center_img = center_img;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }
}
