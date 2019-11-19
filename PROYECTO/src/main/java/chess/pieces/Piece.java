package chess.pieces;

import chess.items.Board;
import chess.items.Position;
import java.util.List;
import chess.pieces.chessPieces.*;

/**
 * Abstract class Piece
 */
public abstract class Piece {
    protected Position position;
    protected List<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;
    protected Board board;

    /**
     * Piece constructor
     * 
     * @param p     - Position where the piece is
     * @param color - The color of the piece
     */
    public Piece(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
    }

    /**
     * Method that tell us if the piece can do a move, but there are oher methods
     * better than this one
     * 
     * @param p - Position to move
     * @return int - 0 if it is appendable, -1 in other case
     */
    public int isAppendable(Position p) {
        Board board = Board.getInstance();
        Piece piece = board.getPiece(p);
        if (piece.getColor() == this.getColor())
            return -1;
        if (piece.getColor() != ColorEnum.NONE)
            return 0;
        return 1;
    }

    /**
     * Position getter
     * 
     * @return Position - The position of the piece
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Color getter
     * 
     * @return ColorEnum - The color of the piece
     */
    public ColorEnum getColor() {
        return this.color;
    }

    /**
     * Type getter
     * 
     * @return - The type of the piece
     */
    public PiecesTypeEnum getType() {
        return this.type;
    }

    /**
     * Mehod that makes a piece move to another position
     * 
     * @param p - The position we want to move to
     */
    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }

    /**
     * Abstract method getLegalMoves
     * 
     * @return List - List of moves from a piece
     */
    public abstract List<Position> getLegalMoves();

    /**
     * Method that tell us if a move is legal
     * 
     * @param p - The position we want to move
     * @return boolean - true if the move is legal, false in other case
     */
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    /**
     * Method that tell us if the position we want to move to is inside of the board
     * 
     * @param p - The position we want wo move to
     * @return boolean - true if the position is inside, false in other case
     */
    public boolean isInside(Position p) {
        return p.getX() < 8 && p.getX() >= 0 && p.getY() < 8 && p.getY() >= 0;
    }

    /**
     * Method that verifies if the move is legal and add the move to the list of
     * moves of the piece
     * 
     * @param p    - The position we want to move to
     * @param list - The list of legal moves from the piece
     */
    public void verifyLegalMove(Position p, List<Position> list) {
        Board board = Board.getInstance();
        if (this.isInside(p)) {
            Piece piece = board.getPiece(p);
            if (piece.getColor() == ColorEnum.NONE) {
                list.add(p);
            }
        }
        return;
    }

    /**
     * Method that verifies if the attack move is legal and add the move to the list
     * of moves of the piece
     * 
     * @param p    - The position we want to move to
     * @param list - The list of legal moves from the piece
     */
    public void verifyAttackMove(Position p, List<Position> list) {
        Board board = Board.getInstance();
        if (this.isInside(p)) {
            if ((board.getPiece(p).getColor() != this.getColor()) && !(board.getPiece(p) instanceof Empty)) {
                list.add(p);
            }
        }
        return;
    }

    /**
     * Method that give us the String representation of a piece
     * 
     * @return String - The String representation of a piece
     */
    @Override
    public String toString() {
        return this.type.toString();
    }

    /**
     * Method that tell us if 2 pieces are equal
     * 
     * @param obj - The other piece that we are going to compare
     * @return boolean - true if the 2 pieces are equal, false in other case
     */
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