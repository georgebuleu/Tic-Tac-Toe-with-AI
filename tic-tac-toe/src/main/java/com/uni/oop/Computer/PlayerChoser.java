package com.uni.oop.Computer;

import com.uni.oop.GameWindow.GameBoard;

public class PlayerChoser {

    private final Player player;

    public PlayerChoser(Player player) {
        this.player = player;
    }

    public void makeMove(GameBoard board) {
        player.makeMove(board);
    }

    public static PlayerChoser getPlayer(String token) {
        if ("easy".equals(token)) {
            return new PlayerChoser(new EasyAI());
        } else if ("medium".equals(token)) {
            return new PlayerChoser(new MediumAI());
        } else if ("hard".equals(token)) {
            return new PlayerChoser(new HardAI());
        }
        return new PlayerChoser(new Human());
    }
}
