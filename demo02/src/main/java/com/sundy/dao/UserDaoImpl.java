package com.sundy.dao;

import com.sundy.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private SqlSessionFactory sqlSessionFactory;


    @Override
    public User selectUserById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = null;
        try {
            //通过sqlsession调用selectOne方法获取一条结果集
            //参数1：指定定义的statement的id,参数2：指定向statement中传递的参数
            user = session.selectOne("com.sundy.mapper.UserMapper.selectUserById", 1);
        } finally {
            session.close();
        }
        return user;
    }
}
