package com.kazantsev.rectime.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Specialists {

    @Id
    @GeneratedValue
    private  Integer id;
    private String name;
    private String surename;
    private String img;

    public Specialists() {
    }

    public Specialists(String name, String surename, String img) {
        this.name = name;
        this.surename = surename;
        this.img=img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }
}
