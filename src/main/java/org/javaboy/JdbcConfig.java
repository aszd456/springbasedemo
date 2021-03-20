package org.javaboy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: zhouliansheng
 * @Date: 2021/2/22 23:06
 * 这里，提供两个 Bean，一个是 DataSource 的 Bean，另一个是 JdbcTemplate 的 Bean，
 * JdbcTemplate 的配置非常容易，只需要 new 一个 Bean 出来，然后配置一下 DataSource 就可以
 */
@Configuration
//@ImportResource("applicationContext.xml")
@ComponentScan(basePackages = "org.javaboy.service")
@EnableTransactionManagement
public class JdbcConfig {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useSSL=false");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
