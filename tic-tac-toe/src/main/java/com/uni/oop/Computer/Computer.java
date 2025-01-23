package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;

public class Computer {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int[] generateRandomMove(GameBoard board) {
        int[] move = new int[2];
        do {
            move[0] = getRandomNumber(0, 3);
            move[1] = getRandomNumber(0, 3);
        } while (!board.isEmpty(move[0], move[1]));
        return move;
    }
}
