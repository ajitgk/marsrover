package com.ak.red.common;

import java.util.regex.Pattern;

/**
 * Created by ak on 20/06/2017.
 */
public class Constants {
    public static final Pattern LIMIT_PATTERN = Pattern.compile("(\\d{1,2}\\s+\\d{1,2})");
    public static final Pattern INITIAL_POSITION_PATTERN = Pattern.compile("(\\d{1,2}\\s+\\d{1,2}\\s+[NEWS])");
    public static final Pattern INSTRUCTION_PATTERN = Pattern.compile("([RFL]{1,99})");

    public static final String INPUT_ERROR_MESSAGE = "Incorrect input provided. Please refer the README file for correct input sequence.\n" +
            "Input needs to be of the following format with inputs on the same line separated by space:\n" +
            "First line should provide the upper right coordinates sesuch as:\n" +
            "5 3\n\n" +
            "The subsequent two lines should provide the initial position and instructions respectively for the robot with 2 lines per robot:\n" +
            "1 1 E\n" +
            "RFRFRFRF";

    public static final String INSTRUCTIONS_ERROR_MESSAGE = "Instructions cannot be more than 100 characters long!";
    public static final String COORDINATES_ERROR_MESSAGE = "Coordinate values cannot be less than 0 and greater than 50 ";


}
