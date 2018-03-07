package com.sleepyzzz.appoint.service.impl;

import com.sleepyzzz.appoint.bto.AppointmentExecution;
import com.sleepyzzz.appoint.dao.AppointmentDao;
import com.sleepyzzz.appoint.dao.BookDao;
import com.sleepyzzz.appoint.dao.StudentDao;
import com.sleepyzzz.appoint.entity.Appointment;
import com.sleepyzzz.appoint.entity.Book;
import com.sleepyzzz.appoint.entity.Student;
import com.sleepyzzz.appoint.enums.AppointStateEnum;
import com.sleepyzzz.appoint.excption.AppointException;
import com.sleepyzzz.appoint.excption.NoNumberException;
import com.sleepyzzz.appoint.excption.RepeatAppointException;
import com.sleepyzzz.appoint.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZC on 2018/3/7.
 */
public class BookServiceImpl implements BookService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookDao bookDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    AppointmentDao appointmentDao;

    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    public Student validateStu(Long studentId, Long password) {
        return studentDao.queryStudent(studentId, password);
    }

    public List<Book> getSomeList(String name) {
        return bookDao.querySome(name);
    }

    public List<Appointment> getAppointByStu(long studentId) {
        return appointmentDao.queryAndReturn(studentId);
    }

    @Transactional
    public AppointmentExecution appoint(long bookId, long studentId) {
        try {
            int update = bookDao.reduceNumber(bookId);
            if (update < 0) {
                throw new NoNumberException("no number");
            } else {
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {
                    throw new RepeatAppointException("repeat appoint");
                } else {
                    return new AppointmentExecution(bookId, AppointStateEnum.SUCCESS);
                }
            }
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
