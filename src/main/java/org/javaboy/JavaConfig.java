package org.javaboy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * java 配置
 * 通过 @ComponentScan 注解指定要扫描的包（如果不指定，默认情况下扫描的是配置类所在的包下载的 Bean 以及配置类所在的包下的子包下的类）
 * @ClassName JavaConfig
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 17:18
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = "org.javaboy.service")
//这个配置表示扫描 org.javaboy.javaconfig 下的所有 Bean，但是除了 Controller
//@ComponentScan(basePackages = "org.javaboy.javaconfig",useDefaultFilters = true,
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
public class JavaConfig {
    @Bean
    SayHello sayHello(){
        return new SayHello();
    }
}
