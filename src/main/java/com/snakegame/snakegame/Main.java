package com.snakegame.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private void updateDisplay(Pane root, Game game, int size) {
        if (!game.isGameOver()) {
            root.getChildren().remove(1, root.getChildren().size());

            for (Position snake : game.getSnake().getSnakeBody()) {
                Rectangle snakeBody = new Rectangle();
                snakeBody.setX(snake.getX());
                snakeBody.setY(snake.getY());
                snakeBody.setWidth(size);
                snakeBody.setHeight(size);
                snakeBody.setFill(Color.GREEN);
                root.getChildren().add(snakeBody);
            }

            Position foodPosition = game.getFood().getPosition();
            Rectangle displayFood = new Rectangle();
            displayFood.setX(foodPosition.getX());
            displayFood.setY(foodPosition.getY());
            displayFood.setWidth(size);
            displayFood.setHeight(size);
            displayFood.setFill(Color.YELLOW);
            root.getChildren().add(displayFood);

            Text score = new Text();
            score.setText("SCORE: " + game.getScore());
            score.setFill(Color.WHITE);
            score.setFont(Font.font(20));
            score.setX(50);
            score.setY(50);
            root.getChildren().add(score);
        } else {
            Text gameOverText = new Text();
            gameOverText.setText("GAME OVER!!");
            gameOverText.setFill(Color.RED);
            gameOverText.setFont(Font.font(20));
            gameOverText.setX(50);
            gameOverText.setY(25);
            root.getChildren().add(gameOverText);
        }
        game.gameLogic();
     }

    @Override
    public void start(Stage stage) {
        Random random = new Random();
        int windowWidth = 600;
        int windowHeight = 500;
        int moveStep = 20;

        Position initialSnakePosition = new Position(
                (random.nextInt((windowWidth/moveStep) + 1) * moveStep) - moveStep,
                (random.nextInt((windowHeight/moveStep) + 1) * moveStep) - moveStep
        );
        Snake snake = new Snake(initialSnakePosition, Direction.EAST, moveStep);
        Game game = new Game(snake, moveStep, windowWidth, windowHeight);

        Pane root = new Pane();
        Scene scene = new Scene(root, windowWidth, windowHeight, Color.BLACK);

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                updateDisplay(root, game, moveStep);
            }
        }.start();

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case A -> snake.setDirection(Direction.WEST);
                case D -> snake.setDirection(Direction.EAST);
                case W -> snake.setDirection(Direction.NORTH);
                case S -> snake.setDirection(Direction.SOUTH);
            }
        });

        Rectangle boundary = new Rectangle();
        boundary.setStroke(Color.RED);
        boundary.setHeight(windowHeight);
        boundary.setWidth(windowWidth);

        root.getChildren().add(0, boundary);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
