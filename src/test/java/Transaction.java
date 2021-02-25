/**
 * @author leo
 * @date 2021/2/25
 * @apiNote
 */

import org.javaboy.JdbcConfig;
import org.javaboy.service.AccountService;
import org.javaboy.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *@ClassName Transaction
 *@Description TODO
 *@Author zhouliansheng
 *@Date 2021/2/25 15:38
 *@Version 1.0
 **/
public class Transaction {

    JdbcTemplate jdbcTemplate;
    AccountService accountService;

    @Before
    public void before() {
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        accountService = ctx.getBean(AccountService.class);
    }

    @Test
    public void test1() {
        accountService.updateMoney();
    }
}
