package com.xy.ssm.service;

/**
 * Created by wuchenl on 2017/1/28.
 */
public interface CUserService {
    /**
     * 检测用户名是否存在
     * @param username
     * @return
     */
    Integer checkName(String username);

    /**
     * 检测邮箱是否存在
     * @param email
     * @return
     */
    Integer checkMail(String email);

    /**
     * 检测手机号是否存在
     * @param phone
     * @return
     */
    Integer checkPhone(String phone);
}
