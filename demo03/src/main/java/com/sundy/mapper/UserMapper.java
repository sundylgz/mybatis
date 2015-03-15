package com.sundy.mapper;

import com.sundy.pojo.User;

import java.util.List;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public interface UserMapper {

    User selectUserById(int id);

    User selecttypeAlias(int id);


    List<User> findUserList(String username);

    List<User> findUserList2(String username);
}
