package com.xy.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.CTeacher;
import com.xy.ssm.model.CMessage;
import com.xy.ssm.model.CUser;
import com.xy.ssm.model.User;
import com.xy.ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
@RequestMapping("/message")
@SessionAttributes("currentUser")//讲登录后命名为currentUser的加入session
public class MessageController extends BaseController
{

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/getMessage", produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitAudit (HttpServletRequest request)
    {
        String type=request.getParameter("type");
        String result = "";
        BaseResult baseResult = null;
        try
        {
            Long sendId;
            Long objId;
            if ("1".equals(type))/*学生*/
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                sendId=curUser.getId ();
                objId=1L;
            } else if ("2".equals(type))/*教师*/
            {
                CTeacher curUser = (CTeacher) getLoginUser ().get ("loginuser");
                sendId=curUser.getId ();
                objId=2L;
            } else/*管理员*/
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
