package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;

    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size() ; i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y,
                    Color.NONE, i == 0 ? HEAD_SIGN : BODY_SIGN,
                    isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public void setDirection(Direction direction) {
        boolean horizontal = (this.direction.equals(Direction.LEFT) || this.direction.equals(Direction.RIGHT))
                && snakeParts.get(0).x == snakeParts.get(1).x;

        boolean vertical = (this.direction.equals(Direction.UP) || this.direction.equals(Direction.DOWN))
                && snakeParts.get(0).y == snakeParts.get(1).y;

        if (horizontal || vertical) {
            return;
        }

        horizontal = (direction.equals(Direction.LEFT) && this.direction.equals(Direction.RIGHT))
                || (direction.equals(Direction.RIGHT) && this.direction.equals(Direction.LEFT));
        vertical = (direction.equals(Direction.UP) && this.direction.equals(Direction.DOWN))
                || (direction.equals(Direction.DOWN) && this.direction.equals(Direction.UP));

        if (horizontal || vertical) {
            return;
        }

        this.direction = direction;
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        if (newHead.x < 0 || newHead.y < 0
                || newHead.x >= SnakeGame.WIDTH || newHead.y >= SnakeGame.HEIGHT) {

            isAlive = false;

            return;
        }

        if (checkCollision(newHead)) {
            isAlive = false;

            return;
        }

        snakeParts.add(0, newHead);

        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
        }else {
            removeTail();
        }
    }

    public GameObject createNewHead() {
        int x = snakeParts.get(0).x;
        int y = snakeParts.get(0).y;

        if (direction == Direction.LEFT){
            x--;
        } else if (direction == Direction.RIGHT) {
            x++;
        } else if (direction == Direction.UP) {
            y--;
        } else {
            y++;
        }

        return new GameObject(x, y);
    }

    public boolean checkCollision(GameObject object) {
        for (GameObject snakePart : snakeParts) {
            if (snakePart.x == object.x && snakePart.y == object.y) {
                return true;
            }
        }

        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}
