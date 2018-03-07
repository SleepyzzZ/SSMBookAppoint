package com.sleepyzzz.appoint.bto;

import com.sleepyzzz.appoint.enums.AppointStateEnum;

/**
 * Created by ZC on 2018/3/7.
 */
public class AppointmentExecution {

    // 图书ID
    private long bookId;

    // 预约结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    public AppointmentExecution() {
    }

    // 预约失败的构造器
    public AppointmentExecution(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //set get 方法！
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "AppointExecution [bookId=" + bookId + ", state=" + state + ", stateInfo=" + stateInfo+"]";
    }

}
