package chess.items;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    public boolean isLegal() {
        return (this.x < 8 && this.x >= 0 && this.y < 8 && this.y >= -0);
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position))
            return false;
        Position p = (Position) obj;
        return (p.getX() == this.getX() && p.getY() == this.getY()) ? true : false;
    }

    @Override
    public String toString() {
        return "  ||x:" + this.getX() + " y:" + this.getY() + "||";
    }

    public boolean isOutOfBoard(int board_size) {
        if (this.y >= board_size)
            return false;
        if (this.x >= board_size)
            return false;
        if (this.y < 0)
            return false;
        if (this.x < 0)
            return false;
        return true;
    }
}