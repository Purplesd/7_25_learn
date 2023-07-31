package com.iweb.controller;

import com.iweb.service.ProductService;
import com.iweb.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class ProductDeleteServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id =req.getParameter("id");
        if(productService.deleteProduct(id)){
            req.getSession().removeAttribute("ProductError");
            resp.sendRedirect("listProduct");
        }else {
            req.getSession().setAttribute("ProductError","删除失败");
            resp.sendRedirect("listProduct");
        }

    }
}
