package com.coffee.maqzar.domain;

import java.io.Serializable;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
public class User implements Serializable{

    private Long userId;
    private String name;
    private String lastName;
    private String middleName;
    private int age;
    private Boolean active;

    public User(){

    }

    public User(Long userId, String name, String lastname, String middleName, int age, Boolean active){
        this.setUserId(userId);
        this.setName(name);
        this.setLastName(lastname);
        this.setMiddleName(middleName);
        this.setAge(age);
        this.setActive(active);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
