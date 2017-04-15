package com.xy.ssm.dao;

import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuchenl on 2017/1/21.
 */
@Repository
public interface CUserDao {
    /**
     * 注册用户
     * @param cuser
     * @return
     */
    Long regUser(CUser cuser);

    /**
     * 检测用户名是否存在
     * @param username
     * @return
     */
    List<CUser> checkName(@Param("username")String username);

    /**
     * 检测邮箱是否存在
     * @param email
     * @return
     */
    List<CUser> checkMail(@Param("email")String email);

    /**
     * 检测手机号是否存在
     * @param phone
     * @return
     */
    List<CUser> checkPhone(@Param("phone")String phone);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    CUser getUserByUsername(@Param("username")String username,@Param("userType") int userType);

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    CUser getUserById(@Param("id")Long id);

    int addJobApplication(CApplication cApplication);

    List<CJobs> getJobList (@Param("condition")String condition,@Param("offset")Integer offset,@Param("limit")Integer limit);
    int getJobCount(@Param("condition")String condition,@Param("offset")Integer offset,@Param("limit")Integer limit);
    int updateUser(CUser cUser);
    CApplication getAppliByTwoId(@Param("jobId")Long jobId,@Param("userId") Long userId);


}
