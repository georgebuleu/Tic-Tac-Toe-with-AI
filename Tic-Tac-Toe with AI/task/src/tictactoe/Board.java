package tictactoe;


public class Board {
    private final static int BOARD_SIZE = 3;
    private final String[][] board = new String[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        setEmptyBoard();
    }

    public void setEmptyBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = " ";
            }
        }
    }
    public boolean isBoardEmpty() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
               return board[i][j].equals(" ");
            }
        }
        return false;
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public void setValue(int x, int y, String val) {
                board[x][y] = val;
    }

    public String getValue(int x, int y) {
        return board[x][y];
    }


    public void display() {
        for (int w = 0; w < BOARD_SIZE * 3; w++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int w = 0; w < BOARD_SIZE * 3; w++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public boolean isTileUsed(int x, int y) {
        return "O".equals(board[x][y]) || "X".equals(board[x][y]);
    }

    public String playerTurn() {
        if (countX() <= countO())
            return "X";
        return "O";

    }
    public String getOpponent(){
        if (countX() <= countO())
            return "O";
        return "X";
    }

    public int countX() {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ("X".equals(board[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countO() {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ("O".equals(board[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public GameStatus checkGameStatus() {

        for(int i = 0; i < BOARD_SIZE;i++) {
            if(board[i][0].charAt(0) + board[i][1].charAt(0) +board[i][2].charAt(0) == 264)
                return GameStatus.XWIN;
            if(board[0][i].charAt(0) + board[1][i].charAt(0) +board[2][i].charAt(0) == 264)
                return GameStatus.XWIN;

            if(board[i][0].charAt(0) + board[i][1].charAt(0) +board[i][2].charAt(0) == 237)
                return GameStatus.OWIN;
            if(board[0][i].charAt(0) + board[1][i].charAt(0) +board[2][i].charAt(0) == 237)
                return GameStatus.OWIN;

            if (board[0][0].charAt(0) + board[1][1].charAt(0) + board[2][2].charAt(0) == 264
                    || board[0][2].charAt(0) + board[1][1].charAt(0) + board[2][0].charAt(0) == 264) {
                return GameStatus.XWIN;
            }
            if (board[0][0].charAt(0) + board[1][1].charAt(0) + board[2][2].charAt(0) == 237
                    || board[0][2].charAt(0) + board[1][1].charAt(0) + board[2][0].charAt(0) == 237) {
                return GameStatus.OWIN;
            }


        }
        if (countO() + countX() == BOARD_SIZE * BOARD_SIZE)
            return GameStatus.DRAW;
        return GameStatus.RUNNING;
    }

    public boolean isFinished() {
        if (checkGameStatus().equals(GameStatus.XWIN)) {
            System.out.println(GameStatus.XWIN.getStatus() + " wins");
            return true;
        } else if (checkGameStatus().equals(GameStatus.OWIN)) {
            System.out.println(GameStatus.OWIN.getStatus() + " wins");
            return true;
        } else if (checkGameStatus().equals(GameStatus.DRAW)) {
            System.out.println(GameStatus.DRAW.getStatus());
            return true;
        }
        return false;
    }


}
