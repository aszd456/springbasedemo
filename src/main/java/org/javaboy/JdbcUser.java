package org.javaboy;

/**
 * @Author: zhouliansheng
 * @Date: 2021/2/22 23:08
 */
public class JdbcUser {

    private Integer id;
    private String username;
    private String address;

    @Override
    public String toString() {
        return "JdbcUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
