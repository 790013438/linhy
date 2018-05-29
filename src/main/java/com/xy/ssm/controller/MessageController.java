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
import java.util.Date;
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

    /**
     * 得到消息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getMessage", produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String getMessage (HttpServletRequest request)
    {
        String type=request.getParameter("type");
        String result = "";
        BaseResult baseResult = null;
        CMessage cMessage=new CMessage();
        try
        {
            Long sendId;
            Long objId;
            if ("1".equals(type))/*学生*/
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                cMessage.setMesObjectType(1);
                cMessage.setMesObjectId(curUser.getId());
                objId=1L;
            } else if ("0".equals(type))/*教师*/
            {
                CTeacher curUser = (CTeacher) getLoginUser ().get ("loginuser");
                cMessage.setMesObjectType(0);
                cMessage.setMesObjectId(curUser.getId());
            } else/*管理员*/
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                cMessage.setMesObjectType(2);
                cMessage.setMesObjectId(null);
            }
           /* log.info (sendId+"---------"+objId);*/
            List<CMessage> messages = messageService.getMessage (cMessage);
            if(messages != null && 0<messages.size()) {
                /*得到发送消息的名字*/
                for (int i=0;i<messages.size();i++){
                    if(messages.get(i).getMesSenderType()==0){
                        messages.get(i).setMesSenderName(messageService.getSenderNameFromCTeacher(messages.get(i)));
                    }else{
                        messages.get(i).setMesSenderName(messageService.getSenderNameFromCUser(messages.get(i)));
                    }
                }
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

    /**
     * 将消息记录删除（记录标识为删除）
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteMessage", produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteMessage (HttpServletRequest request)
    {
        String result = "";
        BaseResult baseResult = null;
        try
        {
            String mesId=request.getParameter("mesId");
            int number=messageService.deleteMessage (mesId);
            if(number>0) {
                baseResult = new BaseResult(true, "消息记录删除成功");
            } else {
                baseResult = new BaseResult(false, "消息记录删除失败");
            }
        } catch (Exception e)
        {
            log.error ("删除消息记录异常" + e);
            baseResult = new BaseResult (false, "删除消息记录异常");
        }
        result = JSON.toJSONString (baseResult);
        return result;
    }

    /**
     * 发送消息
     * @param objectId 消息接收者id
     * @param senderType 消息发送人类型
     * @param con 消息内容
     * @param objectType 消息接受者类型
     * @param mesType 消息类型
     * @return
     */
    @RequestMapping(value = "/sendMessage", produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String sendMessage (@RequestParam(required = true)Long objectId,
                               @RequestParam(required = true)Integer senderType,
                               @RequestParam(required = true)String con,
                               @RequestParam(required = false)Integer objectType,
                               @RequestParam(required = false)Integer mesType){
        String result = "";
        BaseResult baseResult = null;

        if (con==null||con==""){
            baseResult=new BaseResult(false,"留言内容为空，留言失败");
        }else{
            CMessage cMessage=new CMessage();
            if ("1".equals(senderType.toString()))/*学生*/
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                cMessage.setMesSenderType(1);
                cMessage.setMesSenderId(curUser.getId());
            } else if ("0".equals(senderType.toString()))/*教师*/
            {
                CTeacher curUser = (CTeacher) getLoginUser ().get ("loginuser");
                cMessage.setMesSenderType(0);
                cMessage.setMesSenderId(curUser.getId());
            } else/*管理员*/
            {
                CUser curUser = (CUser) getLoginUser ().get ("loginuser");
                cMessage.setMesSenderType(2);
                cMessage.setMesSenderId(curUser.getId());
            }
            cMessage.setMesObjectId(objectId);
            cMessage.setMesObjectType(objectType);
            cMessage.setMesContents(con);
            cMessage.setMesType(mesType);
            cMessage.setMesStatus(0);
            cMessage.setCreateTime(new Date());
            int number=messageService.sendMessage (cMessage);
            if(number>0) {
                baseResult = new BaseResult(true, "留言信息成功发送");
            } else {
                baseResult = new BaseResult(false, "留言信息发送失败");
            }
        }
        result = JSON.toJSONString (baseResult);
        return result;
    }
}
