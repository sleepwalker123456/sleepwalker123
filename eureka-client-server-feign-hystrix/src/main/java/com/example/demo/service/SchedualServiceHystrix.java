package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHystrix implements SchedualServiceHi{
    @Override
    public String sayHi(String name) {
        return "Hi "+ name + ", fein-hystrix system error";
    }
}
