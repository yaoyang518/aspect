package com.example.aspectdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {

    @RequestMapping("/test")
    public String testAop(String key){
        return "key="+key;
    }

    @RequestMapping("/testAfterThrowing")
    public String testAfterThrowing(String key){
        throw new NullPointerException();
    }

    @RequestMapping("/testAround")
    public String testAround(String key){
        return "key="+key;
    }

}
