package miu.edu.lab.aspect.v1;

import miu.edu.lab.domain.v1.LoggerEntity;
import miu.edu.lab.repo.v1.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExecutionTimeAspect {

    private final LoggerRepo loggerRepo;

    public ExecutionTimeAspect(LoggerRepo loggerRepo) {
        this.loggerRepo = loggerRepo;
    }

    @Around("@annotation(miu.edu.lab.aspect.v1.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String operation = className + "." + methodName;

        LoggerEntity loggerEntity = new LoggerEntity();
        loggerEntity.setDate(LocalDate.now());
        loggerEntity.setTime(LocalTime.now());
        loggerEntity.setExecutionTime(executionTime);
        loggerEntity.setOperation(operation);
        loggerEntity.setPrinciple("FakeUser"); // we will add user principle later

        loggerRepo.save(loggerEntity);

        return result;
    }

//    @Pointcut("@annotation(miu.edu.lab.aspect.v1.annotation.LogMe)")
//    public void logMeAnnotation() {
//
//    }
//
//    @Before(" logMeAnnotation()")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
//    }

}

