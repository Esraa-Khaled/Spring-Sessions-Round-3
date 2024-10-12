package com.ntg.data.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Order(1)
@Component
public class LoggingAspect {
//
    @Before(value = "getAllEmployeesPoint() || getEmployeeByIdPoint()")
    public void beforeCalling(JoinPoint joinPoint) {
        System.out.println("Inside logging aspect Before " + joinPoint.getSignature());
    }

    @After(value = "getAllEmployeesPoint() || getEmployeeByIdPoint()")
    public void afterCalling(JoinPoint joinPoint) {
        System.out.println("Inside aspect After " +  joinPoint.getSignature());
    }

    @AfterReturning(value = "getAllEmployeesPoint()", returning = "result")
    public void afterReturningAspect(JoinPoint joinPoint, Object result) {

        System.out.println("Inside aspect After Returning " +  joinPoint.getSignature());
    }

    @AfterThrowing(value = "getAllEmployeesPoint()", throwing = "ex")
    public void afterThrowingAspect(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Inside aspect After Throwing " +  joinPoint.getSignature());
    }

    @After(value = "@within(com.ntg.data.controllers.*)")
    public void InsidePackageAspect(JoinPoint joinPoint) {
        System.out.println("Inside aspect After " +  joinPoint.getSignature());
    }


    @Around(value = "getAllEmployeesPoint()")
    public Object aroundCalling(ProceedingJoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature());
        StopWatch watch = new StopWatch();
        watch.start();
        Object result = new Object();
        try{
            result = joinPoint.proceed();
        } catch (Throwable ex) {

        }
        watch.stop();
        System.out.println("After: " + joinPoint.getSignature());
        System.out.println("Calling time of " +joinPoint.getSignature() + ": " + watch.getTotalTimeMillis());
        return result;
    }


    @Pointcut("execution(public * getAllEmployees())")
    public void getAllEmployeesPoint() {}

    @Pointcut("execution(public * findEmployee*(*))")
    public void getEmployeeByIdPoint() {}
}
