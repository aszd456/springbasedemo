package org.javaboy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 16:24
 * @Version 1.0
 **/
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Cat cat;
    private String[] favorites;
    private List<Cat> cats;
    private Map<String, Object> map;
    private Properties info;

    public User() {
    }

    public User(Integer id, String name, Integer age, Cat cat) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cat=" + cat +
                ", favorites=" + Arrays.toString(favorites) +
                ", cats=" + cats +
                ", map=" + map +
                ", info=" + info +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public void doSth() {
        Book book = new Book();
        book.setId(1L);
        book.setName("故事新编");
        book.setPrize(20.0);
    }
}
