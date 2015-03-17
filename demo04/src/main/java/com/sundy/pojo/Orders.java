package com.sundy.pojo;

import java.util.List;

public class Orders {

    private Integer id;//订单id

    private Integer userId;//用户id

    private String order_number;//订单号

    private User user;//用户信息

    private List<Orderdetail> orderdetails;//订单明细信息

    private String orderNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }
}