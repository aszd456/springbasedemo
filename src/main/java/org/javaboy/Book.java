package org.javaboy;

/**
 * @ClassName Book
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 15:15
 * @Version 1.0
 **/
public class Book {
    private Long id;
    private String name;
    private Double prize;

    public Book() {
        System.out.println("book init");
    }

    public Book(Long id, String name, Double prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }
}
