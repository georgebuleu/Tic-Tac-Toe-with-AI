package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;
import com.uni.oop.GameWindow.GameStatus;
import com.uni.oop.Player.Symbol;

public class MiniMax {
    public static final int DEPTH = 8;


    public static int[] getBestMove(GameBoard board, Symbol symbol) {
        int[] bestMove = new int[2];

        int bestValue = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board.isEmptyGrid(i, j)) {
                    board.setGrid(i, j, Symbol.O);
                    int moveValue = miniMax(board, DEPTH, false, symbol);
                    board.setGrid(i, j, Symbol.EMPTY);
                    if (moveValue > bestValue) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    private static int miniMax(GameBoard board, int depth, boolean isMax, Symbol currentPlayer) {
        int boardValue = evaluateBoard(board, currentPlayer);
        if (Math.abs(boardValue) == 10 || depth == 0 || board.countX() + board.countO() == 9)
            return boardValue;

        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!board.isEmptyGrid(i, j)) {
                        board.setGrid(i, j, Symbol.O );
                        highestVal = Math.max(highestVal, miniMax(board, depth - 1, false, currentPlayer));
                        board.setGrid(i, j, Symbol.EMPTY);
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!board.isEmptyGrid(i, j)) {
                        board.setGrid(i, j, Symbol.X);
                        lowestVal = Math.min(lowestVal, miniMax(board, depth - 1, true, currentPlayer));
                        board.setGrid(i, j, Symbol.EMPTY);
                    }
                }
            }
            return lowestVal;
        }

    }

    private static int evaluateBoard(GameBoard board, Symbol symbol) {
        if (board.checkGameStatus() == GameStatus.OWIN) {
            if (symbol.equals(Symbol.O))
                return 10;
            return -10;
        }

        return 0;
    }


}