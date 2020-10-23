package Picieschess;

import boordGame.Board;
import boordGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);

    }

    @Override
    public String toString(){
        return "K";
    }
    
    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        return mat;

    }

    
}