package tictactoe;

public class MiniMax {
    public static final int DEPTH = 8;


    public static Coordinates getBestMove(Board board, String currentPlayer) {
        Coordinates bestMove = new Coordinates();

        int bestValue = Integer.MIN_VALUE;
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (!board.isTileUsed(i, j)) {
                    board.setValue(i, j, currentPlayer);
                    int moveValue = miniMax(board, DEPTH, false, currentPlayer);
                    board.setValue(i, j, " ");
                    if (moveValue > bestValue) {
                        bestMove.setX(i + 1);
                        bestMove.setY(j + 1);
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    private static int miniMax(Board board, int depth, boolean isMax, String currentPlayer) {
        int boardValue = evaluateBoard(board, currentPlayer);
        if (Math.abs(boardValue) == 10 || depth == 0 || board.countX() + board.countO() == 9)
            return boardValue;

        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int i = 0; i < board.getBoardSize(); i++) {
                for (int j = 0; j < board.getBoardSize(); j++) {
                    if (!board.isTileUsed(i, j)) {
                        board.setValue(i, j, currentPlayer);
                        highestVal = Math.max(highestVal, miniMax(board, depth - 1, false, currentPlayer));
                        board.setValue(i, j, " ");
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int i = 0; i < board.getBoardSize(); i++) {
                for (int j = 0; j < board.getBoardSize(); j++) {
                    if (!board.isTileUsed(i, j)) {
                        board.setValue(i, j, getOpponent(currentPlayer));
                        lowestVal = Math.min(lowestVal, miniMax(board, depth - 1, true, currentPlayer));
                        board.setValue(i, j, " ");
                    }
                }
            }
            return lowestVal;
        }

    }

    private static int evaluateBoard(Board board, String currentPlayer) {
        if (board.checkGameStatus() == GameStatus.XWIN) {
            if (currentPlayer.equals("X"))
                return 10;
            return -10;
        }
        if (board.checkGameStatus() == GameStatus.OWIN) {
            if (currentPlayer.equals("O"))
                return 10;
            return -10;
        }

        return 0;
    }

    private static String getOpponent(String currentPlayer) {
        return currentPlayer.equals("X") ? "O" : "X";
    }

}
