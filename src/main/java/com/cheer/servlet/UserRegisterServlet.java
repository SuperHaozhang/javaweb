package com.cheer.servlet;

import com.cheer.demo.User2;
import com.cheer.service.UserService;
import com.cheer.service.UserServiceImpl;
import com.cheer.util.IOUtils;
import com.cheer.util.StringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import java.util.List;

@WebServlet(name = "UserRegisterServlet", urlPatterns = "/servlet/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(UserRegisterServlet.class);
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        File repository = (File) request.getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        User2 user = new User2();
        for (FileItem item : items) {
            // 判断是否是普通表单字段还是文件上传字段
            if (item.isFormField()) {
                switch (item.getFieldName()) {
                    case "username":
                        user.setUsername(item.getString());

                        break;
                    case "password":
                        user.setPassword(item.getString());

                        // 加密
                        user.setPassword(StringUtils.encrypt(user.getPassword()));
                        break;
                }
            } else {
                String name = item.getName();
                String tmpDir = System.getProperty("user.home");

                LOGGER.debug("tmpDir={}", tmpDir);
                File avatarDir = new File(tmpDir + "/avatar");
                if (!avatarDir.exists()) {
                    // 创建路径
                    if(!avatarDir.mkdirs()) {
                        LOGGER.error("创建路径失败！");
                        throw new ServletException("注册失败");
                    }
                }
                String fileName = user.getUsername() + "-" + name;

                IOUtils.writeToFile(item.getInputStream(), avatarDir + "/" + fileName);
                user.setAvatar(fileName);
            }
        }
        UserService userService = new UserServiceImpl();
        try {
            userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("注册失败");
        }

        response.sendRedirect("/javaweb/login.html");
    }
}
