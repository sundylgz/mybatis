package com.sundy.mapper;

import com.sundy.pojo.User;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public interface UserMapperInterface {
    User selectUserById(int id);

    int insertUser(User user);
}
