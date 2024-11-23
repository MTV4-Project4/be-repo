package com.walkers.sportslight.common.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* *(..)) && within(*..*controller..*)")
    public void logControllerMethod(JoinPoint joinPoint) {
        // 동적으로 로거 생성
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Logger dynamicLogger = LoggerFactory.getLogger(targetClass);

        // 메서드 이름 및 인자
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 로깅
        dynamicLogger.info("Method executed: {} with arguments: {}", methodName, Arrays.toString(args));
    }
}
