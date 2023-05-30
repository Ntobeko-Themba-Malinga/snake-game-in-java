package com.snakegame.snakegame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    @Test
    void food() {
        Food food = new Food(2, 2);
        assertEquals(new Position(2, 2), food.getPosition());
    }
}