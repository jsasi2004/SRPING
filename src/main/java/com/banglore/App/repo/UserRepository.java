package com.banglore.App.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banglore.App.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer>{
    
}
