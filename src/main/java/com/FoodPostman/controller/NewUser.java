package com.FoodPostman.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String username;    
    String email;
    String password;
    public NewUser() {
        }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public NewUser(int id, String name, String username, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
                + password + "]";
    }
    
}