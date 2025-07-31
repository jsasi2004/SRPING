package com.banglore.App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class user {
    @Id
    public int id;
    public String name;
    public user(){}
    public user(int id,String name){
        this.id=id;this.name=name;
    }
}
