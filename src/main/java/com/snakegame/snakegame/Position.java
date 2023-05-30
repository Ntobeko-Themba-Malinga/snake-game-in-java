package com.snakegame.snakegame;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;

        return position.getX() == x && position.getY() == y;
    }
}
