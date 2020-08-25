package com.shitikov.shape.repository;

import com.shitikov.shape.entity.Quadrangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository {
    private static List<Quadrangle> quadrangles;
    private static QuadrangleRepository instance;

    private QuadrangleRepository() {
        quadrangles = new ArrayList<>();
    }

    public static QuadrangleRepository getInstance() {
        if (instance == null) {
            instance = new QuadrangleRepository();
        }
        return instance;
    }

    public boolean add(Quadrangle quadrangle) {
        if (quadrangle != null) {
            quadrangles.add(quadrangle);
            return true;
        }
        return false;
    }

    public boolean remove(Quadrangle quadrangle) {
        if (quadrangles.contains(quadrangle)) {
            quadrangles.remove(quadrangle);
            return true;
        }
        return false;
    }

    public List<Quadrangle> sortById() {
        List<Quadrangle> sortedList = quadrangles.stream()
                .sorted(Comparator.comparing(Quadrangle::getShapeId))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Quadrangle> sortByX1() {
        List<Quadrangle> sortedList = quadrangles.stream()
                .sorted(Comparator.comparingDouble(q -> q.getTop(0).getCoordinateX()))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Quadrangle> sortByY1() {
        List<Quadrangle> sortedList = quadrangles.stream()
                .sorted(Comparator.comparingDouble(q -> q.getTop(0).getCoordinateY()))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Quadrangle> query(Specification specification) {
        return quadrangles.stream().filter(specification).collect(Collectors.toList());
    }
}
