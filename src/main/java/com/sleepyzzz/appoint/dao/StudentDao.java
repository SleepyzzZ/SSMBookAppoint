package com.sleepyzzz.appoint.dao;

import com.sleepyzzz.appoint.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ZC on 2018/3/7.
 */
public interface StudentDao {
    /**
     * 向数据库验证输入的密码是否正确
     */
    Student queryStudent(@Param("student") long studentId, @Param("password") long password);
}
