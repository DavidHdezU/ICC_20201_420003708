package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;

import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class Empty extends Piece {
    public Empty(Position p, ColorEnum c) {
        super(p, c);
        this.type = PiecesTypeEnum.EMPTY;
    }

    public Empty() {
        super(new Position(0, 0), ColorEnum.NONE);
        this.type = PiecesTypeEnum.EMPTY;
    }

    @Override
    public LinkedList<Position> getLegalMoves() {
        return new LinkedList<>();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Empty) ? true : false;
    }

}