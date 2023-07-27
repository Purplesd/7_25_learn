package com.iweb.controller;

import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i=req.getQueryString().indexOf('=')+1;
        String id = req.getQueryString().substring(i);
        categoryService.delete(id);
        resp.sendRedirect("listCategory");
    }
}
