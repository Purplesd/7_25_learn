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

@WebServlet("/editCategory")
public class EditCategoryServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String id =req.getParameter("id");
        req.getSession().setAttribute("id",id);
        req.getRequestDispatcher("editCategory.jsp").forward(req,resp);
    }
}
