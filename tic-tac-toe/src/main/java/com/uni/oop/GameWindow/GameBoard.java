package com.uni.oop.GameWindow;

import com.uni.oop.Player.Symbol;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

    private static final int BOARD_SIZE = 3;
    private Cell[][] cells;
    private Symbol[][] grid = new Symbol[BOARD_SIZE][BOARD_SIZE];
    private GameController controller;
    private int[] lastMove = new int[2];

    public GameBoard() {
        System.out.println("Creating Gameboard...");
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        controller = GameController.getInstance (this);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                cells[row][col] = new Cell(row, col, controller);
                add(cells[row][col]);
                grid[row][col] = Symbol.EMPTY;
            }
        }
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col].isEmpty();
    }

    public boolean isEmptyGrid(int row, int col) {
        return grid[row][col] == Symbol.EMPTY;
    }

    public GameController getController() {
        return controller;
    }

    public void resetBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                cells[row][col].clear();
                grid[row][col] = Symbol.EMPTY;
            }
        }
        repaint();
        GameController.setCurrentSymbol(Symbol.X);
    }

    public void setCell(int row, int col) {
        this.cells[row][col].setSymbol(
                GameController.getCurrentSymbol()
            );
       this.refreshGrid();
        //repaint();
        System.out.println("Symbol was set by AI");
    }

    private void refreshGrid() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                grid[row][col] = this.cells[row][col].getSymbol();
            }
        }
    }

    public int[] getLastMove() {
        return lastMove;
    }

    public Cell[][] getCells() {
        return cells;
    }
    public Symbol[][] getGrid() {
        return grid;
    }

    public void setGrid(int row, int col, Symbol symbol) {
        grid[row][col] = symbol;
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
                cells[i][0].getSymbol().toString().charAt(0) +
                    cells[i][1].getSymbol().toString().charAt(0) +
                    cells[i][2].getSymbol().toString().charAt(0) ==
                264
            ) return GameStatus.XWIN;
            if (
                cells[0][i].getSymbol().toString().charAt(0) +
                    cells[1][i].getSymbol().toString().charAt(0) +
                    cells[2][i].getSymbol().toString().charAt(0) ==
                264
            ) return GameStatus.XWIN;

            if (
                cells[i][0].getSymbol().toString().charAt(0) +
                    cells[i][1].getSymbol().toString().charAt(0) +
                    cells[i][2].getSymbol().toString().charAt(0) ==
                237
            ) return GameStatus.OWIN;
            if (
                cells[0][i].getSymbol().toString().charAt(0) +
                    cells[1][i].getSymbol().toString().charAt(0) +
                    cells[2][i].getSymbol().toString().charAt(0) ==
                237
            ) return GameStatus.OWIN;

            if (
                cells[0][0].getSymbol().toString().charAt(0) +
                        cells[1][1].getSymbol().toString().charAt(0) +
                        cells[2][2].getSymbol().toString().charAt(0) ==
                    264 ||
                cells[0][2].getSymbol().toString().charAt(0) +
                cells[1][1].getSymbol().toString().charAt(0) +
                cells[2][0].getSymbol().toString().charAt(0) ==
                264
            ) {
                return GameStatus.XWIN;
            }
            if (
                cells[0][0].getSymbol().toString().charAt(0) +
                        cells[1][1].getSymbol().toString().charAt(0) +
                        cells[2][2].getSymbol().toString().charAt(0) ==
                    237 ||
                cells[0][2].getSymbol().toString().charAt(0) +
                cells[1][1].getSymbol().toString().charAt(0) +
                cells[2][0].getSymbol().toString().charAt(0) ==
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

    public void setCellEmpty(int row, int col) {
        this.cells[row][col].setSymbol(Symbol.EMPTY);
    }
}
