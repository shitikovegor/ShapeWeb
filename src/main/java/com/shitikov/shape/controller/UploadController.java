package com.shitikov.shape.controller;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.PagePath;
import com.shitikov.shape.controller.command.impl.UploadFileCommand;
import com.shitikov.shape.controller.command.provider.CommandProvider;
import com.shitikov.shape.controller.command.type.CommandType;
import com.shitikov.shape.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/upload/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends HttpServlet {
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Command command = CommandType.UPLOAD_FILE.getCommand();
        String page = command.execute(request);


        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            request.getSession().setAttribute("nullPage", "Page is null");
            response.sendRedirect(request.getContextPath() + PagePath.INDEX);
        }
    }
}

