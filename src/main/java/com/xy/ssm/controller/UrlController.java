package com.xy.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wuchenl on 2017/1/13.
 */
@Controller
public class UrlController {

    private Logger log = Logger.getLogger(UserController.class);


    /**
     * 跳转登录
     * @return
     */
    @RequestMapping("login")
    private String toLogin(){
        log.info("--------------------call:login");
        return "login";
    }

    /**
     * 跳转注册
     * @return
     */
    @RequestMapping("register")
    private String toRegister(){
        log.info("--------------------call:register");
        return "register";
    }

    /**
     * get方式访问后台所有页面
     * @param action
     * @return
     */
    @RequestMapping(value="/system/{action}",method= RequestMethod.GET)
    public String getSystem(@PathVariable("action") String action){
        log.info("getUrl:system/"+action);
        return "system/"+action;
    }

    /**
     * get方式访问后台所有页面
     * @param action
     * @return
     */
    @RequestMapping(value="/student/{action}",method= RequestMethod.GET)
    public String getStudent(@PathVariable("action") String action){
        log.info("getUrl:student/"+action);
        return "student/"+action;
    }

    /**
     * get方式访问后台所有页面
     * @param action
     * @return
     */
    @RequestMapping(value="/teacher/{action}",method= RequestMethod.GET)
    public String getTeacher(@PathVariable("action") String action){
        log.info("getUrl:teacher/"+action);
        return "teacher/"+action;
    }
}
