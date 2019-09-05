package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

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

        gameObject.isOpen = true;

        if (gameObject.isMine == true) {
            setCellValue(x, y, MINE);
            setCellColor(x, y, Color.RED);
        } else {
            setCellValue(x, y, String.valueOf(gameObject.countMineNeighbors));
            setCellColor(x, y, Color.GREEN);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {

    }

    @Override
    public void onTurn(int step) {
//        System.out.println(step);
    }
}
