package com.cheer.servlet;

import com.cheer.demo.User2;
import com.cheer.dto.ResponseMessage;
import com.cheer.service.UserService;
import com.cheer.service.UserServiceImpl;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UsernameCheckServlet", urlPatterns = "/servlet/UsernameCheckServlet")
public class UsernameCheckServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(UsernameCheckServlet.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        LOGGER.debug("username={}", username);
        if (null == username || "".equals(username)) {
            return;
        }

        UserService userService = new UserServiceImpl();
        User2 temp  = userService.find(username);
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        ResponseMessage responseMessage;
        if (temp != null) {
            responseMessage = new ResponseMessage("-1", "用户名已存在!");
        } else {
            responseMessage = new ResponseMessage("0", "用户名不存在!");
        }
        Gson gson = new Gson();
        String json = gson.toJson(responseMessage);
        printWriter.println(json);
        printWriter.close();
    }
}
