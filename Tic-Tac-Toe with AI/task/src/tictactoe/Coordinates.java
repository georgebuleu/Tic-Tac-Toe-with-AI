package tictactoe;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates() {}

    public Coordinates(int x, int y) {
        this.x = x - 1;
        this.y = y - 1;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x - 1;
    }

    public void setY(int y) {
        this.y = y - 1;
    }

    public int getY() {
        return y;
    }
}
