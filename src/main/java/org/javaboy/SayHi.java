package org.javaboy;/**
 * @author leo
 * @date 2021/2/19
 * @apiNote
 */

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SayHi
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/19 15:21
 * @Version 1.0
 **/
@Component
public class SayHi implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public String sayHello(String name) {
        boolean userDao = applicationContext.containsBean("userDao333");
        System.out.println(userDao);
        return "hello" + name;
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
