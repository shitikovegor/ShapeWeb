package com.shitikov.shape.observer.impl;

import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.entity.QuadrangleType;
import com.shitikov.shape.observer.Observer;
import com.shitikov.shape.observer.QuadrangleEvent;
import com.shitikov.shape.action.impl.QuadrangleAction;
import com.shitikov.shape.warehouse.QuadrangleProperty;
import com.shitikov.shape.warehouse.QuadrangleWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserver implements Observer<QuadrangleEvent> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void actionPerformed(QuadrangleEvent quadrangleEvent) {
        Quadrangle quadrangle = quadrangleEvent.getSource();
        QuadrangleAction service = new QuadrangleAction();

        double perimeter = service.calculatePerimeter(quadrangle);
        double square = service.calculateSquare(quadrangle);
        boolean isConvex = service.isConvex(quadrangle);
        QuadrangleType type = service.defineQuadrangleType(quadrangle);

        QuadrangleProperty property = new QuadrangleProperty(perimeter, square, isConvex, type);
        QuadrangleWarehouse.getInstance().put(quadrangle.getShapeId(), property);

        logger.log(Level.INFO, "Properties of quadrangle put to warehouse: {}.", property);
    }
}
