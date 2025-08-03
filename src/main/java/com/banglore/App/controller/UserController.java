package com.banglore.App.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.banglore.App.model.UserDetails;
import com.banglore.App.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/users")
    @ResponseBody
    public List<UserDetails> getUserDetails() {
        return userService.gUserDetails();
    }
    
}
