package com.ak.red.common;

import com.ak.red.model.Coordinate;
import com.ak.red.model.Direction;
import com.ak.red.model.Position;

import java.util.Set;

import static com.ak.red.model.Direction.*;

/**
 * Created by ak on 16/06/2017.
 */
public class RFLMover implements Mover {

    @Override
    public Position move(Position position, String instructions, Coordinate limitCoordinate, Set<Coordinate> scentPositions) {
        Direction direction = position.getDirection();
        Coordinate coordinate = position.getCoordinate();
        boolean isLost = false;

        for (Character rfl: instructions.toCharArray()) {
            switch(rfl) {
                case 'R':
                        direction = turnRight(direction);
                    break;
                case 'F':
                    isLost = moveIfRequired(limitCoordinate, direction, coordinate, scentPositions);
                    break;
                case 'L':
                    direction = turnLeft(direction);
                    break;
                default:
            }

            if (isLost) {
                break;
            }
        }

        Position newPosition =  new Position(coordinate, direction);
        if (isLost) {
            newPosition.setLost(true);
        }

        return newPosition;
    }

    private boolean moveIfRequired(Coordinate limitCoordinate, Direction direction, Coordinate coordinate, Set<Coordinate> scentPositions) {
        boolean isLost = false;
        Coordinate possibleLostCoordinate;
        if (direction == N) {
            possibleLostCoordinate = new Coordinate(coordinate.getxCoordinate(), coordinate.getyCoordinate() + 1);
            isLost = checkIfLost(possibleLostCoordinate, limitCoordinate);
            if (!isLost) {
                coordinate.setyCoordinate(coordinate.getyCoordinate() + 1);
            } else {
                isLost = checkScentPositions(scentPositions, coordinate);
            }
        } else if (direction == S) {
            possibleLostCoordinate = new Coordinate(coordinate.getxCoordinate(), coordinate.getyCoordinate() - 1);
            isLost = checkIfLost(possibleLostCoordinate, limitCoordinate);
            if (!isLost) {
                coordinate.setyCoordinate(coordinate.getyCoordinate() - 1);
            } else {
                isLost = checkScentPositions(scentPositions, coordinate);
            }
        } else if (direction == E) {
            possibleLostCoordinate = new Coordinate(coordinate.getxCoordinate() + 1, coordinate.getyCoordinate());
            isLost = checkIfLost(possibleLostCoordinate, limitCoordinate);
            if (!isLost) {
                coordinate.setxCoordinate(coordinate.getxCoordinate() + 1);
            } else {
                isLost = checkScentPositions(scentPositions, coordinate);
            }
        } else if (direction == W) {
            possibleLostCoordinate = new Coordinate(coordinate.getxCoordinate() - 1, coordinate.getyCoordinate());
            isLost = checkIfLost(possibleLostCoordinate, limitCoordinate);
            if (!isLost) {
                coordinate.setxCoordinate(coordinate.getxCoordinate() - 1);
            } else {
                isLost = checkScentPositions(scentPositions, coordinate);
            }
        }

        return isLost;
    }

    private boolean checkScentPositions(Set<Coordinate> scentPositions, Coordinate possibleScentCoordinate) {
        boolean isLost = true;
        if (scentPositions.contains(possibleScentCoordinate)) {
            isLost = false;
        } else {
            scentPositions.add(possibleScentCoordinate);
        }
        return isLost;
    }

    private boolean checkIfLost(Coordinate coordinate, Coordinate limitCoordinate) {
        if (coordinate.getyCoordinate() < 0 || coordinate.getxCoordinate() < 0)
            return true;

        if (coordinate.getxCoordinate() > limitCoordinate.getxCoordinate() || coordinate.getyCoordinate() > limitCoordinate.getyCoordinate())
            return true;

        return false;
    }

}
