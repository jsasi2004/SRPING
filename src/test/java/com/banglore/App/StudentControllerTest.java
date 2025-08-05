package com.banglore.App;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.banglore.App.controller.StudentController;
import com.banglore.App.model.Student;
import com.banglore.App.service.StudentService;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    StudentService studentService;
    
    

    @Test
    void testGetStudents() throws Exception{
        List<Student> mockList = Arrays.asList(new Student(1, "John"), new Student(2, "Jane"));
        when(studentService.gStudents()).thenReturn(mockList);
        mockMvc.perform(get("/student"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()").value(2))
        .andExpect(jsonPath("$[0].name").value("John"));
    }
    
}
