package com.xy.ssm.service.impl;

import com.xy.ssm.dao.UserDao;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CUser;
import com.xy.ssm.model.User;
import com.xy.ssm.model.VOCApplication;
import com.xy.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Service
@Transactional(rollbackFor = Exception.class)
//上面是说如果发生异常时，将回滚到之前的状态
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public int updateStudentStatus (Long userId, int userStatus)
    {
        return userDao.updateStudentStatus(userId,userStatus);
    }

    public CUser getUserInfo (Long userId)
    {
        return userDao.getUserInfo(userId);
    }

    public List<CComment> getUserComment (Long userId, Integer offset, Integer limit)
    {
        return userDao.getUserComment(userId,offset,limit);
    }

    public int getUserCommentCount (Long userId)
    {
        return userDao.getUserCommentCount(userId);
    }

    public List<VOCApplication> getMyAppliSituation (Long userId, String jobStatus)
    {
        return userDao.getMyAppliSituation(userId,jobStatus);
    }

    public int quitJob (Long applicationId, Long userId)
    {
        return userDao.quitJob(applicationId,userId);
    }

    public int updateUserPassword (String newPw, Long userId)
    {
        return userDao.updateUserPassword(newPw,userId);
    }

    public int delApplication (Long applicationId, Long userId)
    {
        return userDao.delApplication(applicationId,userId);
    }

    @Override
    public List<CUser> getAllUsers ()
    {
        return userDao.getAllUsers();
    }
}
