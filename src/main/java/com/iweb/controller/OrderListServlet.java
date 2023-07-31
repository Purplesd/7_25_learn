package com.iweb.controller;

import com.iweb.pojo.Order;
import com.iweb.pojo.Product;
import com.iweb.service.OrderService;
import com.iweb.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listOrder")
public class OrderListServlet extends HttpServlet {
    private OrderService orderService=new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.list();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("listOrder.jsp").forward(req,resp);
    }
}
