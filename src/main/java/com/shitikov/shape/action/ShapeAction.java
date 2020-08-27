package com.shitikov.shape.action;

import com.shitikov.shape.entity.Shape;

public interface ShapeAction<T extends Shape> {
    double calculatePerimeter(T shape);
    double calculateSquare(T shape);
}
