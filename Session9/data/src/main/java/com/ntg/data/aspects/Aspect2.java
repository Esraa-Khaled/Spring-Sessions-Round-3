package com.ntg.data.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class Aspect2 {

    @Before(value = "getAllEmployeesPoint() || getEmployeeByIdPoint()")
    public void beforeCalling(JoinPoint joinPoint) {
        System.out.println("Inside aspect2 Before " + joinPoint.getSignature());
    }

    @Pointcut("execution(public * getAllEmployees())")
    public void getAllEmployeesPoint() {}

    @Pointcut("execution(public * findEmployee*(*))")
    public void getEmployeeByIdPoint() {}
}
