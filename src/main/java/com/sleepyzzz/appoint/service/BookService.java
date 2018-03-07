package com.sleepyzzz.appoint.service;

import com.sleepyzzz.appoint.bto.AppointmentExecution;
import com.sleepyzzz.appoint.entity.Appointment;
import com.sleepyzzz.appoint.entity.Book;
import com.sleepyzzz.appoint.entity.Student;

import java.util.List;

/**
 * Created by ZC on 2018/3/7.
 */
public interface BookService {

    /**
     *
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     *
     * @return
     */
    List<Book> getList();

    /**
     *
     * @param studentId
     * @param password
     * @return
     */
    Student validateStu(Long studentId, Long password);

    /**
     *
     * @param name
     * @return
     */
    List<Book> getSomeList(String name);

    /**
     *
     * @param studentId
     * @return
     */
    List<Appointment> getAppointByStu(long studentId);

    AppointmentExecution appoint(long bookId, long studentId);
}
