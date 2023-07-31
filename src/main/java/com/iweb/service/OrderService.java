package com.iweb.service;

import com.iweb.pojo.Order;
import com.iweb.pojo.Product;

import java.util.List;

public interface OrderService {
    boolean generateOrder(String address, List<Product> products);
    List<Order> list();
    List<Product> detail(String pid);
}
