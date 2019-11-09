
package chess.items;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Empty;
import chess.pieces.chessPieces.Rook;

public class Board{
    public int SIZE = 8;
    public Piece[][] matrix;
    private static Board instance = null;
    private Board(){
        this.matrix = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i][j] = new Empty(new Position(i, j), ColorEnum.NONE);
            }
        }
        this.matrix[4][0] = new Rook(new Position(4, 0), ColorEnum.WHITE);
        this.matrix[7][0] = new Rook(new Position(7, 0), ColorEnum.BLACK);
    }

    public static Board getInstance(){
        if(instance == null)
            instance = new Board();
        return instance;
    }

    public int getSize(){
        return this.SIZE;
    }
    public Piece getPiece(Position p){
        //if(p.isOutOfBoard(SIZE))return null;
        return this.matrix[p.getX()][p.getY()];
    }


    @Override
    public String toString(){
        var result = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result += " "+ this.matrix[i][j]+" ";
            }
            result += '\n';
        }
        return result;
    }

}