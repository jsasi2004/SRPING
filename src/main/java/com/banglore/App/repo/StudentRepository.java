package com.banglore.App.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banglore.App.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    public record returnBody(String str,int count){}

    @Query(value = "SELECT COUNT(*) FROM student",nativeQuery = true)
    int totalStudentCount();
}
