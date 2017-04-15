package com.xy.ssm.service.impl;


import com.xy.ssm.dao.MessageDao;
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


}
