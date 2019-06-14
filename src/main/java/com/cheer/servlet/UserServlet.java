package com.cheer.servlet;

import com.cheer.demo.User;
import com.cheer.demo.User2;
import com.cheer.service.UserService;
import com.cheer.service.UserServiceImpl;
import com.cheer.util.IOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = "/servlet/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String username = (String) request.getSession().getAttribute("username");
        UserService userService = new UserServiceImpl();
        User2 user = userService.find(username);
        if (user.getAvatar() == null) {
            user.setAvatar("default.jpeg");
        } else {
            String uploadPath = this.getServletContext().getRealPath("/upload/avatar");
            String dest = uploadPath + "/" + user.getAvatar();
            File avatar = new File(dest);
            if (!avatar.exists()) {
                String src = System.getProperty("user.home") + "/avatar/" + user.getAvatar();
                IOUtils.copy(src, dest);
            }
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(user);
        writer.println(json);
        writer.close();
    }
}
