package com.sundy.mybatis;

import com.sundy.mapper.UserMapper;
import com.sundy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

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
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(12);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    public void selecttypeAlias() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selecttypeAlias(12);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /**
     * ${value} 占位符
     */
    @Test
    public void findUserList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = userMapper.findUserList("张三");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * #{username} 占位符
     */
    @Test
    public void findUserList2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = userMapper.findUserList2("%张三%");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
