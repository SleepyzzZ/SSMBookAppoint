package com.sleepyzzz.appoint.entity;

/**
 * Created by ZC on 2018/3/7.
 */
public class Student {

    private Long studentId;
    private Long password;

    public Student() {
    }

    public Student(Long studentId, Long password) {
        this.studentId = studentId;
        this.password = password;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", password=" + password + "]";
    }
}