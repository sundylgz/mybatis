package com.sundy.mapper;

import com.sundy.pojo.Orders;
import com.sundy.pojo.OrdersCustom;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface OrdersMapper {
    //查询订单及关联用户信息
    List<OrdersCustom> findOrdersUserList() throws Exception;

    //查询订单及关联用户信息 通过resultmap映射
    List<Orders> findOrdersUserListResultMap() throws Exception;

    //查询订单及订单明细
    public List<Orders> findOrdersDetailList() throws Exception;

    //查询商品订单及商品明细
    public List<Orders> findOrdersItemsList() throws Exception;

    ;
}