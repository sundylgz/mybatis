package com.sundy.mapper;

import com.sundy.pojo.User;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public interface UserMapper {
    //根据用户id查询用户信息
    User findUserById(int id) throws Exception;

    //插入用户
    void insertUser(User user) throws Exception;

    //删除用户
    void deleteUserById(int id);
}
