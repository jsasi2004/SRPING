package com.banglore.App.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banglore.App.model.UserDetails;
import com.banglore.App.repo.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<UserDetails> gUserDetails(){
        return userRepository.findAll();
    }
}
