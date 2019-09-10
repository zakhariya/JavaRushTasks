package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    public boolean isAlive = true;
    public int speed = 1;

    private Direction direction = Direction.LEFT;

    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        int size = snakeParts.size();
        for (int i = 0; i < size; i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, 
                    Color.NONE, i == 0 || i == size - 1? HEAD_SIGN : BODY_SIGN,
                    isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public void setDirection(Direction direction) {
        System.out.println("New direction: " + direction + ", last direction: " + this.direction + ", speed: " + speed);
        if (direction.equals(Direction.LEFT) && this.direction.equals(Direction.LEFT)
            || direction.equals(Direction.RIGHT) && this.direction.equals(Direction.RIGHT)
            || direction.equals(Direction.UP) && this.direction.equals(Direction.UP)
            || direction.equals(Direction.DOWN) && this.direction.equals(Direction.DOWN)) {

            if (speed < 6) {
                speed++;
            }
        } else if (direction.equals(Direction.LEFT) && this.direction.equals(Direction.RIGHT)
                || direction.equals(Direction.RIGHT) && this.direction.equals(Direction.LEFT)
                || direction.equals(Direction.UP) && this.direction.equals(Direction.DOWN)
                || direction.equals(Direction.DOWN) && this.direction.equals(Direction.UP)) {

            if (speed > 0) {
                speed--;
            } else {
                revertSnake();
                this.direction = direction;
                speed++;
            }
        } else {
            if (speed == 0) speed++;
            this.direction = direction;
        }

    }

    private void revertSnake() {
        int size = snakeParts.size();
        int last = size;

        System.out.println("Snake starts revertion, head at: " + snakeParts.get(0).x + " " + snakeParts.get(0).y);

        for (int i = 0; i < size; i++) {
            if (i == --last
                    || (i + 1) == last) {
                break;
            }

            GameObject tmp1 = snakeParts.get(i);
            GameObject tmp2 = snakeParts.get(last);

            System.out.println(tmp1.x + " " + tmp1.y + " || " + tmp2.x + " " + tmp2.y);

            snakeParts.set(i, tmp2);
            snakeParts.set(last, tmp1);
        }
        System.out.println("Snake was reverted. Head at: " + snakeParts.get(0).x + " " + snakeParts.get(0).y);
    }

    public void move(Apple apple) {
        System.out.println("Moved to " + this.direction + ", speed: " + speed);
        GameObject newHead = createNewHead();

        if (newHead.x < 0 || newHead.y < 0
                || newHead.x >= SnakeGame.WIDTH || newHead.y >= SnakeGame.HEIGHT) {

            isAlive = false;

            return;
        }

        if (checkCollision(newHead)) {
            System.out.println(newHead.x + " " + newHead.y);
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
