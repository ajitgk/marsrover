package com.ak.red.common;

import com.ak.red.model.RoverException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ak.red.common.Constants.COORDINATES_ERROR_MESSAGE;
import static com.ak.red.common.Constants.INPUT_ERROR_MESSAGE;
import static com.ak.red.common.Constants.INSTRUCTIONS_ERROR_MESSAGE;

/**
 * Created by ak on 19/06/2017.
 */
public class InputValidator implements Validator {

    @Override
    public void validate(String input, Pattern pattern) throws RoverException {
        if (!pattern.matcher(input).matches()) {
            throw new RoverException(INPUT_ERROR_MESSAGE);
        }

        Matcher matcher = pattern.matcher(input);
        matcher.find();
        String[] inputs = matcher.group(1).split(" ");

        if (inputs.length == 1) {
            // instruction
            if (inputs[0].length() >= 100) {
                throw new RoverException(INSTRUCTIONS_ERROR_MESSAGE);
            }
        } else if (inputs.length == 2 || inputs.length == 3) {
            // initial position
            if (Integer.valueOf(inputs[0]) > 50 || Integer.valueOf(inputs[1]) > 50
                    || Integer.valueOf(inputs[0]) < 0 || Integer.valueOf(inputs[1]) < 0) {
                throw new RoverException(COORDINATES_ERROR_MESSAGE);
            }
        }
    }
}
