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

    void sendMessage(CMessage message);

    /**
     * 根据当前用户的类型和id获取自己的消息
     * @param id
     * @return
     */
    List<CMessage> getMessage(@Param ("id") Long id,@Param ("id2") Long id2);
}
