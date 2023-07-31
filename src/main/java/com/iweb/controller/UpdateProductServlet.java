package com.iweb.controller;

import com.iweb.pojo.Product;
import com.iweb.service.ProductService;
import com.iweb.service.impl.ProductServiceImpl;
import com.iweb.util.FormBeanUtil;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String,String[]> paramMap = req.getParameterMap();
        Product product= FormBeanUtil.formToBean(paramMap, Product.class);
        if(productService.update(product)){
            req.getSession().removeAttribute("ProductError");
            resp.sendRedirect("listProduct");
        }else {
            req.getSession().setAttribute("ProductError","编辑失败!");
            resp.sendRedirect("listProduct");
        }
    }
}
