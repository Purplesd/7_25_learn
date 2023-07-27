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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> paramMap = request.getParameterMap();
        User user=FormBeanUtil.formToBean(paramMap,User.class);

        if("".equals(user.getUsername())|| "".equals(user.getPassword())){
            request.getSession().setAttribute("errors","你出错了，笨比");
            response.sendRedirect("login.jsp");
            return;
        }else {
            user = userService.login(user);
            if(user==null){
                request.getSession().setAttribute("errors","用户名或密码出错了，笨比");
                response.sendRedirect("login.jsp");
            }else {
                request.getRequestDispatcher("main.jsp").forward(request,response);
            }
            return;
        }
    }
}
