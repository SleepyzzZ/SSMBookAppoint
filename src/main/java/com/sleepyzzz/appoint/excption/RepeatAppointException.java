package com.sleepyzzz.appoint.excption;

/**
 * //重复预约异常
 * Created by ZC on 2018/3/7.
 */
public class RepeatAppointException extends RuntimeException{

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
