package com.todo.model;

import java.util.Date;

/**
 *
 * @author caoxin
 */
public class Task {

    private int id;
    private String sendorAccount;
    private String receiverAccount;
    private String taskTitle;
    private String taskContent;
    private Date finishTime;
    private Date firstRemindTime;
    private Date secondRemindTime;
    private int priority;
    private byte[] media;
    private int status; // 1.完成， 2.未完成，3.接受，4.拒绝

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendorAccount() {
        return sendorAccount;
    }

    public void setSendorAccount(String sendorAccount) {
        this.sendorAccount = sendorAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getFirstRemindTime() {
        return firstRemindTime;
    }

    public void setFirstRemindTime(Date firstRemindTime) {
        this.firstRemindTime = firstRemindTime;
    }

    public Date getSecondRemindTime() {
        return secondRemindTime;
    }

    public void setSecondRemindTime(Date secondRemindTime) {
        this.secondRemindTime = secondRemindTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public byte[] getMedia() {
        return media;
    }

    public void setMedia(byte[] media) {
        this.media = media;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}