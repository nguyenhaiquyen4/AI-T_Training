package com.apress.prospring4.ch5bis.listing5_67;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
        if (intValue != 100) {
            System.out.println("Executing: " +
                    joinPoint.getSignature().getDeclaringTypeName() + " "
                    + joinPoint.getSignature().getName()
                    + " argument: " + intValue);
        }
    }

    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue)
            throws Throwable {
        System.out.println("Before execution: " +
                pjp.getSignature().getDeclaringTypeName() + " "
                + pjp.getSignature().getName()
                + " argument: " + intValue);
        Object retVal = pjp.proceed();
        System.out.println("After execution: " +
                pjp.getSignature().getDeclaringTypeName() + " "
                + pjp.getSignature().getName() + " argument: " + intValue);
        return retVal;
    }
}
