package com.shitikov.shape.action.impl;

import com.shitikov.shape.entity.Point;
import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.entity.QuadrangleType;
import com.shitikov.shape.action.ShapeAction;

public class QuadrangleAction implements ShapeAction<Quadrangle> {

    @Override
    public double calculatePerimeter(Quadrangle quadrangle) {
        double side1 = calcPointsDistance(quadrangle.getTop(0), quadrangle.getTop(1));
        double side2 = calcPointsDistance(quadrangle.getTop(1), quadrangle.getTop(2));
        double side3 = calcPointsDistance(quadrangle.getTop(2), quadrangle.getTop(3));
        double side4 = calcPointsDistance(quadrangle.getTop(3), quadrangle.getTop(0));

        return side1 + side2 + side3 + side4;
    }

    @Override
    public double calculateSquare(Quadrangle quadrangle) {
        Point point1 = quadrangle.getTop(0);
        Point point2 = quadrangle.getTop(1);
        Point point3 = quadrangle.getTop(2);
        Point point4 = quadrangle.getTop(3);

        double square = Math.abs(point1.getCoordinateX() * point2.getCoordinateY() + point2.getCoordinateX() * point3.getCoordinateY()
                + point3.getCoordinateX() * point4.getCoordinateY() + point4.getCoordinateX() * point1.getCoordinateY()
                - point1.getCoordinateY() * point2.getCoordinateX() - point2.getCoordinateY() * point3.getCoordinateX()
                - point3.getCoordinateY() * point4.getCoordinateX() - point4.getCoordinateY() * point1.getCoordinateX()) / 2;

        return square;
    }

    public boolean isConvex(Quadrangle quadrangle) {
        double[] vectorAB = calcVector(quadrangle.getTop(0), quadrangle.getTop(1));
        double[] vectorBC = calcVector(quadrangle.getTop(1), quadrangle.getTop(2));
        double[] vectorCD = calcVector(quadrangle.getTop(2), quadrangle.getTop(3));
        double[] vectorDA = calcVector(quadrangle.getTop(3), quadrangle.getTop(0));

        double productABBC = productVectors(vectorAB, vectorBC);
        double productBCCD = productVectors(vectorBC, vectorCD);
        double productCDDA = productVectors(vectorCD, vectorDA);
        double productDAAB = productVectors(vectorDA, vectorAB);

        return productABBC > 0 && productBCCD > 0 && productCDDA > 0 && productDAAB > 0;
    }

    public QuadrangleType defineQuadrangleType(Quadrangle quadrangle) {
        QuadrangleType result = QuadrangleType.ARBITRARY;

        if (isSquare(quadrangle)) {
            result = QuadrangleType.SQUARE;
        } else if (isRhombus(quadrangle)) {
            result = QuadrangleType.RHOMBUS;
        } else if (isTrapezoid(quadrangle)) {
            result = QuadrangleType.TRAPEZOID;
        }
        return result;
    }

    private boolean isRhombus(Quadrangle quadrangle) {
        double side1 = calcPointsDistance(quadrangle.getTop(0), quadrangle.getTop(1));
        double side2 = calcPointsDistance(quadrangle.getTop(1), quadrangle.getTop(2));
        double side3 = calcPointsDistance(quadrangle.getTop(2), quadrangle.getTop(3));
        double side4 = calcPointsDistance(quadrangle.getTop(3), quadrangle.getTop(0));
        return Double.compare(side1, side2) == 0
                && Double.compare(side2, side3) == 0
                && Double.compare(side3, side4) == 0;
    }

    private boolean isSquare(Quadrangle quadrangle) {
        if (isRhombus(quadrangle)) {
            double diagonal1 = calcPointsDistance(quadrangle.getTop(0), quadrangle.getTop(2));
            double diagonal2 = calcPointsDistance(quadrangle.getTop(1), quadrangle.getTop(3));
            return Double.compare(diagonal1, diagonal2) == 0;
        }
        return false;
    }

    private boolean isTrapezoid(Quadrangle quadrangle) {
        double[] vectorAB = calcVector(quadrangle.getTop(0), quadrangle.getTop(1));
        double[] vectorBC = calcVector(quadrangle.getTop(1), quadrangle.getTop(2));
        double[] vectorCD = calcVector(quadrangle.getTop(2), quadrangle.getTop(3));
        double[] vectorDA = calcVector(quadrangle.getTop(3), quadrangle.getTop(0));

        double productABCD = productVectors(vectorAB, vectorCD);
        double productBCDA = productVectors(vectorBC, vectorDA);

        return Double.compare(productABCD, 0) == 0 || Double.compare(productBCDA, 0) == 0;
    }

    private double calcPointsDistance(Point point1, Point point2) {
        double distanceX = point2.getCoordinateX() - point1.getCoordinateX();
        double distanceY = point2.getCoordinateY() - point1.getCoordinateY();

        return Math.hypot(distanceX, distanceY);
    }

    private double[] calcVector(Point point1, Point point2) {
        double[] vector = new double[2];
        vector[0] = point2.getCoordinateX() - point1.getCoordinateX();
        vector[1] = point2.getCoordinateY() - point1.getCoordinateY();

        return vector;
    }

    private double productVectors(double[] vector1, double[] vector2) {
        return vector1[0] * vector2[1] - vector2[0] * vector1[1];
    }

}
