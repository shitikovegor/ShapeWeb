package com.shitikov.shape.validator;

public class PointValidator {
    private static final double MIN_VALUE = -500.0;
    private static final double MAX_VALUE = 500.0;

    private static PointValidator instance;

    private PointValidator() {
    }

    public static PointValidator getInstance() {
        if (instance == null) {
            instance = new PointValidator();
        }
        return instance;
    }

    public boolean isPointDataCorrect(double coordinateX, double coordinateY) {
        return coordinateX >= MIN_VALUE && coordinateX <= MAX_VALUE
                && coordinateY >=MIN_VALUE && coordinateY <= MAX_VALUE;
    }
}
