package com.shitikov.shape.warehouse;

import com.shitikov.shape.entity.QuadrangleType;

public class QuadrangleProperty {
    private double perimeter;
    private double square;
    private boolean isConvex;
    private QuadrangleType type;

    public QuadrangleProperty(double perimeter, double square, boolean isConvex, QuadrangleType type) {
        this.perimeter = perimeter;
        this.square = square;
        this.isConvex = isConvex;
        this.type = type;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public QuadrangleProperty setPerimeter(double perimeter) {
        this.perimeter = perimeter;
        return this;
    }

    public double getSquare() {
        return square;
    }

    public QuadrangleProperty setSquare(double square) {
        this.square = square;
        return this;
    }

    public boolean isConvex() {
        return isConvex;
    }

    public QuadrangleProperty setConvex(boolean convex) {
        isConvex = convex;
        return this;
    }

    public QuadrangleType getType() {
        return type;
    }

    public QuadrangleProperty setType(QuadrangleType type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        QuadrangleProperty other = (QuadrangleProperty) obj;

        if (Double.compare(other.perimeter, perimeter) != 0)
            return false;
        if (Double.compare(other.square, square) != 0)
            return false;
        if (isConvex != other.isConvex)
            return false;
        return type == other.type;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result;
        long temp;
        temp = Double.doubleToLongBits(perimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (isConvex ? 1 : 0);
        result = prime * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleProperties{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", square=").append(square);
        sb.append(", isConvex=").append(isConvex);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
