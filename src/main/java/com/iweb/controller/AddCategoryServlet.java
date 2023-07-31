package com.iweb.controller;

import com.iweb.pojo.Category;
import com.iweb.pojo.User;
import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;
import com.iweb.util.FormBeanUtil;
import com.iweb.util.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> paramMap = req.getParameterMap();
        Category category= FormBeanUtil.formToBean(paramMap, Category.class);
        if("".equals(category.getName())){
            req.getSession().setAttribute("CategoryError","输入不完整");
            resp.sendRedirect("listCategory");
            return;
        }
        if(categoryService.add(category)){
            req.getSession().removeAttribute("CategoryError");
            resp.sendRedirect("listCategory");
        }else {
            req.getSession().setAttribute("CategoryError","添加失败，请重新添加!");
            resp.sendRedirect("listCategory");
        }
    }
}