package com.iweb.controller;

import com.iweb.pojo.Category;
import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {
    private CategoryService categoryService= new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= (String) req.getSession().getAttribute("id");
        System.out.println(id);
        String name = req.getParameter("name");
        Category category=new Category(id,name);
        for (Category c: categoryService.list()) {
            if(!c.getId().equals(category.getId())
                    &&c.getName().equals(category.getName())){
                req.getSession().setAttribute("EditCategoryError","分类已存在");
                resp.sendRedirect("editCategory.jsp");
                return;
            }
        }
        categoryService.update(category);
        resp.sendRedirect("listCategory");

    }
}
