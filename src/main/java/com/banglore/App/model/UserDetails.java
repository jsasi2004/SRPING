package com.banglore.App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
    @Id
    public int id;
    public String name;
    public UserDetails(){}
    public UserDetails(int id,String name){
        this.id=id;this.name=name;
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
    
}
