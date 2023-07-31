package com.iweb.DAO;

import com.iweb.pojo.Category;
import com.iweb.pojo.Order;
import com.iweb.pojo.Product;

import java.util.List;

public interface OrderDao {
    boolean generateOrder(Order order,List<Product> products);
    List<Order> list();
    List<Product> detail(String pid);
}
