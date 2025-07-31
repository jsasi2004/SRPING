package com.banglore.App.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.banglore.App.model.Student;

import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class studentCont {
    Student student;
    public studentCont(Student student){this.student=student;}
    

    @GetMapping("/hi")
    public String retPage(Model model) {
        model.addAttribute("name", "springBoot");
        return "hello";
    }
    
}
