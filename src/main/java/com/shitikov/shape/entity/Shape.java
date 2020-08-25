package com.shitikov.shape.entity;

import com.shitikov.shape.util.IdGenerator;

public abstract class Shape {
    private long shapeId;

    public Shape() {
        this.shapeId = IdGenerator.generateId();
    }

    public long getShapeId() {
        return shapeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;

        return shapeId == shape.shapeId;
    }

    @Override
    public int hashCode() {
        return (int) (shapeId ^ (shapeId >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Id=");
        sb.append(shapeId);
        return sb.toString();
    }
}
