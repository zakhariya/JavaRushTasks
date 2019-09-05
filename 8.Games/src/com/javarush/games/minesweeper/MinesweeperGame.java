package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;

    @Override
    public void initialize() {

        setScreenSize(SIDE, SIDE);
        showGrid(true);

        createGame();

//        setTurnTimer(1000);

//        stopTurnTimer();

//        showMessageDialog(Color.OLIVE, "test", Color.BEIGE, 14);
    }

    private void createGame() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                boolean mine = getRandomNumber(10) == 0;

                if (mine) {
                    countMinesOnField++;
                }

                gameField[y][x] = new GameObject(x, y, mine);

                setCellColor(x, y, Color.WHITE);
            }
        }
        countFlags = countMinesOnField;

        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> neighbors = new ArrayList<>();

        int x = gameObject.x;
        int y = gameObject.y;

        for (GameObject[] line : gameField) {
            for (GameObject object : line) {
                if ((object.x == x + 1 && object.y == y)
                        || (object.x == x - 1 && object.y == y)
                        || (object.y == y + 1 && object.x == x)
                        || (object.y == y - 1 && object.x == x)
                        || (object.x == x + 1 && object.y == y + 1)
                        || (object.x == x - 1 && object.y == y - 1)
                        || (object.x == x + 1 && object.y == y - 1)
                        || (object.x == x - 1 && object.y == y + 1)
                        || (object.y == y + 1 && object.x == x + 1)
                        || (object.y == y - 1 && object.x == x - 1)) {
                    neighbors.add(object);
                }
            }
        }

        return neighbors;
    }

    private void countMineNeighbors() {
        for (GameObject[] line : gameField) {
            for (GameObject gameObject : line) {
                List<GameObject> neighbors = getNeighbors(gameObject);

                if (gameObject.isMine) {
                    continue;
                }

                for (GameObject neighbor : neighbors) {
                    if (neighbor.isMine) {
                        gameObject.countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (gameObject.isFlag) {
            return;
        }

        gameObject.isOpen = true;

        setCellColor(x, y, gameObject.isMine ? Color.RED : Color.GREEN);

        if (gameObject.isMine) {
            setCellValue(x, y, MINE);
        } else {
            if (gameObject.countMineNeighbors == 0) {
                setCellValue(x, y, "");

                List<GameObject> neighbors = getNeighbors(gameObject);

                for (GameObject neighbor : neighbors) {
                    if (!neighbor.isOpen) {
                        openTile(neighbor.x, neighbor.y);
                    }
                }
            } else {
                setCellNumber(x, y, gameObject.countMineNeighbors);
            }
        }
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (gameObject.isOpen || (countFlags == 0 && !gameObject.isFlag)) {
            return;
        }

        if (!gameObject.isFlag) {
            gameObject.isFlag = true;
            countFlags--;

            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else {
            gameObject.isFlag = false;
            countFlags++;

            setCellValue(x, y, "");
            setCellColor(x, y, Color.WHITE);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    @Override
    public void onTurn(int step) {
//        System.out.println(step);
    }
}
