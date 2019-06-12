package com.cheer.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet", urlPatterns = "/servlet/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置请求编码格式:
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            System.out.println(1111);
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if("zhangsan123".equals(cookie.getValue())){
                    System.out.println(1111);
                    response.sendRedirect("/javaweb/jquery-02.html");
                    return;
                }
            }
        }else {
            response.sendRedirect("/javaweb/login.html");
            return;
        }
    }
}
