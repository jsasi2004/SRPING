package com.banglore.App.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banglore.App.model.user;
import com.banglore.App.service.userService;

@RestController
public class userCont {
    userService uService;
    public userCont(userService uService){this.uService=uService;}

    @GetMapping("/user")
    public List<user> retUsers(){
        return uService.getUsers();
    }
}
