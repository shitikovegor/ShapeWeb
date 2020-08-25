package com.shitikov.shape.util;

public class IdGenerator {
    private static long id = 0;

    private IdGenerator() {
    }

    public static long generateId() {
        id++;
        return id;
    }
}
