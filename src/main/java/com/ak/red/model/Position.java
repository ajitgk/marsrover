package com.ak.red.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by ak on 16/06/2017.
 */
public class Position {
    private Coordinate coordinate;
    private Direction direction;
    private boolean isLost;

    public Position(Coordinate coordinate, Direction direction) {
        this(coordinate, direction, false);
    }

    public Position(Coordinate coordinate, Direction direction, boolean isLost) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.isLost = isLost;
    }

    public Direction getDirection() {
        return Direction.valueOf(direction.toString());
    }

    public Coordinate getCoordinate() {
        return new Coordinate(coordinate.getxCoordinate(), coordinate.getyCoordinate());
    }

    public void setLost(boolean lost) {
        this.isLost = lost;
    }

    public String lost() {
        return isLost ? " LOST" : "";
    }

    @Override
    public String toString() {
        return coordinate.getxCoordinate() + " " + coordinate.getyCoordinate() + " " + direction + "" + lost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return new EqualsBuilder()
                .append(isLost, position.isLost)
                .append(coordinate, position.coordinate)
                .append(direction, position.direction)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(coordinate)
                .append(direction)
                .append(isLost)
                .toHashCode();
    }
}
