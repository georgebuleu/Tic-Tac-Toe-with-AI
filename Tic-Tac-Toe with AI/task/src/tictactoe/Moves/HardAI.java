package tictactoe.Moves;

import tictactoe.Board;
import tictactoe.Coordinates;
import tictactoe.MiniMax;

public class HardAI extends Computer implements Player{
    @Override
    public void makeMove(Board board) {

        Coordinates coordinates = MiniMax.getBestMove(board, board.playerTurn());
        System.out.println("Making move level \"Hard\"");
        board.setValue(coordinates.getX() , coordinates.getY() , board.playerTurn());
    }
}
