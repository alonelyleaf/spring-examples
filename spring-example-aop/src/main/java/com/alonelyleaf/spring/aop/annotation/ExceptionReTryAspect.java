package com.alonelyleaf.spring.aop.annotation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bijl
 * @date 2020/12/21 上午10:50
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class ExceptionReTryAspect {

    @Pointcut("@annotation(com.alonelyleaf.spring.aop.annotation.ExceptionReTry)")
    public void auditPointcut() {
    }

    /**
     * 抛出异常后
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    //@AfterThrowing(value = "auditPointcut()", throwing = "e")
    public void handleException(JoinPoint joinPoint, Exception e) throws Exception {

        if (!retryAble(joinPoint, e)) {
            return;
        }

        handleExceptionReTry(joinPoint);
    }

    /**
     * 环绕通知
     *
     * 代替原方法执行
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "auditPointcut()")
    public Object demoAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.debug("执行前：");

        Map<String, Object> params = getNameAndValue(proceedingJoinPoint);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            System.out.println("name: " + entry.getKey() + " value: " + entry.getValue());
        }

        Object object = proceedingJoinPoint.proceed();  //执行连接点方法，object：方法返回值

        log.debug("执行后：");

        return object;
    }


    public void handleExceptionReTry(JoinPoint joinPoint) {

        try {
            ExceptionReTry exceptionReTry = getMethod(joinPoint).getAnnotation(ExceptionReTry.class);

            AtomicInteger atomicInteger = new AtomicInteger(0);

            if (atomicInteger.intValue() < exceptionReTry.retryTimes()) {
                int i = atomicInteger.incrementAndGet();
                Thread.sleep(exceptionReTry.sleep() * i);
                log.debug("开始重试第" + i + "次");
                MethodInvocationProceedingJoinPoint methodPoint = ((MethodInvocationProceedingJoinPoint) joinPoint);
                methodPoint.proceed();
            }
        } catch (Throwable throwable) {
            handleExceptionReTry(joinPoint);
        }
    }


    private boolean retryAble(JoinPoint joinPoint, Exception e) {

        ExceptionReTry exceptionReTry = getMethod(joinPoint).getAnnotation(ExceptionReTry.class);

        if (null == exceptionReTry) {
            return false;
        }

        return true;
        //return Arrays.stream(exceptionReTry.value()).anyMatch();
    }

    public static Method getMethod(JoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;

        return methodSignature.getMethod();
    }

    /**
     * 获取参数Map集合
     * @param joinPoint
     * @return
     */
    Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {

        Map<String, Object> param = new HashMap<>();
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        return param;
    }
}
