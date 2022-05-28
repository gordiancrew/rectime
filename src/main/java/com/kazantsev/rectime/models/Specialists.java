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

    public Specialists() {
    }

    public Specialists(String name, String surename) {
        this.name = name;
        this.surename = surename;
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
