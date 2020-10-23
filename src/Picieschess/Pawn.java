package Picieschess;

import javax.xml.transform.Source;

import boordGame.Board;
import boordGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMove() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);
        
        if(getColor() == Color.WHITE){

            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            if(p.getRow() == 5){

                p.setValues(position.getRow() - 2, position.getColumn());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

        }else{

            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            if(p.getRow() == 2){

                p.setValues(position.getRow() + 2, position.getColumn());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && IsThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }

}
