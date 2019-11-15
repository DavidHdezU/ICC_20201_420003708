package chess.pieces;

import java.util.List;
import chess.items.Board;
import chess.items.Position;

public abstract class Piece {
    protected Position position;
    protected List<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;
    protected Board board;

    public Piece(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
    }

    public int isAppendable(Position p) {
        Board board = Board.getInstance();
        Piece piece = board.getPiece(p);
        if (piece.getColor() == this.getColor())
            return -1;
        if (piece.getColor() != ColorEnum.NONE)
            return 0;
        return 1;
    }

    public Position getPosition() {
        return this.position;
    }

    public ColorEnum getColor() {
        return this.color;
    }

    public PiecesTypeEnum getType() {
        return this.type;
    }

    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }

    public abstract List<Position> getLegalMoves();

    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Piece))
            return false;
        Piece p = (Piece) obj;
        if (p.getType().equals(this.type) && p.getColor().equals(this.getColor())
                && p.getPosition().equals(this.position))
            return true;
        return false;
    }
}