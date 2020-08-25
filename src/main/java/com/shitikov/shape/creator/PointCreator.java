package com.shitikov.shape.creator;

import com.shitikov.shape.entity.Point;
import com.shitikov.shape.exception.ProjectException;
import com.shitikov.shape.validator.PointValidator;

public class PointCreator {

    public Point createPoint(double coordinateX, double coordinateY) throws ProjectException {

        if (PointValidator.getInstance().isPointDataCorrect(coordinateX, coordinateY)) {
            return new Point(coordinateX, coordinateY);
        } else {
            throw new ProjectException("Parameter is incorrect.");
        }
    }
}
