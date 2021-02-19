package org.javaboy;

import org.javaboy.service.LinuxShowCmdServiceImpl;
import org.javaboy.service.ShowCmdService;
import org.javaboy.service.WinShowCmdServiceImpl;
import org.springframework.context.annotation.*;

/**
 * java 配置
 * 通过 @ComponentScan 注解指定要扫描的包（如果不指定，默认情况下扫描的是配置类所在的包下载的 Bean 以及配置类所在的包下的子包下的类）
 *
 * @ClassName JavaConfig
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 17:18
 * @Version 1.0
 **/
@Configuration
//混合配置
//@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = "org.javaboy.service")
//这个配置表示扫描 org.javaboy.javaconfig 下的所有 Bean，但是除了 Controller
//@ComponentScan(basePackages = "org.javaboy.javaconfig",useDefaultFilters = true,
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
public class JavaConfig {
    @Bean
    SayHello sayHello() {
        return new SayHello();
    }

    /**
     * 一定要给两个bean相同的名字，在调用时才可以自动匹配
     * 给每个bean加上条件注解，当条件中的matches方法返回true就会生效
     * @return
     */
    @Bean("showCmd")
    @Conditional(WinCondition.class)
    ShowCmdService winCmd() {
        return new WinShowCmdServiceImpl();
    }

    @Bean("showCmd")
    @Conditional(LinuxCondition.class)
    ShowCmdService linuxCmd() {
        return new LinuxShowCmdServiceImpl();
    }

    @Bean("ds")
    @Profile("dev")
    DataSource devDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setUserName("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean("ds")
    @Profile("prod")
    DataSource prodDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:mysql://192.168.1.168:3306/dev");
        dataSource.setUserName("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

}
