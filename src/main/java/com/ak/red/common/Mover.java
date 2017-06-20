package com.ak.red.common;

import com.ak.red.model.Coordinate;
import com.ak.red.model.Position;

import java.util.Set;

/**
 * Created by ak on 16/06/2017.
 */
public interface Mover {

    Position move(Position position, String instructions, Coordinate limitCoordinate, Set<Coordinate> scentPositions);
}
