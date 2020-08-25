package com.shitikov.shape.repository.impl;

import com.shitikov.shape.entity.Quadrangle;
import com.shitikov.shape.repository.Specification;

public class IdSpecification implements Specification {
    private int quadrangleId;

    public IdSpecification(int quadrangleId) {
        this.quadrangleId = quadrangleId;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangle.getShapeId() == quadrangleId;
    }
}
