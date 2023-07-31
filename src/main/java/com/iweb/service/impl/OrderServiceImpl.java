package com.iweb.service.impl;

import com.iweb.DAO.OrderDao;
import com.iweb.DAO.impl.OrderDaoImpl;
import com.iweb.pojo.Order;
import com.iweb.pojo.Product;
import com.iweb.service.OrderService;
import com.iweb.util.UUIDUtil;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public boolean generateOrder(String address, List<Product> products) {
        Order order = new Order(UUIDUtil.uuid(),UUIDUtil.uuid(),address);
        return orderDao.generateOrder(order,products);
    }

    @Override
    public List<Order> list() {
        return orderDao.list();
    }

    @Override
    public List<Product> detail(String pid) {
        return orderDao.detail(pid);
    }
}
