package com.xy.ssm.service.impl;


import com.xy.ssm.dao.MessageDao;
import com.xy.ssm.model.CMessage;
import com.xy.ssm.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Service
@Transactional(rollbackFor = Exception.class)
//上面是说如果发生异常时，将回滚到之前的状态
public class MessageServiceImpl implements MessageService
{
    
    @Resource
    private MessageDao messageDao;


    /**
     * 发送消息
     *
     * @param message
     */
    @Override
    public int sendMessage (CMessage message)
    {
        return messageDao.sendMessage (message);
    }

    /**
     * 获取当前消息
     * @return
     */
    @Override
    public List<CMessage> getMessage (CMessage cMessage)
    {
        return messageDao.getMessage (cMessage);
    }

    @Override
    public String getSenderNameFromCUser(CMessage cMessage) {
        return messageDao.getSenderNameFromCUser(cMessage);
    }

    @Override
    public String getSenderNameFromCTeacher(CMessage cMessage) {
        return messageDao.getSenderNameFromCTeacher(cMessage);
    }
/*消息状态为删除*/
    @Override
    public Integer deleteMessage(String mesId) {
        return messageDao.deleteMessage(mesId);
    }
}
