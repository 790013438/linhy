package com.xy.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CMessage;
import com.xy.ssm.model.CUser;
import com.xy.ssm.model.User;
import com.xy.ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
@RequestMapping("message")
public class MessageController extends BaseController
{

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/getMessage", produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitAudit (int type)
    {
        String result = "";
        BaseResult baseResult = null;
        try
        {
            Long sendId;
            Long objId;
            if (type == 1)
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                sendId=curUser.getId ();
                objId=1L;
            } else if (type == 2)
            {
                CCompany curUser = (CCompany) getLoginUser ().get ("loginuser");
                sendId=curUser.getId ();
                objId=2L;
            } else
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                sendId=curUser.getId ();
                objId=3L;
            }
            log.info (sendId+"---------"+objId);
            List<CMessage> messages = messageService.getMessage (sendId,objId);
            if(messages != null && 0<messages.size()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CMessage>(messages);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "没有查询到相关信息");
            }
        } catch (Exception e)
        {
            log.error ("获取信息异常" + e);
            baseResult = new BaseResult (false, "获取信息异常");
        }
        result = JSON.toJSONString (baseResult);
        return result;
    }
}
