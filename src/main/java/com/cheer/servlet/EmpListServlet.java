package com.cheer.servlet;

import com.cheer.demo.Emp;
import com.cheer.service.Service;
import com.cheer.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpListServlet", urlPatterns = "/servlet/EmpListServlet")
    public class EmpListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Service service=new ServiceImp();
        List<Emp> list=service.getEmpList();
        request.setAttribute("emplist",list);
        request.getRequestDispatcher("/EmpList2.jsp").forward(request,response);
    }
}
