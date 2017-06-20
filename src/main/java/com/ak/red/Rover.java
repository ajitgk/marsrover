package com.ak.red;

import com.ak.red.common.Mover;
import com.ak.red.common.RFLMover;
import com.ak.red.model.Coordinate;
import com.ak.red.model.Position;

import java.util.Set;

/**
 * Created by ak on 16/06/2017.
 */
public class Rover {
    private Position position;
    private Mover mover = new RFLMover(); // count be injected

    public Rover(Position position) {
        this.position = position;
    }

    public Position move(String instructions, Coordinate limitCoordinate, Set<Coordinate> scentPositions) {
        return mover.move(position, instructions, limitCoordinate, scentPositions);
    }

}
