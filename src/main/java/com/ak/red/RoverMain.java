package com.ak.red;

import com.ak.red.common.InputValidator;
import com.ak.red.common.Validator;
import com.ak.red.model.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ak.red.common.Constants.INITIAL_POSITION_PATTERN;
import static com.ak.red.common.Constants.INSTRUCTION_PATTERN;
import static com.ak.red.common.Constants.LIMIT_PATTERN;

/**
 * Created by ak on 16/06/2017.
 */
public class RoverMain {

    private static final List<Rover> ROVERS = new ArrayList<>();
    private static Coordinate LIMIT_COORDINATE;
    private static final Set<Coordinate> SCENT_POSITIONS = new HashSet<>();
    private static final List<String> INPUT = new ArrayList<>();
    private static final List<Instruction> INSTRUCTIONS = new ArrayList<>();

    private static final Validator VALIDATOR = new InputValidator();

    public static void main(String[] args) throws RoverException {

        RoverMain roverMain = new RoverMain();
        roverMain.readInput();

//        INPUT.subList(1, INPUT.size()).forEach(input -> {
////            matcher = INITIAL_POSITION_PATTERN.matcher(input);
//
//                System.out.println(INITIAL_POSITION_PATTERN.matcher(input).matches());
//                System.out.println(INSTRUCTION_PATTERN.matcher(input).matches());
//                }
//        );

        INPUT.forEach(t -> System.out.println(t));
        INSTRUCTIONS.forEach(t -> System.out.println(t));

        roverMain.process();

    }

    public void process() {
        INSTRUCTIONS.forEach(instruction -> {
            Rover rover = new Rover(instruction.getPosition());
            ROVERS.add(rover);

            Position finalPosition = rover.move(instruction.getInstructions(), LIMIT_COORDINATE, SCENT_POSITIONS);
            System.out.println(finalPosition);
        });
    }

    public void readInput() throws RoverException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String nextLine;
        try {
            while((line = in.readLine()) != null) {
                if (LIMIT_COORDINATE == null) {
                    // first line will be the upper right coordinate
                    VALIDATOR.validate(line, LIMIT_PATTERN);
                    String[] coordinates = line.split(" ");
                    LIMIT_COORDINATE = new Coordinate(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1]));
                } else {
                    VALIDATOR.validate(line, INITIAL_POSITION_PATTERN);
                    nextLine = in.readLine();
                    VALIDATOR.validate(nextLine, INSTRUCTION_PATTERN);

                    String[] values = line.split(" ");
                    Coordinate coordinate = new Coordinate(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
                    Direction direction = Direction.valueOf(values[2]);
                    Position position = new Position(coordinate, direction);
                    INSTRUCTIONS.add(new Instruction(position, nextLine));
                }
            }
        } catch (IOException e) {
            throw new RoverException("Could not read input.", e);
        }
    }

}
