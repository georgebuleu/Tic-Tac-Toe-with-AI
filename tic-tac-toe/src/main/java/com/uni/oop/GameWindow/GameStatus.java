package com.uni.oop.GameWindow;

public enum GameStatus {
    XWIN("X"),
    OWIN("O"),
    DRAW("DRAW"),
    RUNNING("Game not finished"),
    WAITING("No game running");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
