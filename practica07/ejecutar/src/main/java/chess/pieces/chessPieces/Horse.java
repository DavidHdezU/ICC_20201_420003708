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
public class Horse extends Piece {
    /**
     * Bishop constructor
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
     * @return LinkedList - The list of availibles moves that the piece can do
     */
    @Override
    public List<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            for (int i = this.position.getX() + 3; i < this.position.getX() + 4; i++) {
                Position nextLegalPosition = new Position(this.position.getX() + i, this.position.getY() + 1);
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

            for (int i = this.position.getX() - 3; i > this.position.getX() - 4; i--) {
                Position nextLegalPosition = new Position(this.position.getX() - i, this.position.getY() - 1);
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

            for (int i = this.position.getY() - 3; i > this.position.getY() - 4; i--) {
                Position nextLegalPosition = new Position(this.position.getX() - 1, this.position.getY() - i);
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

            for (int i = this.position.getY() + 3; i < this.position.getY() + 4; i++) {
                Position nextLegalPosition = new Position(this.position.getX() + 1, this.position.getY() + i);
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Horse))
            return false;

        Horse t = (Horse) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}