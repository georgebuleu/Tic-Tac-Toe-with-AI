package com.uni.oop.GameWindow;

import com.uni.oop.Computer.Player;
import com.uni.oop.Computer.PlayerChooser;
import com.uni.oop.Player.PlayerType;
import com.uni.oop.Player.Symbol;
import com.uni.oop.Player.Turn;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GameController {

    private static GameController instance;

    private final GameBoard board;
    private static Symbol currentSymbol;
    private final List<Observer> observers;
    private GameStatus gameStatus = GameStatus.WAITING;
    private PlayerType playerType = PlayerType.EASY_AI;
    private PlayerChooser playerChooser = PlayerChooser.getPlayer(playerType);
    private Turn curentTurn = Turn.PLAYER;
    private int moves = 0;

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Turn getCurentTurn() {
        return curentTurn;
    }

    public void setCurentTurn(Turn curentTurn) {
        this.curentTurn = curentTurn;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
        playerChooser = PlayerChooser.getPlayer(playerType);
        System.out.println("Set player type to:" + playerType );
    }

    private GameController(GameBoard board) {
        System.out.println("Starting GameController...");
        this.board = board;
        currentSymbol = Symbol.X;
        observers = new ArrayList<>();
    }
    public static GameController getInstance(GameBoard board) {
        if (instance == null) {
            instance = new GameController(board);
        }

        return instance;
    }

    public void addObserver(Observer observer) {
        System.out.println(
            "Added a observer: " + observer.getClass().getName()
        );
        observers.add(observer);
    }

    public void notifyObservers() {
        System.out.println("Notyfing " + observers.size() + " observers.");
        for (Observer observer : observers) {
            observer.update(currentSymbol.getSymbol(), gameStatus);
        }
    }

    public static Symbol getCurrentSymbol() {
        return currentSymbol;
    }

    public static void setCurrentSymbol(Symbol symbol) {
        currentSymbol = symbol;
    }

    public void handleMove(int row, int col) {
        if (board.checkWin(row, col)) {
            JOptionPane.showMessageDialog(null, "Player " + currentSymbol + " wins!");
            System.out.println("Player " + currentSymbol + " wins!");
            board.resetBoard();
            setGameStatus(GameStatus.WAITING);
            moves = 0;
        } else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            board.resetBoard();
            setGameStatus(GameStatus.WAITING);
            moves = 0;
        } else {

            currentSymbol = (currentSymbol == Symbol.X) ? Symbol.O : Symbol.X;
            curentTurn = (curentTurn == Turn.PLAYER) ? Turn.RIVAL : Turn.PLAYER;
            System.out.println("Handling the move... Current symbol: " + currentSymbol);

            setGameStatus(GameStatus.RUNNING);
            notifyObservers();

            if (isAITurn()) {
                System.out.println("It's AI's turn...");

                SwingUtilities.invokeLater(() -> {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    playerChooser.makeMove(board);
                    int[] aiMove = board.getLastMove();
                });
            }

        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        notifyObservers();
    }

    private boolean isDraw() {
        return board.countX() + board.countO() == 9;
    }

    public void resetGame() {
        currentSymbol = Symbol.X;
        System.out.println("Resseting the game");
        board.resetBoard();
        setGameStatus(GameStatus.WAITING);
        curentTurn = Turn.PLAYER;
    }

    public boolean isAITurn() {
        System.out.println("isAi palyerType: " + playerType);
        return this.playerType.toString().contains("_AI") && curentTurn == Turn.RIVAL;
    }
}
