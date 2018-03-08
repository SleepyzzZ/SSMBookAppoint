package com.sleepyzzz.appoint.web;

import com.sleepyzzz.appoint.bto.AppointmentExecution;
import com.sleepyzzz.appoint.dto.Result;
import com.sleepyzzz.appoint.entity.Appointment;
import com.sleepyzzz.appoint.entity.Book;
import com.sleepyzzz.appoint.entity.Student;
import com.sleepyzzz.appoint.enums.AppointStateEnum;
import com.sleepyzzz.appoint.excption.NoNumberException;
import com.sleepyzzz.appoint.excption.RepeatAppointException;
import com.sleepyzzz.appoint.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZC on 2018/3/7.
 */
@Controller
@RequestMapping("/books")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService;

    //获取图书列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String List(Model model) {
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);

        return "list";
    }

    //搜索是否有某图书
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    private void search(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        String name = req.getParameter("name");
        name = name.trim();
        req.setAttribute("name", name);
        req.setAttribute("list", bookService.getSomeList(name));
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }

    //查看某图书的详细情况
    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redict:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        System.out.println(book);

        return "detail";
    }

    //验证输入的用户名密码是否正确
    @RequestMapping(value = "/verify", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    private Map validate(Long studentId, Long password) {

        Map resultMap = new HashMap();
        Student student = null;
        System.out.println("验证函数");
        student = bookService.validateStu(studentId, password);

        System.out.println("输入的学号、密码："+studentId+":"+password);
        System.out.println("查询到的："+student.getStudentId()+":"+student.getPassword());

        if(student!=null){
            System.out.println("SUCCESS");
            resultMap.put("result", "SUCCESS");
            return resultMap;
        }else{
            resultMap.put("result", "FAILED");
            return resultMap;
        }
    }

    //执行预约的逻辑
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<AppointmentExecution> execute(@PathVariable("bookId") Long bookId,
                                                 @RequestParam("studentId") Long studentId) {

        Result<AppointmentExecution> result;
        AppointmentExecution execution = null;

        try {
            execution = bookService.appoint(bookId, studentId);
            result = new Result<AppointmentExecution>(true, execution);
            return result;
        } catch (NoNumberException e1) {
            execution=new AppointmentExecution(bookId, AppointStateEnum.NO_NUMBER);
            result=new Result<AppointmentExecution>(true,execution);
            return result;
        } catch (RepeatAppointException e2) {
            execution=new AppointmentExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
            result=new Result<AppointmentExecution>(true,execution);
            return result;
        } catch (Exception e) {
            execution=new AppointmentExecution(bookId,AppointStateEnum.INNER_ERROR);
            result=new Result<AppointmentExecution>(true,execution);
            return result;
        }
    }

    @RequestMapping(value = "/appoint")
    private String appointBooks(@RequestParam("studentId") long studentId, Model model) {

        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList = bookService.getAppointByStu(studentId);
        model.addAttribute("appointList", appointmentList);
        return "appointBookList";
    }
}

