package com.shitikov.shape.repository.impl;

import com.shitikov.shape.entity.Point;
import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.repository.Specification;

import java.util.List;

public class OriginDistanceSpecification implements Specification {
    private double distanceFromOrigin;

    public OriginDistanceSpecification(double distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }


    @Override
    public boolean test(Quadrangle quadrangle) {
        List<Point> tops = quadrangle.getTops();
        for (Point top : tops) {
            if (Math.hypot(top.getCoordinateX(), top.getCoordinateY()) < distanceFromOrigin) {
                return false;
            }
        }

        return true;
    }
}
