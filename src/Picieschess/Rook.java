package Picieschess;

import boordGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    //Peca torre que erda a cor e a posição de PIECE//
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return " R ";
    }
    
}
