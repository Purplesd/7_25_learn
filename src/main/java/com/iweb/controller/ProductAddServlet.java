package com.iweb.controller;

import com.iweb.pojo.Product;
import com.iweb.pojo.User;
import com.iweb.service.ProductService;
import com.iweb.service.impl.ProductServiceImpl;
import com.iweb.util.FormBeanUtil;
import com.iweb.util.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addProduct")
public class ProductAddServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> paramMap = req.getParameterMap();
        Product product= FormBeanUtil.formToBean(paramMap,Product.class);
        if("".equals(product.getName())||"".equals(product.getCategory())
                ||product.getPrice()==null||product.getStock()==null){
            req.getSession().setAttribute("ProductError","输入不完整");
            resp.sendRedirect("listProduct");
            return;
        }
        if(productService.addProduct(product)){
            req.getSession().removeAttribute("ProductError");
            resp.sendRedirect("listProduct");
        }else {
            req.getSession().setAttribute("ProductError","添加失败，请重新添加!");
            resp.sendRedirect("listProduct");
        }
    }


}
