package com.sundy.mapper;

import com.sundy.pojo.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public interface UserMapper {

    User selectUserById(int id);

    User selecttypeAlias(int id);

    User selectUserByHashmap(HashMap hashMap);

    List<User> findUserList(String username);

    List<User> findUserList2(String username);

    int selectUserCount();

    HashMap<String, String> selectmapById(int id);

    User selectUserByUser(User user);

    User selectUserByUser2(User user);

    List<User> selectUserByList(List<User> list);


}
