package com.xy.ssm.service;

import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CUser;
import com.xy.ssm.model.User;
import com.xy.ssm.model.VOCApplication;

import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */
public interface UserService {

    List<User> getAllUser();
    int updateStudentStatus(Long userId,int userStatus);
    CUser getUserInfo (Long userId);
    List<CComment> getUserComment(Long userId, Integer offset, Integer limit);
    int getUserCommentCount(Long userId);
    List<VOCApplication> getMyAppliSituation(Long userId,String jobStatus);
    int quitJob(Long applicationId,Long userId);
    int updateUserPassword(String newPw,Long userId);
}
