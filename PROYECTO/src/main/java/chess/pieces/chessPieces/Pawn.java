package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * Pawn class that extends the Piece class
 */
public class Pawn extends Piece {
    /**
     * Pawn constructor
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
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            if (this.getColor() == ColorEnum.WHITE) {
                Position nextLegalPosition = new Position(this.position.getX() - 1, this.position.getY());
                verifyLegalMove(nextLegalPosition, this.legalMoves);
                if (this.position.getX() == 6
                        && board.getPiece(new Position(5, this.position.getY())) instanceof Empty) {
                    verifyLegalMove(new Position(this.position.getX() - 2, this.position.getY()), this.legalMoves);
                }
                verifyAttackMove(new Position(this.position.getX() - 1, this.position.getY() + 1), this.legalMoves);
                verifyAttackMove(new Position(this.position.getX() - 1, this.position.getY() - 1), this.legalMoves);
            } else if (this.getColor() == ColorEnum.BLACK) {
                Position nextLegalPosition = new Position(this.position.getX() + 1, this.position.getY());
                verifyLegalMove(nextLegalPosition, this.legalMoves);
                if (this.position.getX() == 1
                        && board.getPiece(new Position(2, this.position.getY())) instanceof Empty) {
                    verifyLegalMove(new Position(this.position.getX() + 2, this.position.getY()), this.legalMoves);
                }
                verifyAttackMove(new Position(this.position.getX() + 1, this.position.getY() - 1), this.legalMoves);
                verifyAttackMove(new Position(this.position.getX() + 1, this.position.getY() + 1), this.legalMoves);
            }
        }
        return this.legalMoves;
    }

    /**
     * Method that verifies if a Pawb is equal to another
     * 
     * @param obj - The other Pawn that is going to be compared
     * @return boolean - true in case the 2 Pawns are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pawn))
            return false;

        Pawn t = (Pawn) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}