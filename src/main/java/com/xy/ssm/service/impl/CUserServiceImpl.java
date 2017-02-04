package com.xy.ssm.service.impl;

import com.xy.ssm.dao.CUserDao;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.CUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuchenl on 2017/1/28.
 */
@Service("cUserService")
public class CUserServiceImpl implements CUserService {
    @Autowired
    private CUserDao cUserDao;


    /**
     * 检测用户名是否存在
     * @param username
     * @return
     */
    public Integer checkName(String username) {
        return cUserDao.checkName(username);
    }

    /**
     * 检测邮箱是否存在
     *
     * @param email
     * @return
     */
    public Integer checkMail(String email) {
        return cUserDao.checkMail(email);
    }

    /**
     * 检测手机号是否存在
     *
     * @param phone
     * @return
     */
    public Integer checkPhone(String phone) {
        return cUserDao.checkPhone(phone);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    public CUser getUserByUsername(String username) {
         return cUserDao.getUserByUsername(username);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    public CUser getUserById(Long id) {
        return cUserDao.getUserById(id);
    }
}
