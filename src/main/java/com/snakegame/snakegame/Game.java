package com.snakegame.snakegame;

import java.util.List;
import java.util.Random;

public class Game {
    Random random = new Random();
    private final int GAME_OBJECTS_SIZE;
    private final int WIDTH;
    private final int HEIGHT;
    private final Snake snake;
    private Food food;
    private int score;
    private boolean gameOver;

    public Game(Snake snake, int gameObjectsSize, int width, int height) {
        this.snake = snake;
        this.GAME_OBJECTS_SIZE = gameObjectsSize;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.score = 0;
        this.gameOver = false;
        spawnFood();
    }

    public Game(Snake snake, Food food, int gameObjectsSize, int width, int height) {
        this(snake, gameObjectsSize, width, height);
        this.food = food;
    }

    public void gameLogic() {
        if (snake.getPosition().equals(food.getPosition())) {
            snake.growBody();
            this.score++;
            spawnFood();
        }
        snake.move();
        determineGameOver();
    }

    private void determineGameOver() {
        //Out of bounds
        Position snakePosition = this.snake.getPosition();
        if (snakePosition.getX() < 0 || snakePosition.getX() == this.WIDTH) {
            this.gameOver = true;
        }
        else if (snakePosition.getY() < 0 || snakePosition.getY() == this.HEIGHT) {
            this.gameOver = true;
        }

        //Snake colliding with itself
        List<Position> snakeBody = this.snake.getSnakeBody();
        for (int i=1; i < snakeBody.size(); i++) {
            if (snakePosition.equals(snakeBody.get(i))) {
                this.gameOver = true;
                break;
            }
        }
    }

    private void spawnFood() {
        Food newFood;
        while (true) {
            boolean notInSnake = false;
            newFood = new Food(
                    (random.nextInt((WIDTH/GAME_OBJECTS_SIZE) + 1) * this.GAME_OBJECTS_SIZE) - this.GAME_OBJECTS_SIZE,
                    (random.nextInt((HEIGHT/GAME_OBJECTS_SIZE) + 1) * this.GAME_OBJECTS_SIZE) - this.GAME_OBJECTS_SIZE
            );

            for (Position snakeBodyPart : this.snake.getSnakeBody()) {
                if (snakeBodyPart.equals(newFood.getPosition())) {
                    notInSnake = true;
                    break;
                }
            }
            if (!notInSnake) break;
        }
        this.food = newFood;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public Food getFood() {
        return this.food;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }
}
