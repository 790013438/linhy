package com.xy.ssm.model;

import java.util.Date;

public class CHomework {
    /*id*/
    private Long id;
    /*发布作业教师id*/
    private Long teacherId;
    /*作业名称*/
    private String homTitle;
    /*作业类型*/
    private String homType;
    /*作业简介*/
    private String homIntroduction;
    /*作业状态*/
    private String homStatus;
    /*创建时间*/
    private Date createTime;
    /*截止时间Date型*/
    private Date homDeadline;
    /*截止时间String型*/
    private String deadline;
    //标志
    private int flag;
    //发布资源教师名字
    private String homTeacherName;
    //该资源申请人数
    private int appliCount;

    public void setAppliCount(int appliCount) {
        this.appliCount = appliCount;
    }

    public int getAppliCount() {
        return appliCount;
    }

    public void setHomTeacherName(String homTeacherName) {
        this.homTeacherName = homTeacherName;
    }

    public String getHomTeacherName() {
        return homTeacherName;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setHomTitle(String homTitle) {
        this.homTitle = homTitle;
    }

    public void setHomType(String homType) {
        this.homType = homType;
    }

    public void setHomIntroduction(String homIntroduction) {
        this.homIntroduction = homIntroduction;
    }

    public void setHomStatus(String homStatus) {
        this.homStatus = homStatus;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setHomDeadline(Date homDeadline) {
        this.homDeadline = homDeadline;
    }

    public Long getId() {
        return id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public String getHomTitle() {
        return homTitle;
    }

    public String getHomType() {
        return homType;
    }

    public String getHomIntroduction() {
        return homIntroduction;
    }

    public String getHomStatus() {
        return homStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getHomDeadline() {
        return homDeadline;
    }
}
