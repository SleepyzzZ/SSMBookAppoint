package com.sleepyzzz.appoint.excption;

/**
 * 预约业务异常
 * Created by ZC on 2018/3/7.
 */
public class AppointException extends RuntimeException{

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
