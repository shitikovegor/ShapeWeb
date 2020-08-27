package com.shitikov.shape.controller.command.impl;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.PagePath;
import com.shitikov.shape.creator.QuadrangleCreator;
import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.exception.ProjectException;
import com.shitikov.shape.parser.DataParser;
import com.shitikov.shape.reader.DataReader;
import com.shitikov.shape.warehouse.QuadrangleProperty;
import com.shitikov.shape.warehouse.QuadrangleWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

public class ReadFileCommand implements Command {
    private static final String INVALID_TYPE_MESSAGE = "Invalid type of file.";
    Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.FILES;
        String filePath = request.getParameter("file");

        if (!filePath.substring(filePath.lastIndexOf(".")).equalsIgnoreCase(".txt")) {
            logger.log(Level.ERROR, "Type of file is incorrect");
            request.setAttribute("invalid_type", INVALID_TYPE_MESSAGE);
            request.setAttribute("fileList", request.getParameter("fileList"));
            return page;
        }

        try {
            List<String> pointsDataString = DataReader.getInstance().readFile(filePath);
            List<Double> pointsData = DataParser.getInstance().parseQuadrangleData(pointsDataString);
            List<Quadrangle> quadrangles = QuadrangleCreator.getInstance().createQuadrangleList(pointsData);
            Map<Quadrangle, QuadrangleProperty> quadrangleWithProperties
                    = fillInQuadrangleProperties(quadrangles);

            request.setAttribute("quadrangles", quadrangleWithProperties);
            request.setAttribute("file", new File(filePath));

            page = PagePath.SHAPES;
        } catch (ProjectException e) {
            logger.log(Level.ERROR, "Exception: ", e);
        }

        return page;
    }

    private Map<Quadrangle, QuadrangleProperty> fillInQuadrangleProperties(List<Quadrangle> quadrangles) {
        Map<Quadrangle, QuadrangleProperty> quadrangleProperties = new HashMap<>();

        quadrangles.forEach(quadrangle -> {
            QuadrangleProperty property = QuadrangleWarehouse.getInstance()
                    .getProperty(quadrangle.getShapeId())
                    .get();
            quadrangleProperties.put(quadrangle, property);
        });
        return quadrangleProperties;
    }
}
