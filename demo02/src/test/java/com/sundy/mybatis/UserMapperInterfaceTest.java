package com.sundy.mybatis;

import com.sundy.mapper.UserMapperInterface;
import com.sundy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by liuguozhu on 2015/3/15.
 */
public class UserMapperInterfaceTest {

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
    public void insertUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("1张三11111111112");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            UserMapperInterface userMapperInterface = session.getMapper(UserMapperInterface.class);
            int result = userMapperInterface.insertUser(user);
            System.out.println("result=" + result);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void selectUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapperInterface userMapperInterface = session.getMapper(UserMapperInterface.class);
            User user = userMapperInterface.selectUserById(12);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    public void findUserList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapperInterface userMapperInterface = session.getMapper(UserMapperInterface.class);
            List<User> users = userMapperInterface.findUserList("张三");
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


}
