package com.shitikov.shape.validator;

import com.shitikov.shape.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleValidator {
    private static QuadrangleValidator instance;
    private static Logger logger = LogManager.getLogger();

    private QuadrangleValidator() {
    }

    public static QuadrangleValidator getInstance() {
        if (instance == null) {
            instance = new QuadrangleValidator();
        }
        return instance;
    }

    public boolean isQuadrangleDataCorrect(List<Point> points) {
        boolean result = true;
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);
        Point point4 = points.get(3);

        if (point1.equals(point2) || point1.equals(point3) || point1.equals(point4)
                || point2.equals(point3) || point2.equals(point4) || point3.equals(point4)) {
            result = false;
            logger.log(Level.INFO, "Two or more points are equals.");
        }

        if (point1.getCoordinateX() == point2.getCoordinateX() && point1.getCoordinateX() == point3.getCoordinateX()
                || point1.getCoordinateX() == point2.getCoordinateX() && point1.getCoordinateX() == point4.getCoordinateX()
                || point1.getCoordinateX() == point3.getCoordinateX() && point1.getCoordinateX() == point4.getCoordinateX()
                || point2.getCoordinateX() == point3.getCoordinateX() && point2.getCoordinateX() == point4.getCoordinateX()) {
            result = false;
            logger.log(Level.INFO, "Three or more points are on the same line.");
        }

        if (point1.getCoordinateY() == point2.getCoordinateY() && point1.getCoordinateY() == point3.getCoordinateY()
                || point1.getCoordinateY() == point2.getCoordinateY() && point1.getCoordinateY() == point4.getCoordinateY()
                || point1.getCoordinateY() == point3.getCoordinateY() && point1.getCoordinateY() == point4.getCoordinateY()
                || point2.getCoordinateY() == point3.getCoordinateY() && point2.getCoordinateY() == point4.getCoordinateY()) {
            result = false;
            logger.log(Level.INFO, "Three or more points are on the same line.");
        }
        return result;
    }
}
