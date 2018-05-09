package com.xy.ssm.dao;

import com.xy.ssm.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wuchen on 2017/1/12.
 */

@Repository
//养成好习惯，将存储层Bean对应表明
public interface UserDao {
    List<User> selectAllUser();
    int updateStudentStatus(@Param("userId") Long userId,@Param("userStatus") int userStatus);
    CUser getUserInfo(@Param("userId")Long userId);
    List<CComment> getUserComment(@Param("userId") Long userId,@Param("offset") Integer offset,@Param("limit")Integer limit);
    int getUserCommentCount(@Param("userId") Long userId);
    List<VOCApplication> getMyAppliSituation(@Param("userId") Long userId,@Param("jobStatus") String jobStatus);
    int quitJob(@Param("applicationId") Long applicationId,@Param("userId") Long userId);
    int delApplication(@Param("applicationId") Long applicationId,@Param("userId") Long userId);
    int updateUserPassword(@Param("newPw") String newPw,@Param("userId") Long userId);
    List<CUser> getAllUsers();
    void addHomFile(Map map);
    List<CHomFile> getMyHomFile(Long userId);
}
