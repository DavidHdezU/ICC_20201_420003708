package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * Rook class that extends the Piece class
 */
public class Rook extends Piece {
    /**
     * Rook constructor
     * 
     * @param p     - The position of the Rook
     * @param color - The color of the Rook
     */
    public Rook(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.ROOK;
    }

    /**
     * Method that give us the moves from a Rook
     * 
     * @return List - The list of legal moves from a Rook
     */
    @Override
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            for (int i = this.position.getX() + 1; i < 8; i++) {
                Position nextLegalPosition = new Position(i, this.position.getY());
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);
            }

            for (int i = this.position.getX() - 1; i >= 0; i--) {
                Position nextLegalPosition = new Position(i, this.position.getY());
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

            }

            for (int i = this.position.getY() + 1; i < 8; i++) {
                Position nextLegalPosition = new Position(this.position.getX(), i);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

            }

            for (int i = this.position.getY() - 1; i >= 0; i--) {
                Position nextLegalPosition = new Position(this.position.getX(), i);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);

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
        if (!(obj instanceof Rook))
            return false;

        Rook t = (Rook) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}