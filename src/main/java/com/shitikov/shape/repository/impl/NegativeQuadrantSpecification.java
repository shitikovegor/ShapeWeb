package com.shitikov.shape.repository.impl;

import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.repository.Specification;

public class NegativeQuadrantSpecification implements Specification {

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangle.getTop(0).getCoordinateX() < 0 && quadrangle.getTop(0).getCoordinateY() < 0
                && quadrangle.getTop(1).getCoordinateX() < 0 && quadrangle.getTop(1).getCoordinateY() < 0
                && quadrangle.getTop(2).getCoordinateX() < 0 && quadrangle.getTop(2).getCoordinateY() < 0
                && quadrangle.getTop(3).getCoordinateX() < 0 && quadrangle.getTop(3).getCoordinateY() < 0;
    }
}
