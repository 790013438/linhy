package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 消息表
 */
public class CMessage implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //消息ID
    private Long id;
    //消息发送人ID
    private Long mesSenderId;
	//消息发送人姓名
	private String mesSenderName;
    //消息对象ID
    private Long mesObjectId;
	//消息对象姓名
	private String mesObjectName;
    //消息类型
    private Integer mesType;
    //消息类型
    private String mesContents ;
    //消息状态
    private int mesStatus ;
    //创建时间
    private Date createTime;
	//发送人类型（0教师，1学生，2管理员）
	private Integer mesSenderType;
	//消息对象类型（0教师，1学生，2管理员）
    private Integer mesObjectType;

    public void setMesSenderName(String mesSenderName) {
        this.mesSenderName = mesSenderName;
    }

    public void setMesObjectName(String mesObjectName) {
        this.mesObjectName = mesObjectName;
    }

    public void setMesSenderType(Integer mesSenderType) {
        this.mesSenderType = mesSenderType;
    }

    public void setMesObjectType(Integer mesObjectType) {
        this.mesObjectType = mesObjectType;
    }

    public String getMesSenderName() {
        return mesSenderName;
    }

    public String getMesObjectName() {
        return mesObjectName;
    }

    public Integer getMesSenderType() {
        return mesSenderType;
    }

    public Integer getMesObjectType() {
        return mesObjectType;
    }
    public CMessage() { }
    public CMessage(Long mesSenderId, Long mesObjectId, Integer mesType, String mesContents, int mesStatus, Date createTime, Integer mesSenderType, Integer mesObjectType) {
        this.mesSenderId = mesSenderId;
        this.mesObjectId = mesObjectId;
        this.mesType = mesType;
        this.mesContents = mesContents;
        this.mesStatus = mesStatus;
        this.createTime = createTime;
        this.mesSenderType = mesSenderType;
        this.mesObjectType = mesObjectType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMesSenderId() {
        return mesSenderId;
    }

    public void setMesSenderId(Long mesSenderId) {
        this.mesSenderId = mesSenderId;
    }

    public Long getMesObjectId() {
        return mesObjectId;
    }

    public void setMesObjectId(Long mesObjectId) {
        this.mesObjectId = mesObjectId;
    }

    public Integer getMesType() {
        return mesType;
    }

    public void setMesType(Integer mesType) {
        this.mesType = mesType;
    }

    public String getMesContents() {
        return mesContents;
    }

    public void setMesContents(String mesContents) {
        this.mesContents = mesContents;
    }

    public int getMesStatus() {
        return mesStatus;
    }

    public void setMesStatus(int mesStatus) {
        this.mesStatus = mesStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
