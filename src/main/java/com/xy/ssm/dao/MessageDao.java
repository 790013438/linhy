package com.xy.ssm.dao;

import com.xy.ssm.model.CTeacher;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Repository
//养成好习惯，将存储层Bean对应表明
public interface MessageDao
{

    int sendMessage(CMessage message);

    /**
     * 根据当前用户的类型和id获取自己的消息
     * @param
     * @return
     */
    List<CMessage> getMessage(CMessage cMessage);
    String getSenderNameFromCUser(CMessage cMessage);
    String getSenderNameFromCTeacher(CMessage cMessage);
    Integer deleteMessage(String mesId);
}
