package miu.edu.lab.aspect.v1;

import miu.edu.lab.domain.v1.ExceptionEntity;
import miu.edu.lab.service.v1.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {

    @Autowired
    private ExceptionService exceptionService;

    @AfterThrowing(pointcut = "execution(* miu.edu.lab..*.*(..))", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Exception exception) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setDate(LocalDate.now());
        exceptionEntity.setTime(LocalTime.now());
        exceptionEntity.setPrinciple("Faker");

        exceptionEntity.setExceptionType(exception.getClass().getName() + "@" + exception.getClass().getTypeName());
        exceptionEntity.setExceptionMessage(exception.getMessage());

        exceptionService.create(exceptionEntity);
    }
}

