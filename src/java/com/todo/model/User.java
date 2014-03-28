package com.todo.model;

import java.util.Date;

/**
 *
 * @author caoxin
 */
public class User {

    private int id;
    private String account;
    private String passwd;
    private String email;
    private Date createTime;
    private int valied; // 是否有效
    private int activited; // 是否被激活

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getValied() {
        return valied;
    }

    public void setValied(int valied) {
        this.valied = valied;
    }

    public int getActivited() {
        return activited;
    }

    public void setActivited(int activited) {
        this.activited = activited;
    }
}