package com.xy.ssm.dao;

import com.xy.ssm.model.CUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    Integer checkName(@Param("username")String username);

    /**
     * 检测邮箱是否存在
     * @param email
     * @return
     */
    Integer checkMail(@Param("email")String email);

    /**
     * 检测手机号是否存在
     * @param phone
     * @return
     */
    Integer checkPhone(@Param("phone")String phone);



}
