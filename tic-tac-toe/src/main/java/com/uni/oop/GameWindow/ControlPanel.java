package com.uni.oop.GameWindow;

import com.uni.oop.Components.CustomButton;
import com.uni.oop.Components.CustomLabel;
import com.uni.oop.Components.PlayerDropDown;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ControlPanel extends JPanel implements Observer {

    private CustomButton restartButton = new CustomButton("Restart");
    private CustomButton quitButton = new CustomButton("Quit Game");
    private PlayerDropDown playerDropDown = new PlayerDropDown();

    private JLabel symbolMessageLabel = new CustomLabel("CURRENT PLAYER:");
    private JLabel currentTurnLabel = new CustomLabel(
        GameController.getCurrentSymbol().getSymbol()
    );

    public ControlPanel(GameBoard gameboard) {
        System.out.println("Creating ControlPanel");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(13, 31, 34));

        setPreferredSize(new Dimension(500, getHeight()));

        symbolMessageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentTurnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentTurnLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerDropDown.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());

        add(symbolMessageLabel);
        add(Box.createVerticalStrut(40));
        add(currentTurnLabel);
        add(Box.createVerticalStrut(120));
        add(playerDropDown);
        add(Box.createVerticalStrut(20));
        add(restartButton);
        add(Box.createVerticalStrut(20));
        add(quitButton);

        add(Box.createVerticalGlue());

        gameboard.getController().addObserver(this);

        restartButton.addActionListener(l -> gameboard.resetBoard());
        quitButton.addActionListener(l -> System.exit(0));
    }

    public void update(String eventType) {
        System.out.println(
            "Current symbol: " + GameController.getCurrentSymbol()
        );

        currentTurnLabel.setText(eventType);

        repaint();
    }
}
