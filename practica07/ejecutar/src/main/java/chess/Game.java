package chess;

import chess.items.*;
import chess.items.Board;
import chess.pieces.*;
import chess.pieces.ColorEnum;
import chess.pieces.chessPieces.Rook;
//import chess.pieces.chessPieces;

public class Game {

    public static void main(String[] args) {
        Board board = Board.getInstance();
        System.out.println(board.toString());
        Piece p = new Rook(new Position(0, 0), ColorEnum.BLACK);
        System.out.println(p.getLegalMoves());
    }
}