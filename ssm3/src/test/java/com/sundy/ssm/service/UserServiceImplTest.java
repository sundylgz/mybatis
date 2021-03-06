package com.sundy.ssm.service;

import com.sundy.mapper.UserMapper;
import com.sundy.pojo.User;
import com.sundy.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by liuguozhu on 2015/3/16.
 */
public class UserServiceImplTest {

    ApplicationContext applicationContext;

    @Before()
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml", "spring/applicationContext-dao.xml", "spring/applicationContext-service.xml"});
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() {
        UserService userService = (UserService) applicationContext.getBean("userService");
        try {
            User user = userService.findUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void insertUser() {
        UserService userService = (UserService) applicationContext.getBean("userService");
        try {
            User user = new User();
            user.setUsername("李大麻子2");
            user.setBirthday(new Date());
            user.setSex((short) 1);
            user.setAddress("北京市");
            user.setDetail("好同志");
            user.setScore(100);
            userService.insertUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 测试事务
     */
    @Test
    public void saveUser() {
        UserService userService = (UserService) applicationContext.getBean("userService");
        try {
            userService.saveUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
