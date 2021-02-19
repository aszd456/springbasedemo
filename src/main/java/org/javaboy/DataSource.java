package org.javaboy;/**
 * @author leo
 * @date 2021/2/19
 * @apiNote
 */

/**
 * @ClassName DataSource
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/19 11:08
 * @Version 1.0
 **/
public class DataSource {
    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
