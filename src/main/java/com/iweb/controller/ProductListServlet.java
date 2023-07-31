package com.iweb.controller;

import com.iweb.pojo.Product;
import com.iweb.service.ProductService;
import com.iweb.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listProduct")
public class ProductListServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        if(categoryName==null){
            categoryName= (String) req.getSession().getAttribute("categoryName");
        }
        List<Product> products = productService.list(categoryName);
        req.getSession().setAttribute("products",products);
        req.getSession().setAttribute("categoryName",categoryName);
        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
    }
}