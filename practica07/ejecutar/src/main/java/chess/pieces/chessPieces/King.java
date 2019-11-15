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
        this.type = PiecesTypeEnum.KING;
    }

    /**
     * Method that specifies the legalMoves that the piece can do during the game
     * 
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    public List<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            List<Position> legalMoves = super.getLegalMoves();
            for (int i = this.position.getX() - 1; i > this.position.getX() - 2; i--) {
                Position nextLegalPosition = new Position(this.position.getX(), i);
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                legalMoves.add(nextLegalPosition);
            }

            for (int i = this.position.getX() + 1; i < this.position.getX() + 2; i++) {
                Position nextLegalPosition = new Position(i, this.position.getY() + 1);
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                legalMoves.add(nextLegalPosition);
            }
            for (int i = this.position.getX() + 1; i < this.position.getX() + 2; i++) {
                Position nextLegalPosition = new Position(i, this.position.getY() - 1);
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                legalMoves.add(nextLegalPosition);
            }
            for (int i = this.position.getY() - 1; i > this.position.getY() - 2; i--) {
                Position nextLegalPosition = new Position(this.position.getX() - 1, i);
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                legalMoves.add(nextLegalPosition);
            }
            for (int i = this.position.getY() + 1; i < this.position.getY() + 2; i++) {
                Position nextLegalPosition = new Position(this.position.getX() - 1, i);
                if (!this.isLegalMove(nextLegalPosition))
                    break;
                if (this.isAppendable(nextLegalPosition) == -1)
                    break;
                if (this.isAppendable(nextLegalPosition) == 0) {
                    legalMoves.add(nextLegalPosition);
                    break;
                }
                if (nextLegalPosition.isOutOfBoard(7) == true) {
                    break;
                }
                legalMoves.add(nextLegalPosition);
            }

        }
        return legalMoves;
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