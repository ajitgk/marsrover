package com.ak.red.model;

/**
 * Created by ak on 16/06/2017.
 */
public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(xCoordinate, that.xCoordinate)
                .append(yCoordinate, that.yCoordinate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(xCoordinate)
                .append(yCoordinate)
                .toHashCode();
    }
}
