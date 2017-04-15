package com.xy.ssm.controller;

import com.xy.ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/9.
 */
public class MessageUtils {
    @Autowired
    private MessageService messageService;

    public void sendMessage(Long uid,String content){
    }
}
