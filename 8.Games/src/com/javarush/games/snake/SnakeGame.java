package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;

    private Snake snake;
    private Apple apple;

    private int turnDelay;
    private int score;

    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);

        createGame();
    }

    private void createGame() {
        score = 0;
        setScore(score);
        isGameStopped = false;
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        turnDelay = 400;

        setTurnTimer(turnDelay);
        drawScene();
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.WHITE, "");
            }
        }

        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        int x = getRandomNumber(WIDTH);
        int y = getRandomNumber(HEIGHT);

        while (snake.checkCollision(new GameObject(x, y))) {
            x = getRandomNumber(WIDTH);
            y = getRandomNumber(HEIGHT);
        }

        apple = new Apple(x, y);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "YOU WIN", Color.WHITE, 75);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.RED, "GAME OVER", Color.WHITE, 75);
    }

    @Override
    public void onTurn(int step) {
        if (snake.speed == 0) {
            return;
        }

        snake.move(apple);

        if (!apple.isAlive) {
            setScore(score += 5);
            setTurnTimer(turnDelay -= 10);
            createNewApple();
        }

        if (!snake.isAlive) {
            gameOver();
        }

        if (GOAL < snake.getLength()) {
            win();
        }

        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key.equals(Key.LEFT)) {
            snake.setDirection(Direction.LEFT);
        } else if (key.equals(Key.RIGHT)) {
            snake.setDirection(Direction.RIGHT);
        } else if (key.equals(Key.UP)) {
            snake.setDirection(Direction.UP);
        } else if (key.equals(Key.DOWN)){
            snake.setDirection(Direction.DOWN);
        } else if (key.equals(Key.SPACE) && isGameStopped) {
            createGame();
        }

        if (key.equals(Key.LEFT) || key.equals(Key.RIGHT)
            || key.equals(Key.UP) || key.equals(Key.DOWN)) {

            if (snake.speed == 0) {
                stopTurnTimer();
            } else {
                setTurnTimer(turnDelay - snake.speed * 20);
            }
        }
    }
}
