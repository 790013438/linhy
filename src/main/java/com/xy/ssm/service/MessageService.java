package com.xy.ssm.service;

import com.xy.ssm.model.*;

import java.util.List;

/**
 * Created by wuchenl on 2017/1/28.
 */
public interface MessageService
{

    /**
     * 发送消息
     * @param message
     */
    int sendMessage(CMessage message);

    /**
     * 获取当前消息
     * @return
     */
    List<CMessage> getMessage(CMessage cMessage);
    /*得到消息发送者的名字*/
    String getSenderNameFromCUser(CMessage cMessage);
    String getSenderNameFromCTeacher(CMessage cMessage);
    /*消息状态为删除*/
    Integer deleteMessage(String mesId);
}
