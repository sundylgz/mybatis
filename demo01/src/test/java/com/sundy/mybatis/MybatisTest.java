package com.sundy.mybatis;

import com.sundy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by liuguozhu on 2015/3/14.
 */
public class MybatisTest {

    @Test
    public void select() throws Exception {
        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //通过sqlsession调用selectOne方法获取一条结果集
            //参数1：指定定义的statement的id,参数2：指定向statement中传递的参数
            User user = session.selectOne("com.sundy.mapper.UserMapper.selectUserById", 1);
            System.out.println(user);
        } finally {
            session.close();
        }
    }


    @Test
    public void insert() throws Exception {
        //mybatis配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("张三");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            int result = session.insert("com.sundy.mapper.UserMapper.insertUser", user);
            session.commit();
            System.out.println("result=" + result);
        } finally {
            session.close();
        }

    }

    @Test
    public void insertWithId() throws Exception {
        //mybatis配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("张三2");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            int id = session.insert("com.sundy.mapper.UserMapper.insertUserWithId", user);
            session.commit();
            System.out.println("id=" + user.getId());
        } finally {
            session.close();
        }

    }

    @Test
    public void insertWithId2() throws Exception {
        //mybatis配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("张三2");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            int id = session.insert("com.sundy.mapper.UserMapper.insertUserWithId2", user);
            session.commit();
            System.out.println("id=" + user.getId());
        } finally {
            session.close();
        }

    }


    @Test
    public void delUser() throws Exception {
        //mybatis配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("com.sundy.mapper.UserMapper.deleteUser", 9);
            session.commit();

        } finally {
            session.close();
        }

    }


    @Test
    public void updateUser() throws Exception {
        //mybatis配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder创建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //通过session工厂获取一个Sqlsession，sqlsession中包括了对数据库操作的sql方法
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setId(1);
            user.setUsername("张三2");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            session.update("com.sundy.mapper.UserMapper.updateUser", user);
            session.commit();
        } finally {
            session.close();
        }

    }
}
