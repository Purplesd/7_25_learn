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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/purchaseProduct")
public class PurchaseProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        Product product = productService.getProduct(id);
        List<Product> products = (List<Product>) req.getSession().getAttribute("ops");
        if(products==null||products.size()==0){
            products = new ArrayList<>();
        }
        products.add(product);
        System.out.println(products);
        req.getSession().setAttribute("ops",products);
        resp.sendRedirect("listProduct");
    }
}
