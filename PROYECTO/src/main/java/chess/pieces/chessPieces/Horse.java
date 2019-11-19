package chess.pieces.chessPieces;

import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * Horse class that extends the Piece class
 */
public class Horse extends Piece {
    /**
     * Horse constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color the piece has
     */
    public Horse(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.HORSE;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return List - The list of availibles moves that the piece can do
     */
    @Override
    public List<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            Position nextLegalPosition1 = new Position(this.position.getX() + 2, this.position.getY() - 1);
            verifyLegalMove(nextLegalPosition1, this.legalMoves);
            verifyAttackMove(nextLegalPosition1, this.legalMoves);

            Position nextLegalPosition2 = new Position(this.position.getX() + 2, this.position.getY() + 1);
            verifyLegalMove(nextLegalPosition2, this.legalMoves);
            verifyAttackMove(nextLegalPosition2, this.legalMoves);

            Position nextLegalPosition3 = new Position(this.position.getX() - 2, this.position.getY() - 1);
            verifyLegalMove(nextLegalPosition3, this.legalMoves);
            verifyAttackMove(nextLegalPosition3, this.legalMoves);

            Position nextLegalPosition4 = new Position(this.position.getX() - 2, this.position.getY() + 1);
            verifyLegalMove(nextLegalPosition4, this.legalMoves);
            verifyAttackMove(nextLegalPosition4, this.legalMoves);

            Position nextLegalPosition5 = new Position(this.position.getX() + 1, this.position.getY() - 2);
            verifyLegalMove(nextLegalPosition5, this.legalMoves);
            verifyAttackMove(nextLegalPosition5, this.legalMoves);

            Position nextLegalPosition6 = new Position(this.position.getX() + 1, this.position.getY() + 2);
            verifyLegalMove(nextLegalPosition6, this.legalMoves);
            verifyAttackMove(nextLegalPosition6, this.legalMoves);

            Position nextLegalPosition7 = new Position(this.position.getX() - 1, this.position.getY() - 2);
            verifyLegalMove(nextLegalPosition7, this.legalMoves);
            verifyAttackMove(nextLegalPosition7, this.legalMoves);

            Position nextLegalPosition8 = new Position(this.position.getX() - 1, this.position.getY() + 2);
            verifyLegalMove(nextLegalPosition8, this.legalMoves);
            verifyAttackMove(nextLegalPosition8, this.legalMoves);
        }
        return this.legalMoves;
    }

    /**
     * Method that verifies if a Horse is equal to another
     * 
     * @param obj - The other Horse that is going to be compared
     * @return boolean - true in case the 2 Horses are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Horse))
            return false;

        Horse t = (Horse) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}