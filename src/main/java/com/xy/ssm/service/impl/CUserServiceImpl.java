package com.xy.ssm.service.impl;

import com.xy.ssm.dao.CUserDao;
import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CHomework;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.CUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CUser> checkName(String username) {
        return cUserDao.checkName(username);
    }

    /**
     * 检测邮箱是否存在
     *
     * @param email
     * @return
     */
    public List<CUser>  checkMail(String email) {
        return cUserDao.checkMail(email);
    }

    /**
     * 检测手机号是否存在
     *
     * @param phone
     * @return
     */
    public List<CUser> checkPhone(String phone) {
        return cUserDao.checkPhone(phone);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    public CUser getUserByUsername(String username,int userType) {
         return cUserDao.getUserByUsername(username,userType);
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

    public int addJobApplication (CApplication cApplication)
    {
        return cUserDao.addJobApplication(cApplication);
    }

    @Override
    public int addHomApplication(CApplication cApplication) {
        return cUserDao.addHomApplication(cApplication);
    }

    public List<CJobs> getJobList (String condition, Integer offset, Integer limit)
    {
        return cUserDao.getJobList(condition,offset,limit);
    }
 /*获取可报名作业列表*/
    @Override
    public List<CHomework> getHomList(String condition, Integer offset, Integer limit) {
        return cUserDao.getHomList(condition,offset,limit);
    }

    public int getJobCount (String condition, Integer offset, Integer limit)
    {
        return cUserDao.getJobCount(condition,offset,limit);
    }

    @Override
    public int getHomount(String condition, Integer offset, Integer limit) {
        return cUserDao.getHomCount(condition,offset,limit);
    }

    public int updateUser (CUser cUser)
    {
        return cUserDao.updateUser(cUser);
    }

    public CApplication getAppliByTwoId (Long jobId, Long userId)
    {
        return cUserDao.getAppliByTwoId(jobId,userId);
    }

    @Override
    public CApplication getHomAppliByTwoId(Long jobId, Long userId) {
        return cUserDao.getHomAppliByTwoId(jobId,userId);
    }
}
