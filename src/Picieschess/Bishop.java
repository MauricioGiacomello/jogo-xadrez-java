package Picieschess;

import boordGame.Board;
import boordGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }
    
    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        /************************************* NOROESTE *****************************************/

        p.setValues(position.getRow() - 1 , position.getColumn() - 1); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /************************************* NORDESTE *****************************************/

        p.setValues(position.getRow() - 1 , position.getColumn() + 1); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /************************************* SULDESTE *****************************************/

        p.setValues(position.getRow() + 1, position.getColumn() + 1); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getColumn() + 1, p.getRow() + 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /************************************* SULDOESTE *****************************************/

        p.setValues(position.getRow() + 1, position.getColumn() - 1); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        return mat;
    }
    
}
