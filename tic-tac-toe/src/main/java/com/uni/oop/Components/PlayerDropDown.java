package com.uni.oop.Components;

import com.uni.oop.Computer.Player;
import com.uni.oop.Player.PlayerType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComboBox;

public class PlayerDropDown extends JComboBox<PlayerType> {

    public PlayerDropDown() {
        super(PlayerType.values());
        setPreferredSize(new Dimension(300, 50));
        setMaximumSize(new Dimension(300, 100));
        setFont(new Font("Arial", Font.BOLD, 20));
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

    public void setEnabled(boolean isEnabled) {
        this.setEnabled(isEnabled);
    }

    public PlayerType getValue() {
        System.out.println((PlayerType) this.getSelectedItem());
        return (PlayerType) this.getSelectedItem();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );
    }
}
