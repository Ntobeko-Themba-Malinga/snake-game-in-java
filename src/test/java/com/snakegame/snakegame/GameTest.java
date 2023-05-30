package com.snakegame.snakegame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void gameLogicNoCollision() {
        Snake snake = new Snake(new Position(20,20), Direction.NORTH, 5);
        Game game = new Game(snake, 5, 200, 200);
        game.gameLogic();
        assertEquals(new Position(20, 15), game.getSnake().getPosition(), "Snake should have move to Position(20, 15");
    }

    @Test
    void gameLogicFoodCollision() {
        Snake snake = new Snake(new Position(20,20), Direction.NORTH, 5);
        Food food = new Food(20, 15);
        Game game = new Game(snake, food, 5, 200, 200);
        game.gameLogic();
        game.gameLogic();
        assertEquals(4, game.getSnake().getSnakeBody().size(), "Snake body should have grown to 4");
        assertEquals(1, game.getScore(), "Score should be 1");
        assertFalse(game.isGameOver(), "The game shouldn't be over");
    }

    @Test
    void gameLogicBoundaryCollision() {
        Snake snake = new Snake(new Position(20,0), Direction.NORTH, 5);
        Game game = new Game(snake, 5, 200, 200);
        game.gameLogic();
        assertTrue(game.isGameOver(), "The game should be over");
    }
}