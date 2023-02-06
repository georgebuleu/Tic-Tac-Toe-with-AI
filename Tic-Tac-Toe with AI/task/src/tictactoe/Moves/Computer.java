package tictactoe.Moves;

import tictactoe.Board;
import tictactoe.Coordinates;

public class Computer  {


    public Computer() {
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public Coordinates generateRandomMove(Board board) {
        Coordinates coordinates = new Coordinates();
        do {
            coordinates.setX(getRandomNumber(1, 4));
            coordinates.setY(getRandomNumber(1, 4));
        } while (!" ".equals(board.getValue(coordinates.getX(), coordinates.getY())));
        return coordinates;
    }



}
