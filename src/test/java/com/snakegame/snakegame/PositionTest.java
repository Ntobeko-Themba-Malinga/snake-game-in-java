package com.snakegame.snakegame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void position() {
        Position position = new Position(2, 5);

        assertEquals(2, position.getX());
        assertEquals(5, position.getY());
    }

    @Test
    void positionEqual() {
        Position position1 = new Position(1,2);
        Position position2 = new Position(1, 2);
        assertEquals(position1, position2);
    }

    @Test
    void positionNotEqual() {
        Position position1 = new Position(1,2);
        Position position2 = new Position(3,4);
        assertNotEquals(position1, position2);
    }
}