package org.javaboy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouliansheng
 * @Date: 2021/2/21 18:12
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(Action)")
    public void pointcut2() {

    }

    /**
     * [* org.javaboy.service.*.*(..))]
     * 第一个 * 表示要拦截的目标方法返回值任意（也可以明确指定类型）
     * 第二个 * 表示包中的任意类（可以指定类）
     * 第三个 * 表示类中的任意方法
     * 最后面的两个点表示方法参数任意，个数任意，类型任意
     */
    @Pointcut("execution(* org.javaboy.service.MyCalculatorImpl.add(..))")
    public void pointcut() {

    }


    /**
     * @param joinPoint 包含了目标方法的关键信息
     *                  前置通知
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法开始执行了");
    }

    /**
     * @param joinPoint 包含目标方法的所有关键信息
     *                  后置通知，目标方法执行结束后执行
     */
    @After(value = "pointcut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法执行结束了");
    }

    /**
     * 返回通知
     *
     * @param joinPoint
     * @param r         目标方法有返回值才会触发，注解中returning属性表示目标方法返回值的变量名
     *                  这个需要和参数一一对应。注意：目标方法返回值类型要和这里方法返回值类型一致，
     *                  否则拦截失败，如果想拦截素有，参数可改为Object
     */
    @AfterReturning(value = "pointcut()", returning = "r")
    public void returning(JoinPoint joinPoint, Integer r) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法返回" + r);
    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param e         目标方法所抛出的异常，注意，这个参数必须是目标方法所抛出的异常
     *                  或者所抛出异常的父类，只有这样才会捕获。如果想拦截所有，设置
     *                  参数为Exception
     */
    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void throwing(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法抛出异常了" + e.getMessage());
    }

    /**
     * 环绕通知
     * 环绕通知是集大成者，可以用环绕通知实现上面的四个通知，这个方法的核心
     * 有点类似于在这里通过反射执行方法
     *
     * @param pjp
     * @return 注意这里的返回值类型最后是Object, 和拦截的方法相匹配
     */
    @Around(value = "pointcut()")
    public Object throwing(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
