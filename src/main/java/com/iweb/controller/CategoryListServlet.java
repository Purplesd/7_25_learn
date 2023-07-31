package com.iweb.controller;

import com.iweb.pojo.Category;
import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

/**
 * @author 79840
 */
@WebServlet("/listCategory")
public class CategoryListServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.list();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("listCategory.jsp").forward(req,resp);
    }
}
