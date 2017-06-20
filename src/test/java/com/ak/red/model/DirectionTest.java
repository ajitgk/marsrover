package com.ak.red.model;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by ak on 18/06/2017.
 */
public class DirectionTest {

    @Test
    public void testTurnRight() {
        Assert.assertEquals(Direction.E, Direction.turnRight(Direction.N));
        Assert.assertEquals(Direction.S, Direction.turnRight(Direction.E));
        Assert.assertEquals(Direction.W, Direction.turnRight(Direction.S));
        Assert.assertEquals(Direction.N, Direction.turnRight(Direction.W));
    }

    @Test
    public void testTurnLeft() {
        Assert.assertEquals(Direction.W, Direction.turnLeft(Direction.N));
        Assert.assertEquals(Direction.N, Direction.turnLeft(Direction.E));
        Assert.assertEquals(Direction.E, Direction.turnLeft(Direction.S));
        Assert.assertEquals(Direction.S, Direction.turnLeft(Direction.W));
    }

}