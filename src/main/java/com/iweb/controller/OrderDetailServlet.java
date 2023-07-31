package com.iweb.controller;

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

@WebServlet("/orderDetail")
public class OrderDetailServlet extends HttpServlet {
    private OrderService orderService=new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        List<Product> products = orderService.detail(pid);
        System.out.println(products);
        req.setAttribute("orderdetail",products);
        req.getRequestDispatcher("orderDetail.jsp").forward(req,resp);
    }
}
