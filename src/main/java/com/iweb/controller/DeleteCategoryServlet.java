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
        String id =req.getParameter("id");
        if(categoryService.delete(id)){
            req.getSession().removeAttribute("CategoryError");
            resp.sendRedirect("listCategory");
        }else {
            req.getSession().setAttribute("CategoryError","删除失败");
            resp.sendRedirect("listCategory");
        }
    }
}
