package tictactoe.Moves;

import tictactoe.Board;

public class PlayerType {
    private final Player playerType;

    public PlayerType(Player playerType) {
        this.playerType = playerType;
    }
    public void makeMove(Board board){
        playerType.makeMove(board);
    }

    public static PlayerType getPlayer(String token) {

            if ("easy".equals(token)) {
                return new PlayerType(new EasyAI());
            } else if ("medium".equals(token)) {
                return new PlayerType(new MediumAI());
            } else if("hard".equals(token)) {
                return new PlayerType(new HardAI());
            }
            return new PlayerType(new User());
        }

}
