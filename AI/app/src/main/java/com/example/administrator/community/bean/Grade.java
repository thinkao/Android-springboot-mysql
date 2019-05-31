package com.example.administrator.community.bean;

import java.util.Date;

/**
 * Created by Administrator on 2019/5/16.
 */

public class Grade {
    private String context;
    private String time;
    private String num;

    public Grade(String context, String time, String num) {
        this.context = context;
        this.time = time;
        this.num = num;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
