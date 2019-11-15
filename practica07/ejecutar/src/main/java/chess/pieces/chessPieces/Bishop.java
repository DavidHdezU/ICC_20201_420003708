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
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            int positionY = this.position.getY() + 1;
            for (int i = this.position.getX() + 1; i < 8; i++) {
                Position nextLegalPosition = new Position(i, positionY++);
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                this.legalMoves.add(nextLegalPosition);
            }

            for (int i = this.position.getX() + 1; i < 8; i++) {
                Position nextLegalPosition = new Position(i, positionY--);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                this.legalMoves.add(nextLegalPosition);
            }

            positionY = this.position.getY();
            for (int i = this.position.getX() - 1; i >= 0; i--) {
                Position nextLegalPosition = new Position(i, positionY--);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                this.legalMoves.add(nextLegalPosition);
            }

            for (int i = this.position.getX() - 1; i >= 0; i--) {
                Position nextLegalPosition = new Position(i, positionY++);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
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
        if (!(obj instanceof Bishop))
            return false;

        Bishop t = (Bishop) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}