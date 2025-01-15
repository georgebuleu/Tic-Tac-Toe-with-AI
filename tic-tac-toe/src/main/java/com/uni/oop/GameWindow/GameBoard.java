package com.uni.oop.GameWindow;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

    private static final int BOARD_SIZE = 3;
    private Cell[][] cells;
    private GameController controller;

    public GameBoard() {
        System.out.println("Creating Gameboard...");
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        controller = new GameController(this);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                cells[row][col] = new Cell(row, col, controller);
                add(cells[row][col]);
            }
        }
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col].getSymbol() == " ";
    }

    public GameController getController() {
        return controller;
    }

    public void resetBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                cells[row][col].clear();
            }
        }
        controller.resetGame();
    }

    public void setCell(int row, int col) {
        this.cells[row][col].setSymbol(
                GameController.getCurrentSymbol().getSymbol()
            );
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int countX() {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ("X".equals(cells[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countO() {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ("O".equals(cells[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkWin(int row, int col) {
        System.out.println("Checkign win");
        System.out.println(cells[0][0]);
        for (int i = 0; i < 3; i++) {
            if (
                cells[i][0].equals(cells[i][1]) &&
                cells[i][1].equals(cells[i][2]) &&
                cells[i][2].equals(cells[row][col])
            ) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (
                cells[0][i].equals(cells[1][i]) &&
                cells[1][i].equals(cells[2][i]) &&
                cells[2][i].equals(cells[row][col])
            ) {
                return true;
            }
        }

        return (
            (cells[0][0].equals(cells[1][1]) &&
                cells[1][1].equals(cells[2][2]) &&
                cells[2][2].equals(cells[row][col])) ||
            (cells[2][0].equals(cells[1][1]) &&
                cells[1][1].equals(cells[0][2]) &&
                cells[0][2].equals(cells[row][col]))
        );
    }

    public GameStatus checkGameStatus() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (
                cells[i][0].getSymbol().charAt(0) +
                    cells[i][1].getSymbol().charAt(0) +
                    cells[i][2].getSymbol().charAt(0) ==
                264
            ) return GameStatus.XWIN;
            if (
                cells[0][i].getSymbol().charAt(0) +
                    cells[1][i].getSymbol().charAt(0) +
                    cells[2][i].getSymbol().charAt(0) ==
                264
            ) return GameStatus.XWIN;

            if (
                cells[i][0].getSymbol().charAt(0) +
                    cells[i][1].getSymbol().charAt(0) +
                    cells[i][2].getSymbol().charAt(0) ==
                237
            ) return GameStatus.OWIN;
            if (
                cells[0][i].getSymbol().charAt(0) +
                    cells[1][i].getSymbol().charAt(0) +
                    cells[2][i].getSymbol().charAt(0) ==
                237
            ) return GameStatus.OWIN;

            if (
                cells[0][0].getSymbol().charAt(0) +
                        cells[1][1].getSymbol().charAt(0) +
                        cells[2][2].getSymbol().charAt(0) ==
                    264 ||
                cells[0][2].getSymbol().charAt(0) +
                cells[1][1].getSymbol().charAt(0) +
                cells[2][0].getSymbol().charAt(0) ==
                264
            ) {
                return GameStatus.XWIN;
            }
            if (
                cells[0][0].getSymbol().charAt(0) +
                        cells[1][1].getSymbol().charAt(0) +
                        cells[2][2].getSymbol().charAt(0) ==
                    237 ||
                cells[0][2].getSymbol().charAt(0) +
                cells[1][1].getSymbol().charAt(0) +
                cells[2][0].getSymbol().charAt(0) ==
                237
            ) {
                return GameStatus.OWIN;
            }
        }
        if (
            countO() + countX() == BOARD_SIZE * BOARD_SIZE
        ) return GameStatus.DRAW;
        return GameStatus.RUNNING;
    }
}
