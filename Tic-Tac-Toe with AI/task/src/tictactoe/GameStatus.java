package tictactoe;

public enum GameStatus {

    XWIN("X"),
    OWIN("O"),
    DRAW("DRAW"),
    RUNNING("Game not finished");

    private final String status;
    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
