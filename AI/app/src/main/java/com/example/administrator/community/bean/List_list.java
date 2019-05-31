package com.example.administrator.community.bean;

/**
 * Created by Administrator on 2019/5/11.
 */

public class List_list {
    private String lid;
    private String lcontext;
    private String ltime;

    public List_list(String lid, String lcontext, String ltime) {
        this.lid = lid;
        this.lcontext = lcontext;
        this.ltime = ltime;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getLcontext() {
        return lcontext;
    }

    public void setLcontext(String lcontext) {
        this.lcontext = lcontext;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }
}
