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
    private Game game;

    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
        snakeParts.add(new GameObject(x + 3, y));
        snakeParts.add(new GameObject(x + 4, y));
    }

    public void draw(Game game) {
        this.game = game;

        int size = snakeParts.size();

        for (int i = 0; i < size; i++) {
            int x = snakeParts.get(i).x;
            int y = snakeParts.get(i).y;

            if (i == 0) {
                game.setCellValueEx(x, y, Color.NONE, HEAD_SIGN, isAlive ? Color.BLUE : Color.RED, 75);
            } else if (i == size - 1) {
                game.setCellValueEx(x, y, Color.NONE, HEAD_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
            } else {
                game.setCellValueEx(x, y, Color.NONE, BODY_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
            }
        }
    }

//    public void setDirection(Direction direction) {
//        boolean horizontal = (this.direction.equals(Direction.LEFT) || this.direction.equals(Direction.RIGHT))
//                && snakeParts.get(0).x == snakeParts.get(1).x;
//
//        boolean vertical = (this.direction.equals(Direction.UP) || this.direction.equals(Direction.DOWN))
//                && snakeParts.get(0).y == snakeParts.get(1).y;
//
//        if (horizontal || vertical) {
//            return;
//        }
//
//        horizontal = (direction.equals(Direction.LEFT) && this.direction.equals(Direction.RIGHT))
//                || (direction.equals(Direction.RIGHT) && this.direction.equals(Direction.LEFT));
//        vertical = (direction.equals(Direction.UP) && this.direction.equals(Direction.DOWN))
//                || (direction.equals(Direction.DOWN) && this.direction.equals(Direction.UP));
//
//        if (horizontal || vertical) {
//            return;
//        }
//
//        this.direction = direction;
//    }

    public void setDirection(Direction direction) {
        boolean acceleration =
                direction.equals(Direction.LEFT) && this.direction.equals(Direction.LEFT)
                || direction.equals(Direction.RIGHT) && this.direction.equals(Direction.RIGHT)
                || direction.equals(Direction.UP) && this.direction.equals(Direction.UP)
                || direction.equals(Direction.DOWN) && this.direction.equals(Direction.DOWN);

        boolean braking =
                direction.equals(Direction.LEFT) && this.direction.equals(Direction.RIGHT)
                || direction.equals(Direction.RIGHT) && this.direction.equals(Direction.LEFT)
                || direction.equals(Direction.UP) && this.direction.equals(Direction.DOWN)
                || direction.equals(Direction.DOWN) && this.direction.equals(Direction.UP);

        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;

        int neckX = snakeParts.get(1).x;
        int neckY = snakeParts.get(1).y;

        boolean horizontalCollision = (direction.equals(Direction.LEFT) && headX > neckX
                || direction.equals(Direction.RIGHT) && headX < neckX) && headY == neckY;

        boolean verticalCollision = (direction.equals(Direction.UP) && headY > neckY
                || direction.equals(Direction.DOWN) && headY < neckY) && headX == neckX;

        if (acceleration && speed < 6) {
            speed++;
        } else if (braking && speed > 0) {
            speed--;
        } else if(braking && speed == 0) {
            revert();
            this.direction = direction;
        } else if (speed == 0) {
                speed++;
        }

        if (!horizontalCollision && !verticalCollision) {
            this.direction = direction;
        }
    }

    public void revert() {
        int size = snakeParts.size();
        int last = size;

        for (int i = 0; i < size; i++) {
            if (i == --last
                    || (i + 1) == last) {
                break;
            }

            GameObject tmp1 = snakeParts.get(i);
            GameObject tmp2 = snakeParts.get(last);

            snakeParts.set(i, tmp2);
            snakeParts.set(last, tmp1);
        }

        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;

        int neckX = snakeParts.get(1).x;
        int neckY = snakeParts.get(1).y;

        boolean horizontalDirectionLeft = headY == neckY && headX > neckX;
        boolean horizontalDirectionRight = headY == neckY && headX < neckX;
        boolean verticalDirectionUp = headX == neckX && headY > neckY;
        boolean verticalDirectionDown = headX == neckX && headY < neckY;

        boolean horizontalLeftWall = headX + 1 < 0;
        boolean horizontalRightWall = headX + 1 >= SnakeGame.WIDTH;
        boolean verticalUpWall = headY + 1 < 0;
        boolean verticalDownWall = headY + 1 >= SnakeGame.HEIGHT;

        if (horizontalDirectionLeft) {
            if (!horizontalLeftWall) {
                this.direction = Direction.LEFT;
            } else if (!verticalUpWall) {
                this.direction = Direction.UP;
            } else {
                this.direction = Direction.DOWN;
            }
        } else if (horizontalDirectionRight) {
            if (!horizontalRightWall) {
                this.direction = Direction.LEFT;
            } else if (!verticalUpWall) {
                this.direction = Direction.UP;
            } else {
                this.direction = Direction.DOWN;
            }
        } else if (verticalDirectionUp) {
            if (!verticalUpWall) {
                this.direction = Direction.UP;
            } else if (!horizontalLeftWall) {
                this.direction = Direction.LEFT;
            } else {
                this.direction = Direction.RIGHT;
            }
        } else if (verticalDirectionDown) {
            if (!verticalDownWall) {
                this.direction = Direction.DOWN;
            } else if (!horizontalLeftWall) {
                this.direction = Direction.LEFT;
            } else {
                this.direction = Direction.RIGHT;
            }
        }

//        if (this.direction.equals(Direction.LEFT)) {
//            this.direction = Direction.RIGHT;
//        } else if (this.direction.equals(Direction.RIGHT)) {
//            this.direction = Direction.LEFT;
//        } else if (this.direction.equals(Direction.DOWN)) {
//            this.direction = Direction.UP;
//        } else if (this.direction.equals(Direction.UP)){
//            this.direction = Direction.DOWN;
//        }

        draw(game);
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
