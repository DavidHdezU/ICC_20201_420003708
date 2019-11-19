package chess.items;

import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Bishop;
import chess.pieces.chessPieces.Empty;
import chess.pieces.chessPieces.Horse;
import chess.pieces.chessPieces.King;
import chess.pieces.chessPieces.Pawn;
import chess.pieces.chessPieces.Queen;
import chess.pieces.chessPieces.Rook;

public class Board {
    public int SIZE = 8;
    public Piece[][] matrix;
    private static Board instance = null;

    /**
     * Private constructor of the Board
     */
    private Board() {
        this.matrix = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i][j] = new Empty(new Position(i, j), ColorEnum.NONE);
            }
        }
        // Initial positions of the Rooks
        this.matrix[7][7] = new Rook(new Position(7, 7), ColorEnum.WHITE);
        this.matrix[7][0] = new Rook(new Position(7, 0), ColorEnum.WHITE);
        this.matrix[0][0] = new Rook(new Position(0, 0), ColorEnum.BLACK);
        this.matrix[0][7] = new Rook(new Position(0, 7), ColorEnum.BLACK);

        // Initial positions of the Kings
        this.matrix[0][3] = new King(new Position(0, 3), ColorEnum.BLACK);
        this.matrix[7][3] = new King(new Position(7, 3), ColorEnum.WHITE);

        // Initial positions of the Queens
        this.matrix[0][4] = new Queen(new Position(0, 4), ColorEnum.BLACK);
        this.matrix[7][4] = new Queen(new Position(7, 4), ColorEnum.WHITE);

        // Initial positions of the Horses
        this.matrix[0][1] = new Horse(new Position(0, 1), ColorEnum.BLACK);
        this.matrix[0][6] = new Horse(new Position(0, 6), ColorEnum.BLACK);
        this.matrix[7][1] = new Horse(new Position(7, 1), ColorEnum.WHITE);
        this.matrix[7][6] = new Horse(new Position(7, 6), ColorEnum.WHITE);

        // Initial positions of the Bishops
        this.matrix[0][2] = new Bishop(new Position(0, 2), ColorEnum.BLACK);
        this.matrix[0][5] = new Bishop(new Position(0, 5), ColorEnum.BLACK);
        this.matrix[7][2] = new Bishop(new Position(7, 2), ColorEnum.WHITE);
        this.matrix[7][5] = new Bishop(new Position(7, 5), ColorEnum.WHITE);

        // Initial posotions of the Pawns
        for (int i = 0; i < 8; i++) {
            this.matrix[6][i] = new Pawn(new Position(6, i), ColorEnum.WHITE);
            this.matrix[1][i] = new Pawn(new Position(1, i), ColorEnum.BLACK);
        }
    }

    /**
     * Method that creates the Boards onlu one time
     * 
     * @return - The board
     */
    public static Board getInstance() {
        if (instance == null)
            instance = new Board();
        return instance;
    }

    /**
     * Board size getter
     * 
     * @return - The size of the board
     */
    public int getSize() {
        return this.SIZE;
    }

    /**
     * Method to move a piece from a position p to a position q
     * 
     * @param p - The position where the piece is
     * @param q - The position we want to move to
     */
    public void move(Position p, Position q) {
        if (!p.isLegal() || !q.isLegal())
            return;
        Piece piece = this.getPiece(p);
        if (!piece.isLegalMove(q))
            return;
        piece.moveTo(q);
        this.matrix[p.getX()][p.getY()] = new Empty(p, ColorEnum.NONE);
        this.matrix[q.getX()][q.getY()] = piece;
    }

    /**
     * Method that returns the piece that is in a specific position
     * 
     * @param p - The position where the piece is
     * @return - The coordinates of the piece
     */
    public Piece getPiece(Position p) {
        // if(p.isOutOfBoard(SIZE))return null;
        return this.matrix[p.getX()][p.getY()];
    }

    /**
     * Method that prints the board
     * 
     * @return String - The String representation of the board
     */
    @Override
    public String toString() {
        var result = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result = " " + this.matrix[i][j] + " " + result;
            }
            result += '\n';
        }
        return result;
    }

}