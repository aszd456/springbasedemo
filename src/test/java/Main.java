import org.javaboy.JdbcConfig;
import org.javaboy.JdbcUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: zhouliansheng
 * @Date: 2021/2/22 23:15
 */
public class Main {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void insert() {
        jdbcTemplate.update("insert into jdbcuser (username,address) values (?,?);", "javaboy", "www.javaboy.org");
    }

    @Test
    public void update() {
        jdbcTemplate.update("update jdbcuser set username=? where id=?", "javaboy123", 1);

    }

    @Test
    public void delete() {
        jdbcTemplate.update("delete from jdbcuser where id=?", 2);
    }

    /**
     * 在查询时，如果使用了 BeanPropertyRowMapper，要求查出来的字段必须和 Bean 的属性名一一对应。
     * 如果不一样，则不要使用 BeanPropertyRowMapper，此时需要自定义 RowMapper 或者给查询的字段取别名。
     */
    @Test
    public void select() {
        JdbcUser user = jdbcTemplate.queryForObject("select * from jdbcuser where id=?",
                new BeanPropertyRowMapper<JdbcUser>(JdbcUser.class), 1);
        System.out.println(user);
    }

    /**
     * 给查询出来的列取别名
     */
    @Test
    public void select2() {
        JdbcUser user = jdbcTemplate.queryForObject("select id,username as name,address from user where id=?",
                new BeanPropertyRowMapper<JdbcUser>(JdbcUser.class), 1);
        System.out.println(user);
    }

    /**
     * 自定义mapper
     */
    @Test
    public void select3() {
        JdbcUser user = jdbcTemplate.queryForObject("select * from user where id=?", (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String address = resultSet.getString("address");
            JdbcUser u = new JdbcUser();
            u.setId(id);
            u.setUsername(username);
            u.setAddress(address);
            return u;
        }, 1);
        System.out.println(user);
    }


}
