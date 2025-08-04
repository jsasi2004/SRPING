package com.banglore.App.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.banglore.App.EXCEPTION_HANDLER.EntityNotFound;
import com.banglore.App.model.Student;
import com.banglore.App.repo.StudentRepository;

@Service
public class StudentService {
    StudentRepository sRepository;

    public StudentService(StudentRepository sRepository){
        this.sRepository=sRepository;
    }

    public List<Student> gStudents(){
        return sRepository.findAll();
    }

    public Student getStudentByRoll(int roll){
        return sRepository.findById(roll).orElseThrow(()->new EntityNotFound("Entity with roll "+roll+" not found."));
    }

    public Student saveStudent(Student student){
        return sRepository.save(student);
    }

    public Student updateStudent(Student student){
        Student existingStudent=sRepository.findById(student.getRoll()).orElseThrow(()->new EntityNotFound("Entity not found"));
        existingStudent.setName(student.getName());
        existingStudent.setRoll(student.getRoll());
        return sRepository.save(existingStudent);
    }

    public Student deleteStudent(int id){
        Student existingStudent=sRepository.findById(id).orElseThrow(()->new EntityNotFound("Entity not found"));
        sRepository.delete(existingStudent);
        return existingStudent;
    }

    public Map<String,Integer> countStudents(){
        Map<String,Integer> m=new HashMap<>();
        m.put("Count", sRepository.totalStudentCount());
        return m;
    }

    public void deleteStudentById(int id){
        sRepository.deleteById(id);
    }
}
