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
    void sendMessage(CMessage message);

    /**
     * 获取当前消息
     * @param id
     * @param id2
     * @return
     */
    List<CMessage> getMessage(Long id,Long id2);

}
