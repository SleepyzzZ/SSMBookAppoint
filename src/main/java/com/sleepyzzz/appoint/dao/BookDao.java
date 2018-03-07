package com.sleepyzzz.appoint.dao;

import com.sleepyzzz.appoint.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZC on 2018/3/7.
 */
public interface BookDao {

    Book queryById(long id);
    List<Book> querySome(String name);
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int reduceNumber(long bookId);
}
