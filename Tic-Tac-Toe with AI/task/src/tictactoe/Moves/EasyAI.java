package tictactoe.Moves;


import tictactoe.Board;
import tictactoe.Coordinates;

public class EasyAI extends Computer implements Player {

    @Override
    public void makeMove(Board board) {
        Coordinates coordinates = super.generateRandomMove(board);
        System.out.println("Making move level \"easy\"");
        board.setValue(coordinates.getX(), coordinates.getY(), board.playerTurn());
    }

    public EasyAI(){}


}
