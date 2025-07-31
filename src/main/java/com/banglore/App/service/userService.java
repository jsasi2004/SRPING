package com.banglore.App.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banglore.App.model.user;
import com.banglore.App.repo.userRepository;

@Service
public class userService {
    userRepository uRepository;
    public userService(userRepository uRepository){this.uRepository=uRepository;}
    public List<user> getUsers(){
        return uRepository.findAll();
    }
}
