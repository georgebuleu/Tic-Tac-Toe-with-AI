package tictactoe;




import tictactoe.Moves.PlayerType;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Board board = new Board();


    public static boolean validateInput(String[] inputTokens) {


        if (inputTokens.length == 1 && !Objects.equals(inputTokens[0], "exit") || inputTokens.length == 2) {
            System.out.println("Bad parameters!");
            return false;
        }
        if (inputTokens.length == 1 && inputTokens[0].equals("exit")) {
            return true;
        }
        if (inputTokens.length == 3 && "start".equals(inputTokens[0])) {
            return true;
        }
        System.out.println("Bad parameters!");
        return false;

    }
    public static String[] readInput() {
        String input;
        String[] inputTokens;
       do {
           System.out.print("Input command:");
           input = scanner.nextLine();
           inputTokens = input.trim().split(" ");

       }while (!validateInput(inputTokens));

       return inputTokens;
    }




    public static void main(String[] args) {
        String[] inputTokens = readInput();

        while (validateInput(inputTokens)) {
            boolean isWon = false;
            if (inputTokens.length == 1 && inputTokens[inputTokens.length - 1].equals("exit")) {
                break;
            }
            PlayerType[] players = {PlayerType.getPlayer(inputTokens[1]),PlayerType.getPlayer(inputTokens[2])};
            board.setEmptyBoard();
            board.display();
            while (!isWon) {
                for (PlayerType player : players) {
                    player.makeMove(board);
                    board.display();
                    if (board.isFinished()) {
                        isWon = true;
                        break;
                    }
                }

            }
            inputTokens = readInput();
        }
    }
    }


