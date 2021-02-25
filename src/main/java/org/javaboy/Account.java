package org.javaboy;/**
 * @author leo
 * @date 2021/2/25
 * @apiNote
 */

import java.math.BigDecimal;

/**
 * @ClassName Account
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/25 14:50
 * @Version 1.0
 **/
public class Account {
    private Integer id;
    private String username;
    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
