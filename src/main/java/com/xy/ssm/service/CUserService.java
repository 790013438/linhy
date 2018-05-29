package com.xy.ssm.service;

import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CHomework;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;

import java.util.List;

/**
 * Created by wuchenl on 2017/1/28.
 */
public interface CUserService {
    /**
     * 检测用户名是否存在
     * @param username
     * @return
     */
    List<CUser> checkName(String username);

    /**
     * 检测邮箱是否存在
     * @param email
     * @return
     */
    List<CUser> checkMail(String email);

    /**
     * 检测手机号是否存在
     * @param phone
     * @return
     */
    List<CUser> checkPhone(String phone);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    CUser getUserByUsername(String username,int userType);

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    CUser getUserById(Long id);

    int addJobApplication(CApplication cApplication);
    int addHomApplication(CApplication cApplication);

   List<CJobs> getJobList(String condition,Integer offset,Integer limit);
    /*获取未截止作业列表*/
    List<CHomework> getHomList(String condition,Integer offset,Integer limit);
    int getJobCount(String condition,Integer offset,Integer limit);
    int getHomount(String condition,Integer offset,Integer limit);
    int updateUser(CUser cUser);
    CApplication getAppliByTwoId(Long jobId,Long userId);
    CApplication getHomAppliByTwoId(Long jobId,Long userId);
}
