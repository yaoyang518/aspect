package com.example.aspectdemo.config;

import com.example.aspectdemo.annotation.WebDesc;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WebAspectAnno {
    /**
     * 切入点
     * 用注解
     */
    @Pointcut("@annotation(com.example.aspectdemo.annotation.WebDesc)")
    public void executeAnnotation(){
    }
    //@Before("executeAnnotation()")
    @Before("@annotation(webDesc)")
    public void beforeAdviceAnnotation(WebDesc webDesc){
        System.out.println("Before注解的值:" + webDesc.describe());
        System.out.println("- - - - - 前置通知 annotation - - - - -");
    }
    @Around("@annotation(webDesc)")
    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint, WebDesc webDesc){
        System.out.println("- - - - - 环绕通知 annotation - - - -");
        //获取注解里的值
        System.out.println("注解的值:" + webDesc.describe());
        try {//obj之前可以写目标方法执行前的逻辑
            Object obj = proceedingJoinPoint.proceed();//调用执行目标方法
            System.out.println("- - - - - 环绕通知 annotation end - - - -");
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
