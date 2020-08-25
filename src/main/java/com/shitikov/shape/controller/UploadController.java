package com.shitikov.shape.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = {"/upload/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\shitikov_egor\\IdeaProjects\\JWD\\Servlet\\uploads";// TODO: 25.08.2020 delete upload_dir from method to xml
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadFileDirectory = UPLOAD_DIRECTORY + File.separator;

        File fileSaveDir = new File(uploadFileDirectory);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        request.getParts().stream().forEach(part -> {
            try {
//                String randFilename = UUID.randomUUID() + path.substring(path.lastIndexOf("."));//поробовапть без нее,
                part.write(uploadFileDirectory + part.getSubmittedFileName());
                request.setAttribute("upload_result", " upload successfully ");
            } catch (IOException e) {
                logger.log(Level.ERROR, "Uploading process error: ", e);
                request.setAttribute("upload_result", " upload failed ");
            }
        });
        request.getRequestDispatcher("/jsp/upload_res.jsp").forward(request, response);
    }
}

