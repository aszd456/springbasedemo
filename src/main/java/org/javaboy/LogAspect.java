package org.javaboy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouliansheng
 * @Date: 2021/2/21 18:12
 */
@Component
@Aspect
public class LogAspect {

    /**
     *
     * @param joinPoint 包含了目标方法的关键信息
     * @Before 前置通知
     */
    @Before(value = "@annotation(Action)")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法开始执行了");
    }

    /**
     *
     * @param joinPoint 包含目标方法的所有关键信息
     * 后置通知，目标方法执行结束后执行
     */
    @After(value = "@annotation(Action)")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法开始执行了");
    }
}
