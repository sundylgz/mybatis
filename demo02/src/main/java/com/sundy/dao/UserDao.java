package com.sundy.dao;

import com.sundy.pojo.User;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public interface UserDao {
    User selectUserById(int id);
}
