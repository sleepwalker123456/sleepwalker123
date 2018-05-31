package com.org.springcloud.controller;

import com.org.springcloud.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloRibbonService helloService;

    @RequestMapping("/hi")
    public String ribbonSayHi(@RequestParam String name){
        String message = helloService.sayHi(name);
        return message;
    }

}
