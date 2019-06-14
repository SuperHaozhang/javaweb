package com.cheer.servlet;

import com.cheer.demo.User;
import com.cheer.service.Service;
import com.cheer.service.ServiceImp;
import com.cheer.service.UserService;
import com.cheer.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogService", urlPatterns = "/servlet/LogService")
public class LogService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式:
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //获取请求信息
        String username=req.getParameter("uname");
        String password =req.getParameter("pwd");

        //处理请求信息
        //校验
        // 判断用户名和密码是否正确
        UserService userService = new UserServiceImpl();
        if(userService.checkLogin(username, password)){
            //获取session对象
            HttpSession hs=req.getSession();
            //将用户数据存储到session对象中
            hs.setAttribute("username",username);
            //System.out.println(username);
            //重定向
            resp.sendRedirect("/javaweb/EmpList.jsp");
            return;
        }else{
            //获取session对象
            HttpSession hs=req.getSession();
            hs.setAttribute("flag",0);
            resp.sendRedirect("/javaweb/login.html");
            //添加request中

            //req.setAttribute("flag",0);
            //请求转发
            //req.getRequestDispatcher("/manager/../../login.jsp").forward(req,resp);
            return;

        }
    }
}
