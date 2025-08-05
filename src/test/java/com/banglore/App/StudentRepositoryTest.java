package com.banglore.App;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
// import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


import java.util.Optional;

import com.banglore.App.model.Student;
import com.banglore.App.repo.StudentRepository;
import com.banglore.App.service.StudentService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    Logger logger=LoggerFactory.getLogger(getClass());

    @Mock
    StudentRepository sRepository;
    @InjectMocks
    StudentService sService;

    @Test
    void testSaveAndFindStudent(){
        System.out.println("student repository test called");
        Student student=new Student();
        student.setName("sashank");

        Student savedStudent=studentRepository.save(student);
        System.out.println("Save called");
        Student fetchedStudent=studentRepository.findById(savedStudent.getRoll()).orElse(null);
        assertThat(fetchedStudent).isNotNull();
        assertThat(fetchedStudent.getName()).isEqualTo("sashank");
    }
    @Test
    void testMocking(){
        logger.info("Mockito from Student repository test");
        when(sRepository.findById(1)).thenReturn(Optional.of(new Student(1,"Sashank")));
        Student student=sService.getStudentByRoll(1);
        assertEquals("Sashank",student.getName());
        assertEquals(1,student.getRoll());;
        verify(sRepository).findById(1);
        // verify(sRepository,times(1)).findById(1);
        verifyNoMoreInteractions(sRepository);
    }
    @Test
    void testCapturing(){
        ArgumentCaptor<Student> studentCaptor=ArgumentCaptor.forClass(Student.class);
        sService.saveStudent(new Student(1,"Sashank"));
        verify(sRepository).save(studentCaptor.capture());
        Student studentCaptured=studentCaptor.getValue();
        assertEquals(1, studentCaptured.getRoll());
        assertEquals("Sashank", studentCaptured.getName());
        logger.info("capturing the parameter");
    }
    @Test
    void testDoNothing(){
        doNothing().when(sRepository).deleteById(anyInt());
        sService.deleteStudentById(3);
        verify(sRepository).deleteById(3);
    }
    @Test
    void testDoAnswer(){
        doAnswer(invocation->{
            int msg=invocation.getArgument(0);
            System.out.println("Mock log: "+msg);
            return null;
        }).when(sRepository).deleteById(anyInt());
        sService.deleteStudentById(0);
        verify(sRepository).deleteById(0);

    }
    @Test
    void testDoThrow(){
        doThrow(new RuntimeException("Message from exception")).when(sRepository).deleteById(1);
        assertThrows(RuntimeException.class,()->{sService.deleteStudentById(1);});
        verify(sRepository).deleteById(1);
    }
}
