package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;
import com.uni.oop.Player.Symbol;

public class EasyAI extends Computer implements Player {

    public EasyAI() {}

    @Override
    public void makeMove(GameBoard board) {
        int[] move = super.generateRandomMove(board);
        System.out.println("Making move level \"easy\":( " + move[0] + ", " + move[1] + " )");
        board.setCell(move[0], move[1]);
    }
}
