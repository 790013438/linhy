package com.xy.ssm.service;

import com.xy.ssm.model.CUser;

/**
 * Created by wuchen on 2017/1/14.
 * 邮箱注册，激活时使用
 */
public interface RegisterValidateService {

    /**
     * 注册用户
     */
    Long processRegister(CUser user);

    /**
     * 激活邮箱信息
     * @param email
     * @param validateCode
     */
    void processActive(String email,String validateCode);
}
