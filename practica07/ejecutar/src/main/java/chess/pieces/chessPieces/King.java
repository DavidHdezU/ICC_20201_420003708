package chess.pieces.chessPieces;

import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * Queem class that extends Rook class
 */
public class King extends Pawn {
    /**
     * Queen constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color the piece has
     */
    public King(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.QUEEN;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    public LinkedList<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            List<Position> legalMoveList = super.getLegalMoves();
            for (int i = this.position.getX() - 1; i > this.position.getX() - 2; i--) {
                this.legalMoves.add(new Position(this.position.getX(), i));
            }
            for (int i = this.position.getX() + 1; i < this.position.getX() + 2; i++) {
                this.legalMoves.add(new Position(i, this.position.getY() + 1));
            }
            for (int i = this.position.getX() + 1; i < this.position.getX() + 2; i++) {
                this.legalMoves.add(new Position(i, this.position.getY() - 1));
            }
            for (int i = this.position.getY() - 1; i > this.position.getY() - 2; i--) {
                this.legalMoves.add(new Position(this.position.getX() - 1, i));
            }
            for (int i = this.position.getY() + 1; i < this.position.getY() + 2; i++) {
                this.legalMoves.add(new Position(this.position.getX() - 1, i));
            }

        }
        return this.legalMoves;
    }

    /**
     * Method that makes the piece move to a new position
     * 
     * @param p - The position the player wants to move to
     */
    @Override
    public void moveTo(Position p) {
        if (isLegalMove(p)) { // Verify that the move is legañ
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }

    /**
     * Method that verifies if the move is legal
     * 
     * @param p - The position that the player wants to move to
     * @return boolean - true in case that the move is legal, false in other case
     */
    @Override
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    /**
     * Method that verifies if a Queen is equal to another
     * 
     * @param obj - The other Queen that is going to be compared
     * @return boolean - true in case the 2 Queens are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof King))
            return false;

        King t = (King) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}