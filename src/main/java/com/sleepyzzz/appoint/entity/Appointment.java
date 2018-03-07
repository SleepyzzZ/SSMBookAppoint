package com.sleepyzzz.appoint.entity;

import java.util.Date;

/**
 * Created by ZC on 2018/3/7.
 */
public class Appointment {

    private long bookId;
    private long studentId;
    private Date appointTime;

    private Book book;

    public Appointment() {
    }

    public Appointment(long bookId, long studentId, Date appointTime) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getBookId() {
        return bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Appointment [bookId=" + bookId + ", studentId=" + studentId + ", appointTime=" + appointTime + ", book="
                + book + "]";
    }
}
