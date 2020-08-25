package com.shitikov.shape.service;

import com.shitikov.shape.entity.Shape;

public interface ShapeService<T extends Shape> {
    double calculatePerimeter(T shape);
    double calculateSquare(T shape);
}
