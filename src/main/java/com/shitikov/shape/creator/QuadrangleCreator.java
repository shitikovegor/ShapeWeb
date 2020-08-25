package com.shitikov.shape.creator;

import com.shitikov.shape.entity.Point;
import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.exception.ProjectException;
import com.shitikov.shape.observer.impl.QuadrangleObserver;
import com.shitikov.shape.repository.QuadrangleRepository;
import com.shitikov.shape.validator.QuadrangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCreator {
    private static Logger logger = LogManager.getLogger();

    public Quadrangle createQuadrangle(List<Double> pointsData) throws ProjectException {
        if (pointsData == null || pointsData.isEmpty()
                || pointsData.size() % 8 != 0) {
            throw new ProjectException("Parameter is incorrect.");
        }
        PointCreator creator = new PointCreator();
        List<Point> points = new ArrayList<>();
        Point point;

        for (int i = 0; i < pointsData.size() - 1; i += 2) {
            point = creator.createPoint(pointsData.get(i), pointsData.get(i + 1));
            points.add(point);
        }
        if (!QuadrangleValidator.getInstance().isQuadrangleDataCorrect(points)) {
            throw new ProjectException("Parameter is incorrect.");
        }

        Quadrangle quadrangle = new Quadrangle(points);
        QuadrangleRepository.getInstance().add(quadrangle);

        quadrangle.attach(new QuadrangleObserver());
        quadrangle.notifyObservers();
        logger.log(Level.INFO, "Quadrangle {} created.", quadrangle);

        return quadrangle;
    }
}
