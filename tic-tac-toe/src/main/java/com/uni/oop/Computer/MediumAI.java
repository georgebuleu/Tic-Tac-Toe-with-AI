package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;
import com.uni.oop.GameWindow.GameStatus;
import com.uni.oop.Player.Symbol;

import java.util.Objects;

public class MediumAI extends Computer implements Player {

    public MediumAI() {
    }

    @Override
    public void makeMove(GameBoard board) {
        int[] move = winOrBlock(board);
        System.out.println("Making move level \"medium\"");
        board.setCell(move[0], move[1]);
    }

    public int[] winOrBlock(GameBoard board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isEmpty(i, j)) {
                    board.setGrid(i, j, Symbol.O);
                    if (board.checkGameStatus() == GameStatus.OWIN) {
                        return new int[]{i, j};
                    } else {
                        board.setGrid(i, j, Symbol.X);
                        if (board.checkGameStatus() == GameStatus.XWIN) {
                            return new int[]{i, j};
                        }
                        board.setGrid(i, j, Symbol.EMPTY);
                    }

                }
            }
        }
        return super.generateRandomMove(board);
    }
}
