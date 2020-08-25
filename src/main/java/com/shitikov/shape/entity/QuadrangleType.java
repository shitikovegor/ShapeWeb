package com.shitikov.shape.entity;

public enum QuadrangleType {
    ARBITRARY ("Arbitrary"),
    SQUARE ("Square"),
    RHOMBUS ("Rhombus"),
    TRAPEZOID ("Trapezoid");

    private String name;

    QuadrangleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
