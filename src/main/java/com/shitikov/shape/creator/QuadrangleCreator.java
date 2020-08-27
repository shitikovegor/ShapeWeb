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
import java.util.Optional;

public class QuadrangleCreator {
    private static Logger logger = LogManager.getLogger();
    private static QuadrangleCreator instance;

    private QuadrangleCreator() {
    }

    public static QuadrangleCreator getInstance() {
        if (instance == null) {
            instance = new QuadrangleCreator();
        }
        return instance;
    }

    public Optional<Quadrangle> createQuadrangle(List<Double> pointsData) throws ProjectException {
        if (pointsData == null || pointsData.size() != 8) {
            throw new ProjectException("Parameter is incorrect.");
        }

        PointCreator creator = new PointCreator();
        List<Point> points = new ArrayList<>();
        Point point;
        Optional<Quadrangle> quadrangleOptional;

        for (int i = 0; i < pointsData.size() - 1; i += 2) {
            point = creator.createPoint(pointsData.get(i), pointsData.get(i + 1));
            points.add(point);
        }
        if (QuadrangleValidator.getInstance().isQuadrangleDataCorrect(points)) {
            Quadrangle quadrangle = new Quadrangle(points);
            QuadrangleRepository.getInstance().add(quadrangle);

            quadrangle.attach(new QuadrangleObserver());
            quadrangle.notifyObservers();
            quadrangleOptional = Optional.of(quadrangle);
            logger.log(Level.INFO, "Quadrangle {} created.", quadrangle);
        } else {
            logger.log(Level.ERROR, "Parameter is incorrect.");
            quadrangleOptional = Optional.empty();
        }

        return quadrangleOptional;
    }

    public List<Quadrangle> createQuadrangleList(List<Double> pointsData) throws ProjectException {
        if (pointsData == null || pointsData.isEmpty()
                || pointsData.size() % 8 != 0) {
            throw new ProjectException("Parameter is incorrect.");
        }
        List<Quadrangle> quadrangles = new ArrayList<>();
        List<Double> points;
        for (int i = 0; i < pointsData.size(); i += 8) {
            points = pointsData.subList(i, i + 8);
            Optional<Quadrangle> quadrangle = createQuadrangle(points);

            if (!quadrangle.isEmpty()) {
                quadrangles.add(quadrangle.get());
            }
        }
        return quadrangles;
    }
}
