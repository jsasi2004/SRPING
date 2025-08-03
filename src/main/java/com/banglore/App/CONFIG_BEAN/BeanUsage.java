package com.banglore.App.CONFIG_BEAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/beans")
public class BeanUsage {
    @Autowired
    BeanExample beanExample;
    
    @GetMapping("/{name}")
    public String setString(@PathVariable String name){
        beanExample.setData(name);
        return new String("Set to "+name);
    }
    @GetMapping("")
    public String getString(){
        return beanExample.getData();
    }

}
