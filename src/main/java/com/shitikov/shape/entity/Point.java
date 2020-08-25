package com.shitikov.shape.entity;

public class Point {
    private double coordinateX;
    private double coordinateY;

    public Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public Point setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
        return this;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public Point setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Point other = (Point) obj;
        if (Double.compare(other.coordinateX, coordinateX) != 0)
            return false;
        return Double.compare(other.coordinateY, coordinateY) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        long temp = Double.doubleToLongBits(coordinateX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordinateY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(coordinateX);
        sb.append(", y=").append(coordinateY);
        sb.append('}');
        return sb.toString();
    }
}
