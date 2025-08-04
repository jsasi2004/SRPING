package com.banglore.App;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.banglore.App.CALC_COMPONENT.CalculatorController;
import com.banglore.App.CALC_COMPONENT.CalculatorService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculatorTests {
    Logger logger=LoggerFactory.getLogger(CalculatorTests.class);

    
    @Test
    void testAddition(){
        CalculatorService calculatorService=mock(CalculatorService.class);
        when(calculatorService.add(2, 3)).thenReturn(5);
        CalculatorController calculatorController=new CalculatorController(calculatorService);
        int result=calculatorController.sum(2, 3);
        assertEquals(5, result);
        logger.info("from Calculator Tests");
    }

    @Mock
    CalculatorService cService;
    @InjectMocks
    CalculatorController cController;
    @Test
    void testAdd(){
        when(cService.add(2, 3)).thenReturn(5);
        int result=cController.sum(2, 3);
        assertEquals(5, result);
        logger.info("using @Mocks");
    }
}
