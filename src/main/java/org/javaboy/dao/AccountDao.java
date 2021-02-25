package org.javaboy.dao;/**
 * @author leo
 * @date 2021/2/25
 * @apiNote
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *@ClassName AccountDao
 *@Description TODO
 *@Author zhouliansheng
 *@Date 2021/2/25 14:54
 *@Version 1.0
 **/
@Repository
public class AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMoney(String username, Integer money) {
        jdbcTemplate.update("update account set money=money+? where username=?", money, username);
    }

    public void minMoney(String username, Integer money) {
        jdbcTemplate.update("update account set money=money-? where username=?", money, username);
    }
}
