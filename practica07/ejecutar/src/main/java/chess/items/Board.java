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

    private Board() {
        this.matrix = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i][j] = new Empty(new Position(i, j), ColorEnum.NONE);
            }
        }
        /** POSICIONES INICIALES DE LAS TORRES */
        this.matrix[0][0] = new Rook(new Position(0, 0), ColorEnum.BLACK);
        this.matrix[7][0] = new Rook(new Position(7, 0), ColorEnum.BLACK);
        this.matrix[0][7] = new Rook(new Position(0, 7), ColorEnum.WHITE);
        this.matrix[7][7] = new Rook(new Position(7, 7), ColorEnum.WHITE);
        /** POSIOCIONES INICIALES DE LOS PEONES */
        for (int i = 0; i < 8; i++) {
            this.matrix[i][1] = new Pawn(new Position(i, 1), ColorEnum.BLACK);
            this.matrix[i][6] = new Pawn(new Position(i, 6), ColorEnum.WHITE);
        }
        /** POSICIONES INCIALES DE LOS REYES */
        this.matrix[4][0] = new King(new Position(4, 0), ColorEnum.BLACK);
        this.matrix[4][7] = new King(new Position(4, 7), ColorEnum.WHITE);
        /** POSICIONES INCIALES DE LOS ALFILES */
        this.matrix[1][0] = new Bishop(new Position(1, 0), ColorEnum.BLACK);
        this.matrix[6][0] = new Bishop(new Position(6, 0), ColorEnum.BLACK);
        this.matrix[1][7] = new Bishop(new Position(1, 7), ColorEnum.WHITE);
        this.matrix[6][7] = new Bishop(new Position(6, 7), ColorEnum.WHITE);
        /** POSICIONES INICIALES DE LAS REINAS */
        this.matrix[3][0] = new Queen(new Position(3, 0), ColorEnum.BLACK);
        this.matrix[3][7] = new Queen(new Position(3, 7), ColorEnum.WHITE);

    }

    public static Board getInstance() {
        if (instance == null)
            instance = new Board();
        return instance;
    }

    public int getSize() {
        return this.SIZE;
    }

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

    public Piece getPiece(Position p) {
        // if(p.isOutOfBoard(SIZE))return null;
        return this.matrix[p.getX()][p.getY()];
    }

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