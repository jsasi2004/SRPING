package com.banglore.App.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banglore.App.model.user;
@Repository
public interface userRepository extends JpaRepository<user,Integer> {
    
}
