package com.example.AirlineReservation.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int user_id;
    private int mobile;
    private String name, email, password;
    private boolean admin;

    public User() {
    }

    public User(int user_id, int mobile, String name, String email, String password, boolean admin) {
        this.user_id = user_id;
        this.mobile = mobile;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
