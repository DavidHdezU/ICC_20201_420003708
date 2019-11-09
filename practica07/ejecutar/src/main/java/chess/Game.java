package chess;

import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.chessPieces.Bishop;
import chess.pieces.chessPieces.Horse;
import chess.pieces.chessPieces.King;
import chess.pieces.chessPieces.Pawn;
import chess.pieces.chessPieces.Queen;
import chess.pieces.chessPieces.Rook;

public class Game {

    public static void main(String[] args) {
        Rook t = new Rook(new Position(4, 4), ColorEnum.BLACK);
        System.out.println(t.getLegalMoves());
        System.out.println("---------------------------------------------------ROOK MOVES");
        Queen x = new Queen(new Position(4, 4), ColorEnum.BLACK);
        System.out.println(x.getLegalMoves());
        System.out.println("---------------------------------------------------QUEEN MOVES");
        //
        Bishop y = new Bishop(new Position(4, 4), ColorEnum.BLACK);
        System.out.println(y.getLegalMoves());
        System.out.println("--------------------------------------------------- BISHOP MOVES");
        Pawn z = new Pawn(new Position(4, 4), ColorEnum.BLACK);
        System.out.println(z.getLegalMoves());
        System.out.println("---------------------------------------------------PAWN MOVES");
        Horse h = new Horse(new Position(0, 0), ColorEnum.BLACK);
        System.out.println(h.getLegalMoves());
        System.out.println("--------------------------------------------------- HORSE MOVES");
        King k = new King(new Position(4, 4), ColorEnum.BLACK);
        System.out.println(k.getLegalMoves());
        System.out.println("--------------------------------------------------- KING MOVES");

    }

}