package com.ak.red.model;

/**
 * Created by ak on 16/06/2017.
 */
public enum Direction {
    N, E, S, W;
    public static final Direction[] values = values();

    public static Direction turnRight(Direction direction) {
        return values[(direction.ordinal() + 1) % values.length];
    }

    public static Direction turnLeft(Direction direction) {
        return values[(direction.ordinal() + 3) % values.length];
    }
}
