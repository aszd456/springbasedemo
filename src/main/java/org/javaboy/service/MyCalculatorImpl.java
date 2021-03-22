package org.javaboy.service;/**
 * @author leo
 * @date 2021/2/20
 * @apiNote
 */

import org.javaboy.Action;
import org.javaboy.MyCalculator;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyCalculatorImpl
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/20 10:47
 * @Version 1.0
 **/
@Component
public class MyCalculatorImpl implements MyCalculator{
//    @Action
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    public void min(int a, int b) {
        System.out.println("a-b=" + (a - b));
    }
}
