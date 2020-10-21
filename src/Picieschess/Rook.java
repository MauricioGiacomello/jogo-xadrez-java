package Picieschess;

import boordGame.*;
import chess.*;

import boordGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMove() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0 , 0); 

        /************************************* ACIMA DA PEÇA *****************************************/

        p.setValues(position.getRow() - 1 , position.getColumn()); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /************************************* ABAIXO DA PEÇA *****************************************/

        p.setValues(position.getRow() + 1 , position.getColumn()); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /************************************* ESQUERDA DA PEÇA *****************************************/

        p.setValues(position.getRow(), position.getColumn() - 1); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /************************************* DIREITA DA PEÇA *****************************************/

        p.setValues(position.getRow(), position.getColumn() + 1); // Position é a possição da peça //
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1); // Mudando a posição //
        }
        if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){ // Verifica se a peça que tem lá é do adversario //
            mat[p.getRow()][p.getColumn()] = true;

        }

        return mat;
    }
    
}
