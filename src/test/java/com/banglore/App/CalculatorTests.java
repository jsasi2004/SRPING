package com.banglore.App;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.banglore.App.CALC_COMPONENT.CalculatorController;
import com.banglore.App.CALC_COMPONENT.CalculatorService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculatorTests {
    Logger logger=LoggerFactory.getLogger(CalculatorTests.class);
    @Autowired
    CalculatorService realCalculatorService;
    @Spy
    CalculatorService spyBeanService;
    
    @Test
    void testAddition(){
        CalculatorService calculatorService=mock(CalculatorService.class);
        when(calculatorService.add(2, 3)).thenReturn(5);
        CalculatorController calculatorController=new CalculatorController(calculatorService);
        int result=calculatorController.sum(2, 3);
        assertEquals(5, result);
        logger.info("from Calculator Tests");
    }

    @Test
    void testSpyRealMethod(){
        CalculatorService spyCalculatorService=spy(realCalculatorService);
        int result=spyCalculatorService.add(1, 3);
        assertEquals(4 , result);
        doReturn(10).when(spyCalculatorService).add(1, 3);
        assertEquals(10, spyCalculatorService.add(1,3));
        verify(spyCalculatorService,times(2)).add(1, 3);
    }
    
    @Test
    void spyBeanTestMethod(){
        int result=spyBeanService.add(1, 3);
        assertEquals(4, result);
        doReturn(10).when(spyBeanService).add(1, 3);
        assertEquals(10, spyBeanService.add(1, 3));
        verify(spyBeanService,times(2)).add(1,3);
    }
}
