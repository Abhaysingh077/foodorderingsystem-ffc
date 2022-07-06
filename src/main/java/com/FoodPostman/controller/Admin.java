package com.FoodPostman.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
String name;
String email;
String password;
public Admin() {
    }
public Admin(int id, String name, String email, String password) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
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
@Override
public String toString() {
    return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
}


}