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

@WebServlet(name = "InseretServlet", urlPatterns = "/servlet/InseretServlet")
public class InseretServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] s = request.getParameterValues("user");
        for (int i = 0; i <s.length ; i++) {
            if(s[i]==""){
                s[i]=null;
            }
        }
        Emp emp=new Emp(Integer.parseInt(s[0]),s[1],Integer.parseInt(s[2]),s[3],s[4],Double.parseDouble(s[5]),Double.parseDouble(s[6]),Integer.parseInt(s[7]));
        Service service=new ServiceImp();
        Integer i=service.insert(emp);
        System.out.println(i);
        response.sendRedirect("/javaweb/EmpList.jsp");


    }
}
