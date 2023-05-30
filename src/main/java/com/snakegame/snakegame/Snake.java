package com.snakegame.snakegame;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private final List<Position> snakeBody;
    private Direction direction;
    private Position position;
    private final int moveStep;

    public Snake(Position position, Direction initialDirection, int moveStep) {
        this.position = position;
        this.direction = initialDirection;
        this.moveStep = moveStep;
        this.snakeBody = new ArrayList<>();
        this.initialize();
    }

    private void initialize() {
        for (int i=0; i < 3; i++) this.snakeBody.add(position);
    }

    public void move() {
        int newX = position.getX();
        int newY = position.getY();

        switch (direction) {
            case NORTH -> newY -= moveStep;
            case SOUTH -> newY += moveStep;
            case WEST -> newX -= moveStep;
            case EAST -> newX += moveStep;
        }
        position = new Position(newX, newY);
        snakeBody.add(0, position);
        snakeBody.remove(snakeBody.size() - 1);
    }

    public void growBody() {
        snakeBody.add(snakeBody.get(snakeBody.size() - 1));
    }

    public void setDirection(Direction direction) {
        if (!(Direction.NORTH.equals(this.direction) && Direction.SOUTH.equals(direction))
                && !(Direction.SOUTH.equals(this.direction) && Direction.NORTH.equals(direction))
                && !(Direction.WEST.equals(this.direction) && Direction.EAST.equals(direction))
                && !(Direction.EAST.equals(this.direction) && Direction.WEST.equals(direction)))
            this.direction = direction;
    }

    public Position getPosition() {
        return snakeBody.get(0);
    }

    public List<Position> getSnakeBody() {
        return this.snakeBody;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
