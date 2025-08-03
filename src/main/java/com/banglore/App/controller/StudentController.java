package com.banglore.App.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banglore.App.model.Student;
import com.banglore.App.service.StudentService;

import jakarta.validation.Valid;

@Controller
@ResponseBody
public class StudentController {
    StudentService sService;
    public StudentController(StudentService sService){
        this.sService=sService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> gStudents(){
        return ResponseEntity.ok().body(sService.gStudents());
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        return ResponseEntity.ok().body(sService.getStudent(id));
    }
    @GetMapping("/student/count")
    public ResponseEntity<Map<String,Integer>> countStudents(){
        return ResponseEntity.status(200).body(sService.countStudents());
    }
    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(201).body(sService.saveStudent(student));
    }
    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student){
        return ResponseEntity.accepted().body(sService.updateStudent(student));
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        return ResponseEntity.status(204).body(sService.deleteStudent(id));
    }
}
