package com.sundy.mybatis;

import com.sundy.mapper.OrdersMapper;
import com.sundy.mapper.UserMapper;
import com.sundy.pojo.Orders;
import com.sundy.pojo.OrdersCustom;
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
 * 一对多查询
 * Created by liuguozhu on 2015/3/15.
 */
public class OrdersTest {

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
     * 通过继承方式查询一对一查询
     */
    @Test
    public void findOrdersUserList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
            List<OrdersCustom> list = ordersMapper.findOrdersUserList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 通过resultmap查询结果一对一查询
     */
    @Test
    public void findOrdersUserListResultMap() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
            List<Orders> list = ordersMapper.findOrdersUserListResultMap();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findOrdersDetailList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
            List<Orders> list = ordersMapper.findOrdersDetailList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findOrdersItemsList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
            List<Orders> list = ordersMapper.findOrdersItemsList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
