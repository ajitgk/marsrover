package com.ak.red.model;

/**
 * Created by ak on 17/06/2017.
 */
public class Instruction {
    private Position position;
    private String instructions;

    public Instruction(Position position, String instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public Position getPosition() {
        return position;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return position.toString() + ", " + instructions;
    }
}
