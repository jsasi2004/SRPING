package com.banglore.App.CALC_COMPONENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/calc")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    
    @GetMapping("")
    public int sum(@RequestParam int a,@RequestParam int b){
        return calculatorService.add(a, b);
    }
}
