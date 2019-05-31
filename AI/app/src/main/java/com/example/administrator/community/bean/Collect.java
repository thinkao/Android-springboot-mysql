package com.example.administrator.community.bean;

/**
 * Created by Administrator on 2019/5/10.
 */

public class Collect {
    private String cid;
    private String context;
    private String time;

    public Collect(String cid, String context, String time) {
        this.cid = cid;
        this.context = context;
        this.time = time;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
}
