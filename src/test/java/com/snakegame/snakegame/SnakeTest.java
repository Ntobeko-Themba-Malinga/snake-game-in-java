package com.snakegame.snakegame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
    @Test
    void initialize() {
        Snake snake = new Snake(new Position(1, 3), Direction.NORTH, 1);
        assertEquals(1, snake.getPosition().getX());
        assertEquals(3, snake.getPosition().getY());
        assertEquals(3, snake.getSnakeBody().size());
        assertEquals(Direction.NORTH, snake.getDirection());
    }

    @Test
    void setDirection() {
        Snake snake = new Snake(new Position(0,9), Direction.EAST, 1);
        assertEquals(Direction.EAST, snake.getDirection());
        snake.setDirection(Direction.NORTH);
        assertEquals(Direction.NORTH, snake.getDirection());
    }

    @Test
    void moveNorth() {
        Snake snake = new Snake(new Position(0,10), Direction.NORTH, 5);
        snake.move();
        assertEquals(5, snake.getPosition().getY());
    }

    @Test
    void moveSouth() {
        Snake snake = new Snake(new Position(0,10), Direction.SOUTH, 5);
        snake.move();
        assertEquals(15, snake.getPosition().getY());
    }

    @Test
    void moveEast() {
        Snake snake = new Snake(new Position(0,10), Direction.EAST, 5);
        snake.move();
        assertEquals(5, snake.getPosition().getX());
    }

    @Test
    void moveWest() {
        Snake snake = new Snake(new Position(0,10), Direction.WEST, 5);
        snake.move();
        assertEquals(-5, snake.getPosition().getX());
    }

    @Test
    void growBody() {
        Snake snake = new Snake(new Position(0,10), Direction.WEST, 5);
        int snakeBodySizeBeforeGrow = snake.getSnakeBody().size();

        snake.growBody();
        int snakeBodySizeAfterGrow = snake.getSnakeBody().size();

        assertEquals(3, snakeBodySizeBeforeGrow);
        assertEquals(4, snakeBodySizeAfterGrow);
    }

    @Test
    void changeDirectionWest() {
        Snake snake = new Snake(new Position(0,10), Direction.NORTH, 5);
        snake.setDirection(Direction.WEST);
        snake.move();
        assertNotEquals(new Position(0, 15), snake.getPosition(), "Snake direction didn't change");
        assertEquals(new Position(-5, 10), snake.getPosition(), "Snake should have moved WEST to new Position(-5, 10)");
    }

    @Test
    void changeDirectionEAST() {
        Snake snake = new Snake(new Position(0,10), Direction.NORTH, 5);
        snake.setDirection(Direction.EAST);
        snake.move();
        assertNotEquals(new Position(0, 15), snake.getPosition(), "Snake direction didn't change");
        assertEquals(new Position(5, 10), snake.getPosition(), "Snake should have moved EAST to new Position(-5, 10)");
    }

    @Test
    void changeDirectionNorth() {
        Snake snake = new Snake(new Position(0, 10), Direction.EAST, 5);
        snake.setDirection(Direction.NORTH);
        snake.move();
        assertNotEquals(new Position(5, 10), snake.getPosition(), "Snake direction didn't change");
        assertEquals(new Position(0, 5), snake.getPosition(), "Snake should have moved NORTH to new Position(0, 5)");
    }

    @Test
    void changeDirectionSouth() {
        Snake snake = new Snake(new Position(0, 10), Direction.EAST, 5);
        snake.setDirection(Direction.SOUTH);
        snake.move();
        assertNotEquals(new Position(5, 10), snake.getPosition(), "Snake direction didn't change");
        assertEquals(new Position(0, 15), snake.getPosition(), "Snake should have moved SOUTH to new Position(0, 15)");
    }
}