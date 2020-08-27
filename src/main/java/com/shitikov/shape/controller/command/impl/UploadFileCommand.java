package com.shitikov.shape.controller.command.impl;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.PagePath;
import com.shitikov.shape.controller.command.type.CommandType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class UploadFileCommand implements Command {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String uploadFileDirectory = request.getServletContext().getInitParameter("upload_path")
                + File.separator;

        File fileSaveDir = new File(uploadFileDirectory);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        request.getParts().stream().forEach(part -> {
            try {
                part.write(uploadFileDirectory + part.getSubmittedFileName());
                request.setAttribute("upload_result", "File upload successfully");
            } catch (IOException e) {
                logger.log(Level.ERROR, "Uploading process error: ", e);
                request.setAttribute("upload_result", "File upload failed");
            }
        });
        return CommandType.SHOW_FILES.getCommand().execute(request);
    }
}
