package com.xy.ssm.service;

import com.xy.ssm.model.*;

import java.util.List;
import java.util.Map;

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
    int delApplication(Long applicationId,Long userId);
    List<CUser> getAllUsers();
    void addHomFile(Map map);
    /*查询本人上传作业文件详情*/
    List<CHomFile> getMyHomFile(Long userId);
}
