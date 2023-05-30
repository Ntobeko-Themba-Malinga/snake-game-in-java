package com.snakegame.snakegame;

public class Food {
    private final Position position;

    public Food(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }
}
