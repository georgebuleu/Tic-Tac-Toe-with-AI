package com.uni.oop.GameWindow;

import com.uni.Player.Symbol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GameController {

    private GameBoard board;
    private static Symbol currentSymbol;
    private List<Observer> observers;

    public GameController(GameBoard board) {
        System.out.println("Starting GameController...");
        this.board = board;
        currentSymbol = Symbol.X;
        observers = new ArrayList<>();
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
            observer.update(currentSymbol.getSymbol());
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
            JOptionPane.showMessageDialog(
                null,
                "Player " + currentSymbol + " wins!"
            );
            System.out.println("Player " + currentSymbol + " wins!");
            board.resetBoard();
        } else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            board.resetBoard();
        } else {
            currentSymbol = (currentSymbol == Symbol.X) ? Symbol.O : Symbol.X;
            System.out.println(
                "Handling the move... Current symbol: " + currentSymbol
            );
            notifyObservers();
        }
    }

    private boolean isDraw() {
        return false;
    }

    public void resetGame() {
        currentSymbol = Symbol.X;
        System.out.println("Resseting the game");
        notifyObservers();
    }
}
