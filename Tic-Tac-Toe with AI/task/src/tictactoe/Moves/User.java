package tictactoe.Moves;

import tictactoe.Board;
import tictactoe.Coordinates;
import tictactoe.Moves.Player;

import java.util.Scanner;

public class User implements Player {

    private final Scanner scanner = new Scanner(System.in);

    public User(){}


    @Override
    public void makeMove(Board board) {
        Coordinates coordinates = readCoordinates(board);
        board.setValue(coordinates.getX(), coordinates.getY(), board.playerTurn());
    }

    public Coordinates readCoordinates(Board board) {
        System.out.print("Enter the coordinates: ");
        String[] input = scanner.nextLine().trim().split(" ");
        while (!validateCoordinates(input, board)) {
            System.out.print("Enter the coordinates: ");
            input = scanner.nextLine().trim().split(" ");
        }
        return new Coordinates(Integer.parseInt(input[0]) , Integer.parseInt(input[1]));

    }

    public boolean validateCoordinates(String[] input, Board board) {

        if (input.length < 2) {
            System.out.println("You should enter numbers!");
            return false;
        }
        String x = input[0];
        String y = input[1];
        try {
            Integer.parseInt(x);
            Integer.parseInt(y);
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (Integer.parseInt(x) > 3 || Integer.parseInt(x) < 1 ||
                Integer.parseInt(y) > 3 || Integer.parseInt(y) < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        //if (!" ".equals(board[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1]))
        if(!" ".equals(board.getValue(Integer.parseInt(x) - 1, Integer.parseInt(y) - 1))) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

}
