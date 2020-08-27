package com.shitikov.shape.controller.command.impl;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ShowFilesCommand implements Command {

    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        File directory = new File(request.getServletContext().getInitParameter("upload_path"));
        List<File> files = Arrays.asList(directory.listFiles());
        request.setAttribute("fileList", files);

        return PagePath.FILES;
    }
}
