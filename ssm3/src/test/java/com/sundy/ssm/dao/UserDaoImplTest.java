package com.sundy.ssm.dao;


import com.sundy.mapper.UserMapper;
import com.sundy.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by liuguozhu on 2015/3/16.
 */
public class UserDaoImplTest {
    ApplicationContext applicationContext;

    @Before()
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml", "spring/applicationContext-dao.xml"});
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        try {
            User user = userMapper.findUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void insertUser() {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        try {
            User user = new User();
            user.setUsername("李大麻子");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            userMapper.insertUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
