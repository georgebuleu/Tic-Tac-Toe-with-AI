package com.uni.oop.GameWindow;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;

    private final GameBoard gameBoard;
    private final ControlPanel controlPanel;

    public GameWindow() {
        setTitle("Tic-Tac-Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameBoard = new GameBoard();
        controlPanel = new ControlPanel(gameBoard);

        add(gameBoard, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);

        setVisible(true);
    }
}
