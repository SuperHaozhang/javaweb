package com.cheer.servlet;

import com.cheer.demo.Emp;
import com.cheer.service.Service;
import com.cheer.service.ServiceImp;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpDemo02", urlPatterns = "/servlet/EmpDemo02")
public class EmpDemo02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Service service=new ServiceImp();
        Integer empno = Integer.parseInt(request.getParameter("empno"));
        Emp emp=service.getEmp(empno);
        request.setAttribute("emp",emp);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
