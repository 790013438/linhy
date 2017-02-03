package com.xy.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wuchenl on 2017/1/13.
 */
@Controller
@RequestMapping("kn")
public class UrlController {

    private Logger log = Logger.getLogger(UserController.class);

    /**
     * 跳转主页
     * @return
     */
    @RequestMapping("index")
    private String toIndex(){
        log.info("--------------------call:index");
        return "index";
    }

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
}
