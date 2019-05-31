package com.example.administrator.community.bean;

/**
 * Created by Administrator on 2019/5/14.
 */

public class User {
    private String uid;
    private String username;
    private String upassword;
    private String uname;

    public User(String uid, String username, String upassword, String uname) {
        this.uid = uid;
        this.username = username;
        this.upassword = upassword;
        this.uname = uname;
    }

    public User(String username, String upassword,String uname) {
        this.username = username;
        this.upassword = upassword;
        this.uname = uname;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
