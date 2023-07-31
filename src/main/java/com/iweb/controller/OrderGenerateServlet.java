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

@WebServlet("/generateOrder")
public class OrderGenerateServlet extends HttpServlet {
    private OrderService orderService=new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address=req.getParameter("address");
        List<Product> products = (List<Product>) req.getSession().getAttribute("ops");
        if(orderService.generateOrder(address,products)){
            req.getSession().removeAttribute("ShoppError");
            resp.sendRedirect("listProduct");
        }else{
            req.getSession().setAttribute("ShoppError","购买");
            resp.sendRedirect("shopp");
        }
    }
}
