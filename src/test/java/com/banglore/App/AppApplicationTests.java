package com.banglore.App;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.banglore.App.CALC_COMPONENT.CalculatorService;
import com.banglore.App.model.Student;
import com.banglore.App.repo.StudentRepository;
import com.banglore.App.service.StudentService;

@SpringBootTest
class AppApplicationTests {
	
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
		StudentRepository studentRepository=new StudentRepository() {

			@Override
			public void flush() {
				throw new UnsupportedOperationException("Unimplemented method 'flush'");
			}

			@Override
			public <S extends Student> S saveAndFlush(S entity) {
				throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
			}

			@Override
			public <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities) {
				throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
			}

			@Override
			public void deleteAllInBatch(Iterable<Student> entities) {
				throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Integer> ids) {
				throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
			}

			@Override
			public void deleteAllInBatch() {
				throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
			}

			@Override
			public Student getOne(Integer id) {
				throw new UnsupportedOperationException("Unimplemented method 'getOne'");
			}

			@Override
			public Student getById(Integer id) {
				throw new UnsupportedOperationException("Unimplemented method 'getById'");
			}

			@Override
			public Student getReferenceById(Integer id) {
				throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
			}

			@Override
			public <S extends Student> List<S> findAll(Example<S> example) {
				throw new UnsupportedOperationException("Unimplemented method 'findAll'");
			}

			@Override
			public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
				throw new UnsupportedOperationException("Unimplemented method 'findAll'");
			}

			@Override
			public <S extends Student> List<S> saveAll(Iterable<S> entities) {
				throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
			}

			@Override
			public List<Student> findAll() {
				throw new UnsupportedOperationException("Unimplemented method 'findAll'");
			}

			@Override
			public List<Student> findAllById(Iterable<Integer> ids) {
				throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
			}

			@Override
			public <S extends Student> S save(S entity) {
				throw new UnsupportedOperationException("Unimplemented method 'save'");
			}

			@Override
			public Optional<Student> findById(Integer id) {
				return Optional.of(new Student(2,"hello"));
			}

			@Override
			public boolean existsById(Integer id) {
				throw new UnsupportedOperationException("Unimplemented method 'existsById'");
			}

			@Override
			public long count() {
				throw new UnsupportedOperationException("Unimplemented method 'count'");
			}

			@Override
			public void deleteById(Integer id) {
				throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
			}

			@Override
			public void delete(Student entity) {
				throw new UnsupportedOperationException("Unimplemented method 'delete'");
			}

			@Override
			public void deleteAllById(Iterable<? extends Integer> ids) {
				throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
			}

			@Override
			public void deleteAll(Iterable<? extends Student> entities) {
				throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
			}

			@Override
			public void deleteAll() {
				throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
			}

			@Override
			public List<Student> findAll(Sort sort) {
				throw new UnsupportedOperationException("Unimplemented method 'findAll'");
			}

			@Override
			public Page<Student> findAll(Pageable pageable) {
				throw new UnsupportedOperationException("Unimplemented method 'findAll'");
			}

			@Override
			public <S extends Student> Optional<S> findOne(Example<S> example) {
				throw new UnsupportedOperationException("Unimplemented method 'findOne'");
			}

			@Override
			public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
				throw new UnsupportedOperationException("Unimplemented method 'findAll'");
			}

			@Override
			public <S extends Student> long count(Example<S> example) {
				throw new UnsupportedOperationException("Unimplemented method 'count'");
			}

			@Override
			public <S extends Student> boolean exists(Example<S> example) {
				throw new UnsupportedOperationException("Unimplemented method 'exists'");
			}

			@Override
			public <S extends Student, R> R findBy(Example<S> example,
					Function<FetchableFluentQuery<S>, R> queryFunction) {
				throw new UnsupportedOperationException("Unimplemented method 'findBy'");
			}

			@Override
			public int totalStudentCount() {
				throw new UnsupportedOperationException("Unimplemented method 'totalStudentCount'");
			}
			
		};
		StudentService studentService=new StudentService(studentRepository);
		Student student=studentService.getStudentByRoll(2);
		assertEquals(2, student.getRoll());
		assertEquals("hello", student.getName());
	}

}
