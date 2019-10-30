package chess.pieces;
import java.util.List;
import chess.items.Position;
public abstract class Piece{
    protected Position position;
    protected List<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;

    public abstract void moveTo(Position p);
    public abstract boolean isLegalMove(Position p);

    @Override
    public abstract boolean equals(Object obj);

}