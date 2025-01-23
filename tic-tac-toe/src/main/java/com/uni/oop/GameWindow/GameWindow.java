package com.uni.oop.GameWindow;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;

    public GameWindow() {
        setTitle("Tic-Tac-Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GameBoard gameBoard = new GameBoard();
        GameController gameController = GameController.getInstance(gameBoard);
        ControlPanel controlPanel = new ControlPanel(gameBoard, gameController);

        add(gameBoard, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);

        setVisible(true);
    }
}
