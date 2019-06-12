package com.cheer.servlet;

import com.cheer.service.Service;
import com.cheer.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmpServlet", urlPatterns = "/servlet/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String empno = request.getParameter("empno");
        System.out.println(empno);
        Service service=new ServiceImp();
        Integer i=service.delete(Integer.parseInt(empno));
        System.out.println(i);
        response.sendRedirect("/javaweb/jquery-02.html");

    }
}
