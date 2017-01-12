package com.xy.ssm.dao;

import com.xy.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Repository
//养成好习惯，将存储层Bean对应表明
public interface UserDao {
    List<User> selectAllUser();
}
