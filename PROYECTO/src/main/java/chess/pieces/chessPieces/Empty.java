package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;

import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * Empty piece that extends the Piece class
 */
public class Empty extends Piece {
    /**
     * Empty construCtor
     * 
     * @param p - Initial position
     * @param c - Color of the piece
     */
    public Empty(Position p, ColorEnum c) {
        super(p, c);
        this.type = PiecesTypeEnum.EMPTY;
    }

    /**
     * Empty constructor whit Position(0, 0)
     */
    public Empty() {
        super(new Position(0, 0), ColorEnum.NONE);
        this.type = PiecesTypeEnum.EMPTY;
    }

    /**
     * The legal moves of the piece
     */
    @Override
    public List<Position> getLegalMoves() {
        return new LinkedList<>();
    }

    /**
     * Method that tells us if 2 Emoty piece are equal
     */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Empty) ? true : false;
    }

}