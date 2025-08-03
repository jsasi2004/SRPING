package com.banglore.App;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.banglore.App.CALC_COMPONENT.CalculatorService;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testCalculator(){
		
		CalculatorService calculatorService=new CalculatorService();
		int result=calculatorService.add(2, 3);
		assertEquals(5, result);
	}

}
