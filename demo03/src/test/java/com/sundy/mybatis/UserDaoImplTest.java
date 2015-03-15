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
import java.util.ArrayList;
import java.util.HashMap;
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


    /**
     * 别名
     */
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

    /**
     * 传hashmap
     */
    @Test
    public void selectUserByHashmap() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1);
            map.put("username", "张三");
            User user = userMapper.selectUserByHashmap(map);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 查询count数量
     */
    @Test
    public void selectUserCount() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int count = userMapper.selectUserCount();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 查询count数量
     */
    @Test
    public void selectmapById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            HashMap<String, String> map = userMapper.selectmapById(1);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * if 语句
     */
    @Test
    public void selectUserByUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User();
            //user.setId(1);
            user.setUsername("张三2");
            user = userMapper.selectUserByUser(user);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * if 语句 where 语句中嵌入if语句  动态sql
     */
    @Test
    public void selectUserByUser2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User();
            //user.setId(1);
            user.setUsername("张三2");
            user = userMapper.selectUserByUser2(user);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * for each
     */
    @Test
    public void selectUserByList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = new ArrayList<User>();
            User user1 = new User();
            user1.setId(1);
            User user2 = new User();
            user2.setId(2);
            list.add(user1);
            list.add(user2);
            List<User> users = userMapper.selectUserByList(list);
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 测试配置properties配置文件 sql 片段   resultMap 解决mysql和属性字段名称不一致
     */
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

}
