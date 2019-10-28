package ru.inkontext.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Evgeny Borisov
 */
@Aspect
public class TaskAspect {

    @Pointcut("execution(* ru.inkontext.services..*.*(..))")
    public void allMyMethods(){}

    @Before("allMyMethods() && @annotation(Deprecated)")
    public void callAtDeprecatedAnnotation() {
        System.out.println("Depricated method called");
    }

//    @AfterThrowing(value = "allMyMethods()",throwing = "ex")
//    public void callOnException(DBException ex) {
//        System.out.println("Depricated method called");
//    }

    @Around("allMyMethods()")
    @SneakyThrows
    public Object handleSayMethods(ProceedingJoinPoint jp){
        String simpleName = jp.getTarget().getClass().getSimpleName();
        System.out.println("до выполнения задачи "+simpleName+": ");
        Instant startTime = Instant.now();
        Object retVal = jp.proceed();
        System.out.println("задача завершена, время выполнения: " + Duration.between(startTime, Instant.now()));
        return retVal;
    }
}
