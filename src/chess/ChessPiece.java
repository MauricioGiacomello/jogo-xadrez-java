package chess;

import boordGame.Board;
import boordGame.Piece;

// Atribuir cor para cada peça no tabuleiro //

public class ChessPiece extends Piece{

    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
    
}
