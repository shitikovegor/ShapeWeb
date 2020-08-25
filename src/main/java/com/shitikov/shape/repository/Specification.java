package com.shitikov.shape.repository;

import com.shitikov.shape.entity.Quadrangle;

import java.util.function.Predicate;

public interface Specification extends Predicate<Quadrangle> {
}
