package com.example.aspectdemo.controller;

import com.example.aspectdemo.annotation.WebDesc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop2")
public class AopControllerAnn {
    @RequestMapping("/testAnnotation")
    @WebDesc(describe = "This is testAnnotation Controller")
    public String testAnnotation(String key){
        return "key="+key;
    }

}
