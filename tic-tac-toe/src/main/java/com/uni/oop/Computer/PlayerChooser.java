package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;
import com.uni.oop.Player.PlayerType;

public class PlayerChooser {

    private final Player player;

    public PlayerChooser(Player player) {
        this.player = player;
    }

    public void makeMove(GameBoard board) {
        player.makeMove(board);
    }

    public static PlayerChooser getPlayer(PlayerType playerType) {
        switch (playerType){
            case MEDIUM_AI:
                System.out.println("Created a new Medium AI");
                return new PlayerChooser(new MediumAI());
            case HARD_AI:
                System.out.println("Created a new Hard AI");
                return new PlayerChooser(new HardAI());
            case HUMAN:
                System.out.println("Created a new Human");
                return new PlayerChooser(new Human());
            default:
                System.out.println("Creating a new EasyAI");
                return new PlayerChooser(new EasyAI());

        }
    }
}
