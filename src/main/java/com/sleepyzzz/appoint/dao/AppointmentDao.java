package com.sleepyzzz.appoint.dao;

import com.sleepyzzz.appoint.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZC on 2018/3/7.
 */
public interface AppointmentDao {

    //通过图书ID和学生ID预约书籍，并插入
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    //通过一个学生ID查询已经预约了哪些书
    List<Appointment> queryAndReturn(long studentId);
}
