package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

/**
 * Bishop class that extends the Piece class
 */
public class Bishop extends Piece {
    /**
     * Bishop constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color the piece has
     */
    public Bishop(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.BISHOP;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves = new LinkedList<Position>();
        for (int i = this.position.getX() + 1, j = this.position.getY() + 1; i < 8 && j < 8; i++, j++) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        for (int i = this.position.getX() + 1, j = this.position.getY() - 1; i < 8 && j >= 0; i++, j--) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        for (int i = this.position.getX() - 1, j = this.position.getY() - 1; i >= 0 && j >= 0; i--, j--) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        for (int i = this.position.getX() - 1, j = this.position.getY() + 1; i >= 0 && j < 8; i--, j++) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        return this.legalMoves;
    }

    /**
     * Method that verifies if a Bishop is equal to another
     * 
     * @param obj - The other Bishop that is going to be compared
     * @return boolean - true in case the 2 Bishops are equal, false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bishop))
            return false;
        Bishop t = (Bishop) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}