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

@WebServlet(name = "EmpDemo", urlPatterns = "/servlet/EmpDemo")
public class EmpDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        Service service=new ServiceImp();
        Integer empno = Integer.parseInt(request.getParameter("empno"));
        Emp emp=service.getEmp(empno);
        List<Emp> list = new ArrayList<Emp>();
        list.add(emp);
        Gson gson=new Gson();
        String data=gson.toJson(list);
        System.out.println(data);
        writer.println(data);
        writer.close();
    }
}
