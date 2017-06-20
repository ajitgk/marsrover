package com.ak.red.common;

import com.ak.red.model.Coordinate;
import com.ak.red.model.Direction;
import com.ak.red.model.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.ak.red.model.Direction.*;

/**
 * Created by ak on 18/06/2017.
 */
public class RFLMoverTest {

    private static final Set<Coordinate> SCENT_POSITIONS = new HashSet<>();
    private static Coordinate LIMIT_COORDINATE;
    private Mover mover = new RFLMover();

    @Before
    public void setUp() throws Exception {

    }

    private void setLimitCoordinate(Coordinate coordinate) {
        LIMIT_COORDINATE = coordinate;
    }

    @Test
    public void testSimpleFinalPosition() {
        // Given
        Position currentPosition = new Position(new Coordinate(1,1), E);
        setLimitCoordinate(new Coordinate(5, 3));
        String instructions = "RFRFRFRF";

        // when
        Position finalPosition = mover.move(currentPosition, instructions, LIMIT_COORDINATE, SCENT_POSITIONS);

        // then
        Assert.assertEquals(createPosition(1, 1, E), finalPosition);
    }

    @Test
    public void testLostPosition() {
        // Given
        Position currentPosition = new Position(new Coordinate(3,2), Direction.N);
        setLimitCoordinate(new Coordinate(5, 3));
        String instructions = "FRRFLLFFRRFLL";

        // when
        Position finalPosition = mover.move(currentPosition, instructions, LIMIT_COORDINATE, SCENT_POSITIONS);

        // then
        Assert.assertEquals(createPosition(3, 3, N, true), finalPosition);
        Assert.assertTrue(SCENT_POSITIONS.contains(new Coordinate(3, 3)));
    }

    @Test
    public void testIgnoreInstructionOnScentPosition() {
        // Given
        Position currentPosition = new Position(new Coordinate(0,3), W);
        setLimitCoordinate(new Coordinate(5, 3));
        String instructions = "LLFFFLFLFL";
        SCENT_POSITIONS.add(new Coordinate(3,3));

        // when
        Position finalPosition = mover.move(currentPosition, instructions, LIMIT_COORDINATE, SCENT_POSITIONS);

        // then
        Assert.assertEquals(createPosition(2,3, S), finalPosition);
    }


    @Test
    public void testLostFromOrigin() {
        // Given
        Position currentPosition = new Position(new Coordinate(0,0), W);
        setLimitCoordinate(new Coordinate(0, 0));
        String instructions = "F";

        // when
        Position finalPosition = mover.move(currentPosition, instructions, LIMIT_COORDINATE, SCENT_POSITIONS);

        // then
        Assert.assertEquals(createPosition(0,0, W, true), finalPosition);
    }

    private Position createPosition(int x, int y, Direction direction, boolean isLost) {
        return new Position(new Coordinate(x, y), direction, isLost);
    }

    private Position createPosition(int x, int y, Direction direction) {
        return new Position(new Coordinate(x, y), direction, false);
    }

}