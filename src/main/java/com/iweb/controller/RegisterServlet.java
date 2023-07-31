package com.iweb.controller;

import com.iweb.pojo.User;
import com.iweb.service.UserService;
import com.iweb.service.impl.UserServiceImpl;
import com.iweb.util.FormBeanUtil;
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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        Map<String,String[]> paramMap = req.getParameterMap();
        User user= FormBeanUtil.formToBean(paramMap,User.class);
        if("".equals(user.getUsername())||"".equals(user.getPassword())){
            req.getSession().setAttribute("RegisterError","输入不完整");
            resp.sendRedirect("register.jsp");
            return;
        }
        if(userService.register(user)){
            req.getSession().removeAttribute("RegisterError");
            resp.sendRedirect("login.jsp");
        }else{
            req.getSession().setAttribute("RegisterError","用户名或ID已存在");
            resp.sendRedirect("register.jsp");
        }
    }
}
