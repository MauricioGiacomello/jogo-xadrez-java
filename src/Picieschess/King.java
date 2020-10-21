package Picieschess;

import boordGame.Board;
import boordGame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString(){
        return "K";
    }

    //Verifica se a posição existe e se a posição na qual a peça vai ser movida é uma peça adversaria//
    private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

    @Override
    public boolean[][] possibleMove() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

    /************************************* ACIMA DA PEÇA *****************************************/

    p.setValues(position.getRow() - 1, position.getColumn());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

    /************************************* ABAIXO DA PEÇA *****************************************/

    p.setValues(position.getRow() + 1, position.getColumn());

        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
    }

    /************************************* ESQUERDA DA PEÇA ***************************************/

    p.setValues(position.getRow(), position.getColumn() - 1);
        
        if(getBoard().positionExists(p) && canMove(p)){
        mat[p.getRow()][p.getColumn()] = true;
    }

    /************************************* DIREITA DA PEÇA ***************************************/

    p.setValues(position.getRow(), position.getColumn() + 1);
    if(getBoard().positionExists(p) && canMove(p)){
        mat[p.getRow()][p.getColumn()] = true;
    }

    /************************************* NOROESTE DA PEÇA ***************************************/

    p.setValues(position.getRow() - 1, position.getColumn() - 1);
    if(getBoard().positionExists(p) && canMove(p)){
        mat[p.getRow()][p.getColumn()] = true;
    }

    /************************************* NOROESTE DA PEÇA ***************************************/

    p.setValues(position.getRow() - 1, position.getColumn() + 1);
    if(getBoard().positionExists(p) && canMove(p)){
        mat[p.getRow()][p.getColumn()] = true;
    }

     /************************************* SULDOESTE DA PEÇA ***************************************/

     p.setValues(position.getRow() + 1, position.getColumn() - 1);
     if(getBoard().positionExists(p) && canMove(p)){
         mat[p.getRow()][p.getColumn()] = true;
     }

     /************************************* SULDESTE DA PEÇA ***************************************/

     p.setValues(position.getRow() + 1, position.getColumn() + 1);
     if(getBoard().positionExists(p) && canMove(p)){
         mat[p.getRow()][p.getColumn()] = true;
     }

     return mat;
     
    }

}
