package com.xy.ssm.controller;

import com.xy.ssm.model.CMessage;
import com.xy.ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/9.
 */
public class MessageUtils {
    /**
     * 传入消息
     * @param id1
     * @param id2
     * @param type
     * @param content
     * @return
     */
    public static CMessage getMessage(Long id1,Long id2,int type,String content){
        CMessage cMessage=new CMessage ();
        cMessage.setMesSenderId (id1);
        cMessage.setMesObjectId (id2);
        cMessage.setMesType (type);
        cMessage.setMesContents (content);
        return cMessage;
    }
}
