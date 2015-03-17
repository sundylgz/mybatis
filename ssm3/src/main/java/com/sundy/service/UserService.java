package com.sundy.service;

import com.sundy.pojo.User;

/**
 * Created by liuguozhu on 2015/3/16.
 */
public interface UserService {

    //根据用户id查询用户信息
    User findUserById(int id) throws Exception;

    //插入用户
    void insertUser(User user) throws Exception;

    //保存用户
    void saveUser() throws Exception;


}
