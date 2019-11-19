package chess.items;

/** Position class */
public class Position {
    private int x;
    private int y;

    /**
     * Position constructor
     * 
     * @param x - The coordinate on the x - axis
     * @param y - The coordinate on the y - axis
     */
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

    /**
     * Method that tell us if a position is legal
     * 
     * @return boolean - true if the positionn is legal, false in other case
     */
    public boolean isLegal() {
        return (this.x < 8 && this.x > -1 && this.y < 8 && this.y > -1) ? true : false;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Method that verifies if a Position is equal to another
     * 
     * @param obj - The other Position that is going to be compared
     * @return boolean - true in case the 2 Position are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position))
            return false;
        Position p = (Position) obj;
        return (p.getX() == this.getX() && p.getY() == this.getY()) ? true : false;
    }

    /**
     * Method that give us the String representation of a position
     * 
     * @return String - The String representation of a position
     */
    @Override
    public String toString() {
        return "  ||x:" + this.getX() + " y:" + this.getY() + "||";
    }

    /**
     * Method that tell us if a positon is outside of the board
     * 
     * @param board_size - The size of the board
     * @return boolean - true if it is not outside - false in other case
     */
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