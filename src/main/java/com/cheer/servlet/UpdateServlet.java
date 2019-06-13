package com.cheer.servlet;

import com.cheer.demo.Emp;
import com.cheer.service.Service;
import com.cheer.service.ServiceImp;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UpdateServlet", urlPatterns = "/servlet/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ServiceImp.class);
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //String s= request.getParameter("empno");
        // 当数据比较多的时候可以考虑使用
        Map<String, String []> map = request.getParameterMap();
        //System.out.println(s);
        Emp emp = new Emp();
        try {
            // 将一个map里的值拷贝到一个对象里去
            BeanUtils.populate(emp,map);
            Service service=new ServiceImp();
            int i = service.update(emp);
            response.sendRedirect("/javaweb/EmpList.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        LOGGER.debug(emp);

    }
}
