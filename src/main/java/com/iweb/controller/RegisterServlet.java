package com.iweb.controller;

import com.iweb.pojo.User;
import com.iweb.service.UserService;
import com.iweb.service.impl.UserServiceImpl;
import com.iweb.util.FormBeanUtil;
import com.iweb.util.MD5Util;
import com.iweb.util.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String,String[]> paramMap = req.getParameterMap();
        User user= FormBeanUtil.formToBean(paramMap,User.class);
        user.setId(UUIDUtil.uuid());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        if("".equals(user.getUsername())||"".equals(user.getPassword())){
            req.getSession().setAttribute("RegisterError","输入不完整");
            resp.sendRedirect("register.jsp");
            return;
        }
        if(userService.verifyUserName(user.getUsername())){
            req.getSession().setAttribute("RegisterError","用户名已存在");
            resp.sendRedirect("register.jsp");
            return;
        }else{
            userService.addUser(user);
            resp.sendRedirect("login.jsp");
            return;
        }
    }
}
