package com.sleepyzzz.appoint.excption;

/**
 * 库存不足异常
 * Created by ZC on 2018/3/7.
 */
public class NoNumberException extends RuntimeException {
    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
