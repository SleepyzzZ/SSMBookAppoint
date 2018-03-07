package com.sleepyzzz.appoint.entity;

/**
 * Created by ZC on 2018/3/7.
 */
public class Book {

    private long bookId;
    private String name;
    private int number;
    private int introd;

    public Book() {

    }

    public Book(long bookId, String name, int number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    public void setbookId(long bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setIntrod(int introd) {
        this.introd = introd;
    }

    public long getbookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getIntrod() {
        return introd;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + ", introd=" + introd + "]";
    }
}
