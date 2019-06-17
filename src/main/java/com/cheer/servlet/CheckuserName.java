package com.cheer.servlet;

import com.cheer.demo.User2;
import com.cheer.service.UserService;
import com.cheer.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckuserName", urlPatterns = "/servlet/CheckuserName")
public class CheckuserName extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService=new UserServiceImpl();
        List<User2> list = userService.getUserList();
        System.out.println(list);
        HttpSession session = request.getSession();
        session.setAttribute("usernamelist",list);
        response.sendRedirect("/javaweb/register.jsp");

    }
}
