package chess.pieces.chessPieces;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
        this.type = PiecesTypeEnum.ROOK;
    }

    public Position getPosition(){
        return this.position;
    }
    public ColorEnum getColor(){
        return this.color;
    }
    public List<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            this.legalMoves = new LinkedList<Position>();
            for(int i = this.position.getX()+1;i < 8; i++){
                this.legalMoves.add(new Position(i, this.position.getY()));
            }

            for(int i = this.position.getX()-1;i >= 0; i--){
                this.legalMoves.add(new Position(i, this.position.getY()));
            }

            for(int i = this.position.getY()+1;i < 8; i++){
                this.legalMoves.add(new Position(this.position.getX(),i));
            }

            
            for(int i = this.position.getY()-1;i >= 0; i--){
                this.legalMoves.add(new Position(this.position.getX(),i));
            }
            for(int i = this.position.getX()+1; i < 8; i++){
                for(int j = this.position.getY() + 1; j < (8-this.position.getX()); j ++){
                    this.legalMoves.add(new Position(this.position.getX(), this.position.getY()));
                }
            }
        }
        return this.legalMoves;
    }

    @Override
    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }

    @Override
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Queen))
            return false;

        Queen t = (Queen) obj;
        return (t.getColor() == this.getColor() 
                && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}