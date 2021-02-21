package org.javaboy;/**
 * @author leo
 * @date 2021/2/20
 * @apiNote
 */

import org.javaboy.service.MyCalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName CalculatorProxy
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/20 11:22
 * @Version 1.0
 * 基于jdk的动态代理
 **/
public class CalculatorProxy {

    public static Object getInstance(final MyCalculatorImpl myCalculator) {
        //第一个参数classloader 第二个是代理多项实现的接口 第三个是代理对象方法的处理器
        return Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), myCalculator.getClass().getInterfaces()
                //proxy 代理对象，method 代理的方法，args 方法的参数
                , (proxy, method, args) -> {
                    System.out.println(method.getName() + "方法开始执行");
                    Object invoke = method.invoke(myCalculator, args);
                    System.out.println(method.getName() + "方法执行结束");
                    return invoke;
                });
    }
}
