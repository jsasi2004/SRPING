package com.banglore.App;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.banglore.App.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    void testrest(){
        ResponseEntity<List<Student>> response=testRestTemplate.exchange("/student", HttpMethod.GET,null,new ParameterizedTypeReference<List<Student>>() {});
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
