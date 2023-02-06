package tictactoe.Moves;

import tictactoe.Board;
import tictactoe.Coordinates;
import tictactoe.GameStatus;
import tictactoe.Moves.Computer;
import tictactoe.Moves.Player;

import java.util.Objects;

public class MediumAI extends Computer implements Player {
 

    public MediumAI(){}

    @Override
    public void makeMove(Board board) {
        Coordinates coordinates = winOrBlock(board);
        System.out.println("Making move level \"medium\"");
        board.setValue(coordinates.getX(),coordinates.getY(), board.playerTurn());
    }

    public Coordinates winOrBlock(Board board) {
        for(int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if(Objects.equals(board.getValue(i, j), " ")) {
                    board.setValue(i,j, board.playerTurn());
                    if (Objects.equals(GameStatus.XWIN.getStatus(), board.playerTurn()) && board.checkGameStatus() == GameStatus.XWIN ) {
                        return new Coordinates(i + 1, j + 1);
                    } else
                    {
                        board.setValue(i,j, " ");
                    }
                    if (Objects.equals(GameStatus.OWIN.getStatus(), board.playerTurn()) && board.checkGameStatus() == GameStatus.OWIN ) {
                        return new Coordinates(i + 1, j + 1);
                    } else {
                        board.setValue(i,j, " ");
                    }
                    if(GameStatus.XWIN.getStatus().equals(board.playerTurn())) {
                        board.setValue(i,j, GameStatus.OWIN.getStatus());
                        if(board.checkGameStatus().equals(GameStatus.OWIN)) {
                            return new Coordinates(i + 1, j + 1);
                        } else {
                            board.setValue(i,j, " ");
                        }
                    }
                    if(GameStatus.OWIN.getStatus().equals(board.playerTurn())) {
                        board.setValue(i, j, GameStatus.XWIN.getStatus());
                        if (board.checkGameStatus().equals(GameStatus.XWIN)) {
                            return new Coordinates(i + 1 , j + 1);
                        } else {
                            board.setValue(i,j, " ");
                        }
                    }
                }
            }
        }
        return super.generateRandomMove(board);


    }


}
