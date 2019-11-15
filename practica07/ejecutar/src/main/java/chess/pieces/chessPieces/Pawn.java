package chess.pieces.chessPieces;

import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * Rook class that extends the Piece class
 */
public class Pawn extends Piece {
    /**
     * Bishop constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color the piece has
     */
    public Pawn(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.PAWN;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    @Override
    public List<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            for (int i = this.position.getY() + 1; i < this.position.getY() + 2; i++) {
                Position nextLegalPosition = new Position(this.position.getX(), i);
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
            }
        }
        return this.legalMoves;
    }

    /**
     * Method that verifies if a Rook is equal to another
     * 
     * @param obj - The other Rook that is going to be compared
     * @return boolean - true in case the 2 Rooks are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pawn))
            return false;

        Pawn t = (Pawn) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}