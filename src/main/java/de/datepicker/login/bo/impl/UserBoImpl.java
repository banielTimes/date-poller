package de.datepicker.login.bo.impl;

import de.datepicker.login.bo.UserBo;

/**
 * Created by dsy on 29.10.14.
 */
public class UserBoImpl implements UserBo {
    private String yolo = "yolo";

    public void setYolo(String yolo) {
        this.yolo = yolo;
    }

    public String getYolo() {
        return yolo;
    }

    @Override
    public void printUser() {
        System.out.println("IT WORKS NAO ohrely");
    }
}
