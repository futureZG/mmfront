package com.mmfront.bean;

//import lombok.Getter;
//import lombok.Setter;

import java.io.Serializable;

/**
 * Created by My on 2018/5/1.
 */
//@Getter
//@Setter
public class User implements Serializable{
    private String username;
    private String password;
    private String phone;
    private int age;
    private int gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
