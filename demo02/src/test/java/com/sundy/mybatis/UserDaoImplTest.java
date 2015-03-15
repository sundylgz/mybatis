package com.sundy.mybatis;

import com.sundy.dao.UserDao;
import com.sundy.dao.UserDaoImpl;
import com.sundy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        //mybatis配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void selectUserById() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.selectUserById(1);
        System.out.println(user);
    }

}
