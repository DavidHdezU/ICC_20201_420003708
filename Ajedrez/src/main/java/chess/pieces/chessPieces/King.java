package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * King class that extends Piece class
 */
public class King extends Piece {
    /**
     * King constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color the piece has
     */
    public King(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.KING;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    @Override
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            Position nextLegaPosition1 = new Position(this.position.getX() - 1, this.position.getY());
            verifyLegalMove(nextLegaPosition1, this.legalMoves);
            Position nextLegaPosition2 = new Position(this.position.getX() + 1, this.position.getY());
            verifyLegalMove(nextLegaPosition2, this.legalMoves);
            Position nextLegaPosition3 = new Position(this.position.getX() + 1, this.position.getY() + 1);
            verifyLegalMove(nextLegaPosition3, this.legalMoves);
            Position nextLegaPosition4 = new Position(this.position.getX() + 1, this.position.getY() - 1);
            verifyLegalMove(nextLegaPosition4, this.legalMoves);
            Position nextLegaPosition5 = new Position(this.position.getX(), this.position.getY() + 1);
            verifyLegalMove(nextLegaPosition5, this.legalMoves);
            Position nextLegaPosition6 = new Position(this.position.getX(), this.position.getY() - 1);
            verifyLegalMove(nextLegaPosition6, this.legalMoves);
            Position nextLegaPosition7 = new Position(this.position.getX() - 1, this.position.getY() + 1);
            verifyLegalMove(nextLegaPosition7, this.legalMoves);
            Position nextLegaPosition8 = new Position(this.position.getX() - 1, this.position.getY() - 1);
            verifyLegalMove(nextLegaPosition8, this.legalMoves);
            verifyAttackMove(new Position(this.position.getX() - 1, this.position.getY() + 1), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX() + 1, this.position.getY() + 1), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX() - 1, this.position.getY() - 1), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX() + 1, this.position.getY() - 1), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX(), this.position.getY() + 1), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX(), this.position.getY() - 1), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX() + 1, this.position.getY()), this.legalMoves);
            verifyAttackMove(new Position(this.position.getX() - 1, this.position.getY()), this.legalMoves);
        }
        return this.legalMoves;
    }

    /**
     * Method that verifies if a King is equal to another
     * 
     * @param obj - The other King that is going to be compared
     * @return boolean - true in case the 2 Kings are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof King))
            return false;

        King t = (King) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}