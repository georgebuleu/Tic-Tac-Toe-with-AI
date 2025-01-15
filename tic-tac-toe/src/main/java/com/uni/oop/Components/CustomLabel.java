package com.uni.oop.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class CustomLabel extends JLabel {

    public CustomLabel(String text) {
        super(text);
        //this.setPreferredSize(new Dimension(150, 50));
        //this.setMaximumSize(new Dimension(150, 100));
        this.setFont(new Font("Arial", Font.BOLD, 30));
        this.setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER); // Center text horizontally
        setVerticalAlignment(CENTER);
    }

    public CustomLabel(String text, int fontSize) {
        super(text);
        this.setPreferredSize(new Dimension(150, 50));
        this.setMaximumSize(new Dimension(150, 100));
        this.setFont(new Font("Arial", Font.BOLD, fontSize));
        this.setForeground(Color.WHITE);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        preferredSize.width = Math.max(200, preferredSize.width);
        return preferredSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );
        setBackground(Color.WHITE);

        super.paintComponent(g2d);
    }
}
