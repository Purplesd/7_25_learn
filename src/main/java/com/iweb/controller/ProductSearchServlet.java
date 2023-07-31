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

@WebServlet("/searchProduct")
public class ProductSearchServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("pname");
        List<Product> products = (List<Product>) req.getSession().getAttribute("products");
        if(name==null||name.equals("")){
            resp.sendRedirect("listProduct");
            return;
        }else {
            List<Product> products2 = productService.search(products, name);
            req.getSession().setAttribute("products", products2);
            req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
        }
    }
}
