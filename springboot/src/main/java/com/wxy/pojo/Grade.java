package com.wxy.pojo;

public class Grade {
    private String context;
    private String time;
    private Integer num;

    public Grade(String context, String time, Integer num) {
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
