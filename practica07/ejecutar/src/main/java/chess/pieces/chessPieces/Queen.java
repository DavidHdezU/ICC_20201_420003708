package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;

/**
 * Queem class that extends Rook class
 */
public class Queen extends Rook {
    /**
     * Queen constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color the piece has
     */
    public Queen(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.QUEEN;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    @Override
    public LinkedList<Position> getLegalMoves() {
        Board board = Board.getInstance();
        if (this.legalMoves == null) {
            int positionY = this.position.getY() + 1;
            LinkedList<Position> legalMoveList = super.getLegalMoves();
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
                this.legalMoves.add(nextLegalPosition);
            }

            positionY = this.position.getY();
            for (int i = this.position.getX() + 1; i < 8; i++) {
                Position nextLegalPosition = new Position(i, positionY--);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
                    break;
                }
                this.legalMoves.add(nextLegalPosition);
            }

            for (int i = this.position.getX() - 1; i >= 0; i--) {
                Position nextLegalPosition = new Position(i, positionY--);
                Piece piece = board.getPiece(nextLegalPosition);
                if (piece.getColor() == this.getColor())
                    break;
                if (piece.getColor() != ColorEnum.NONE) {
                    this.legalMoves.add(nextLegalPosition);
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
                this.legalMoves.add(nextLegalPosition);
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
        LinkedList<Position> moves = this.getLegalMoves();
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
        if (!(obj instanceof Queen))
            return false;

        Queen t = (Queen) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}