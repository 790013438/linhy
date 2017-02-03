package com.xy.ssm.service.impl;

import com.xy.ssm.dao.CUserDao;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.RegisterValidateService;
import com.xy.ssm.utils.MD5Util;
import com.xy.ssm.utils.SendEmail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wuchen on 2017/1/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterValidateServiceImpl implements RegisterValidateService {

    @Resource
    private CUserDao cUserDao;
    private Logger log = Logger.getLogger(RegisterValidateServiceImpl.class);
    /**
     * 注册用户
     *
     * @param user
     */
    public Long processRegister(CUser user) {
        user.setValidateCode(MD5Util.encode2hex(user.getUserEmail()));

        cUserDao.regUser(user);//保存注册信息
        ///邮件的内容
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/demo/kn/register?action=activate&email=");
        sb.append(user.getUserEmail());
        sb.append("&validateCode=");
        sb.append(user.getValidateCode());
        sb.append("\">http://localhost:8080/demo/kn/register?action=activate&email=");
        sb.append(user.getUserEmail());
        sb.append("&validateCode=");
        sb.append(user.getValidateCode());
        sb.append("</a>");

        //发送邮件
        SendEmail.send(user.getUserEmail(), sb.toString());
        log.info(user.getUserEmail()+'\t'+sb.toString());
        log.info("发送邮件");
        return user.getId();
    }

    /**
     * 激活邮箱信息
     *
     * @param email
     * @param validateCode
     */
    public void processActive(String email, String validateCode) {

    }
}
