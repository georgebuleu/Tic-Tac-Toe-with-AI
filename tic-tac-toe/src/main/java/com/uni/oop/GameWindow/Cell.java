package com.uni.oop.GameWindow;

import com.uni.Player.Symbol;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cell extends JPanel {

    private static final int CELL_WIDTH = 50;
    private static final int CELL_HEIGHT = 50;
    private int row, col;
    private String symbol;
    private GameController controller;

    public Cell(int row, int col, GameController controller) {
        System.out.println("Creating cell...");
        this.row = row;
        this.col = col;
        this.symbol = " ";
        this.controller = controller;

        setBackground(new Color(38, 64, 39));

        setBorder(new LineBorder(Color.BLACK, 2, true));

        setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));

        addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (symbol == " ") {
                        symbol = GameController.getCurrentSymbol().toString();
                        repaint();
                        controller.handleMove(row, col);
                    }
                }
            }
        );
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        repaint();
        controller.handleMove(row, col);
    }

    public void clear() {
        symbol = " ";
        repaint();
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (symbol == Symbol.X.toString() || symbol == Symbol.O.toString()) {
            g2d.setFont(new Font("Arial", Font.BOLD, 100));
            g2d.setColor(Color.BLACK);
            g2d.drawString(
                String.valueOf(symbol),
                getWidth() / 3,
                getHeight() / 2 + 15
            );
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cell other = (Cell) obj;
        return symbol != null
            ? symbol.equals(other.symbol)
            : other.symbol == null;
    }
}
