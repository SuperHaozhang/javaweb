package com.cheer.servlet;

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
        String uname=req.getParameter("uname");
        //uname=new String(uname.getBytes("iso8859-1"),"utf-8");//使用String进行数据重新编码
        String pwd=req.getParameter("pwd");
        Cookie c = new Cookie("name",uname+pwd);
        c.setMaxAge(60);
        c.setPath("servlet/CookieServlet");
        if("1".equals(req.getParameter("fav"))){
            resp.addCookie(c);
        }
        System.out.println(uname+":"+pwd);

        //响应处理结果
        if("zhangsan".equals(uname)&&"123".equals(pwd)){
            //resp.getWriter().write("登录成功");
            HttpSession session=req.getSession();
            session.setAttribute("name",uname);
            resp.sendRedirect("/javaweb/jquery-02.html");
            return;
        }else{
            resp.sendRedirect("/javaweb/login.html");
            return;
        }
    }
}
