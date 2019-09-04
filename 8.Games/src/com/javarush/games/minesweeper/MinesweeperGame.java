package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {

        setScreenSize(SIDE, SIDE);
        showGrid(true);

        createGame();

        setTurnTimer(1000);

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
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        setCellValue(x, y, "X");
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        super.onMouseRightClick(x, y);
    }

    @Override
    public void onTurn(int step) {
        System.out.println(step);
    }
}
