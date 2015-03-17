package com.sundy.service;

import com.sundy.mapper.UserMapper;
import com.sundy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by liuguozhu on 2015/3/16.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(int id) throws Exception {
        return userMapper.findUserById(id);
    }

    @Override
    public void insertUser(User user) throws Exception {
        userMapper.insertUser(user);
    }

    @Override
    public void saveUser() throws Exception {

        //先删除一个用户
        userMapper.deleteUserById(1);
        //再插入一个用户(插入同名用户，数据抛出异常),预期结果事务回滚，删除的用户无效

        User user = new User();
        user.setBirthday(new Date());
        user.setSex((short) 1);
        user.setAddress("北京市");
        user.setDetail("好同志");
        user.setScore(100);
        user.setUsername("李大麻子");
        userMapper.insertUser(user);
    }
}
