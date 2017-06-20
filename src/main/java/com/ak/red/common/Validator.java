package com.ak.red.common;

import com.ak.red.model.RoverException;

import java.util.regex.Pattern;

/**
 * Created by ak on 19/06/2017.
 */
public interface Validator  {
    void validate(String input, Pattern limitPattern) throws RoverException;
}
