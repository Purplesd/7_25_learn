package com.iweb.controller;

import com.iweb.pojo.Category;
import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;
import com.iweb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {
    private CategoryService categoryService= new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String,String[]> paramMap = req.getParameterMap();
        Category category= FormBeanUtil.formToBean(paramMap, Category.class);
        if(categoryService.update(category)){
            req.getSession().removeAttribute("EditCategoryError");
            resp.sendRedirect("listCategory");
        }else {
            req.getSession().setAttribute("EditCategoryError","编辑失败，请重新添加!");
            resp.sendRedirect("editCategory");
        }


    }
}
