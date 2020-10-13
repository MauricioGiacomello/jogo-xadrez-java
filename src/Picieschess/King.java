package Picieschess;

import boordGame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    //Peca rei que erda a cor e a posição de PIECE//

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString(){
        return " K ";
    }
}
