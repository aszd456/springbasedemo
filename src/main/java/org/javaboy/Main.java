package org.javaboy;

import org.javaboy.service.MyCalculatorImpl;

/**
 * @Author: zhouliansheng
 * @Date: 2021/3/21 1:36
 */
public class Main {
    public static void main(String[] args) {
        MyCalculatorImpl myCalculator = new MyCalculatorImpl();
        org.javaboy.MyCalculator calculator = (org.javaboy.MyCalculator) CalculatorProxy.getInstance(myCalculator);
        int add = calculator.add(3, 4);
        System.out.println("add = " + add);
    }
}
