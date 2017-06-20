package com.ak.red.common;

import com.ak.red.model.RoverException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.ak.red.common.Constants.COORDINATES_ERROR_MESSAGE;
import static com.ak.red.common.Constants.INPUT_ERROR_MESSAGE;

/**
 * Created by ak on 20/06/2017.
 */
public class ValidatorTest {

    private Validator validator = new InputValidator();

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIncorrectInstructionInput() throws RoverException {

        expectedException.expect(RoverException.class);
        expectedException.expectMessage(INPUT_ERROR_MESSAGE);
        validator.validate("RFLA", Constants.INSTRUCTION_PATTERN);
    }

    @Test
    public void testInvalidInstructionInput() throws RoverException {

        expectedException.expect(RoverException.class);
        expectedException.expectMessage(INPUT_ERROR_MESSAGE);
        validator.validate(StringUtils.repeat("RFL", 34), Constants.INSTRUCTION_PATTERN);
    }

    @Test
    public void testCorrectInstructionInput() throws RoverException {

        validator.validate("RFLRFLLLLFFFR", Constants.INSTRUCTION_PATTERN);
    }

    @Test
    public void testIncorrectLimitInput() throws RoverException {

        expectedException.expect(RoverException.class);
        expectedException.expectMessage(COORDINATES_ERROR_MESSAGE);
        validator.validate("51 3", Constants.LIMIT_PATTERN);
    }

    @Test
    public void testNegativeLimitInput() throws RoverException {

        expectedException.expect(RoverException.class);
        expectedException.expectMessage(INPUT_ERROR_MESSAGE);
        validator.validate("-1 50", Constants.LIMIT_PATTERN);
    }

    @Test
    public void testCorrectLimitInput() throws RoverException {

        validator.validate("5 3", Constants.LIMIT_PATTERN);
    }

    @Test
    public void testIncorrectInitialPositionInput() throws RoverException {

        expectedException.expect(RoverException.class);
        expectedException.expectMessage(INPUT_ERROR_MESSAGE);
        validator.validate("RF", Constants.INITIAL_POSITION_PATTERN);
    }

    @Test
    public void testInvalidInitialPositionInput() throws RoverException {

        expectedException.expect(RoverException.class);
        expectedException.expectMessage(COORDINATES_ERROR_MESSAGE);
        validator.validate("1 51 E", Constants.INITIAL_POSITION_PATTERN);
    }

    @Test
    public void testValidInitialPositionInput() throws RoverException {

        validator.validate("1 50 E", Constants.INITIAL_POSITION_PATTERN);
    }

}