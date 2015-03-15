package com.sundy.mapper;

import com.sundy.pojo.User;

import java.util.List;


/**
 * Created by liuguozhu on 2015/3/15.
 */
public interface UserMapperInterface {
    User selectUserById(int id);

    int insertUser(User user);

    List<User> findUserList(String userName) throws Exception;

}
