package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;
import com.uni.oop.Player.Symbol;

public class HardAI implements Player {

    @Override
    public void makeMove(GameBoard board) {

        int[] move = MiniMax.getBestMove(board, Symbol.O);
        System.out.println("Making move level \"Hard\"");
        board.setCell(move[0], move[1]);

    }
}
