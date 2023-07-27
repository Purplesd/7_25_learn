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
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String,String[]> paramMap = req.getParameterMap();
        Category category= FormBeanUtil.formToBean(paramMap, Category.class);
        category.setId(UUIDUtil.uuid());
        if("".equals(category.getName())){
            req.getSession().setAttribute("CategoryError","输入不完整");
            resp.sendRedirect("listCategory");
            return;
        }
        if(categoryService.verifyName(category.getName())){
            req.getSession().setAttribute("CategoryError","分类已存在");
            resp.sendRedirect("listCategory");
            return;
        }else {
            categoryService.add(category);
            resp.sendRedirect("listCategory");
            return;
        }
    }
}
