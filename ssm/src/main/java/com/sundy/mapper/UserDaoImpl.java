package com.sundy.mapper;

import com.sundy.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by liuguozhu on 2015/3/16.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    @Override
    public User findUserById(int id) {
        SqlSession session = this.getSqlSession();
        User user = session.selectOne("com.sundy.mapper.UserDao.findUserById", 1);
        return user;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession session = this.getSqlSession();
        session.insert("com.sundy.mapper.UserDao.insertUser", user);
    }
}
