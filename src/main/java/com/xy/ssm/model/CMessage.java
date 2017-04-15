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
    //消息对象ID
    private Long mesObjectId;
    //消息类型
    private int mesType;
    //消息类型
    private String mesContents ;
    //消息状态
    private int mesStatus ;
    //创建时间
    private Date createTime;

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

    public int getMesType() {
        return mesType;
    }

    public void setMesType(int mesType) {
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
