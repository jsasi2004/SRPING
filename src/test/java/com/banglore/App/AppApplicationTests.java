package com.banglore.App;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.banglore.App.CALC_COMPONENT.CalculatorService;
import com.banglore.App.model.Student;
import com.banglore.App.repo.StudentRepository;
import com.banglore.App.service.StudentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AppApplicationTests {
	@Spy
	StudentRepository studentRepository;

	static CalculatorService calculatorService;
	@BeforeEach
	void init(){
		// calculatorService=new CalculatorService();
		System.out.println("Test started");
	}
	@AfterEach
	void cleanUp(){
		System.out.println("Test completed");
	}

	@BeforeAll
	static void beforeAll(){
		calculatorService=new CalculatorService();
		System.out.println("Before all called");
	}
	@AfterAll
	static void afterAll(){
		System.out.println("After all called");
	}

	@Test
	void contextLoads() {
	}
	@Test
	void testCalculator(){
		int result=calculatorService.add(2, 3);
		assertEquals(5, result);
	}

	@ParameterizedTest
	@ValueSource(ints = {1,3,5})
	void testCalculator(int a){
		assertFalse(calculatorService.isEven(a));
	}

	@ParameterizedTest
	@CsvSource({"2,3,5","0,1,1","1,0,1"})
	void testCalculator(int a,int b,int result){
		System.out.println(a+" "+b+" "+result);
		assertEquals(result,calculatorService.add(a, b));
	}

	@Test
	void testGetStudentById(){
		doReturn(Optional.of(new Student(2,"hello"))).when(studentRepository).findById(2);
		StudentService studentService=new StudentService(studentRepository);
		Student student=studentService.getStudentByRoll(2);
		assertEquals(2, student.getRoll());
		assertEquals("hello", student.getName());
	}

}
