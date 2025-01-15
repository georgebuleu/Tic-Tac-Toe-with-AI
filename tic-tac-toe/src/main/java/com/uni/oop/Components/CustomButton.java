package com.uni.oop.Components;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        this.setPreferredSize(new Dimension(150, 50));
        this.setMaximumSize(new Dimension(300, 100));
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );

        super.paintComponent(g2d);
    }
}
