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
    public String toString() {
        return "H";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        /*************************************
         * NORTE
         *****************************************/

        int alteracaoLinhaColuna = 1;
        int cont = 1;

        while (cont < 3) {

            p.setValues(position.getRow() - 2, position.getColumn() - alteracaoLinhaColuna);

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            cont += 1;
            alteracaoLinhaColuna = -1;
        }

        /*************************************
         * SUL
         *****************************************/

         alteracaoLinhaColuna = 1;
         cont = 1;

        while (cont < 3) {

            p.setValues(position.getRow() + 2, position.getColumn() - alteracaoLinhaColuna);

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            cont += 1;
            alteracaoLinhaColuna = -1;
        }

         /*************************************
         * LESTE
         *****************************************/

        int alteracaoLinhaLinha = 1;
        cont = 1;

       while (cont < 3) {

           p.setValues(position.getRow() - alteracaoLinhaLinha, position.getColumn() - 2);

           if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
               mat[p.getRow()][p.getColumn()] = true;
           }

           if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
               mat[p.getRow()][p.getColumn()] = true;
           }

           cont += 1;
           alteracaoLinhaLinha = -1;
       }

       /*************************************
         * OESTE
         *****************************************/

        alteracaoLinhaLinha = 1;
        cont = 1;

       while (cont < 3) {

           p.setValues(position.getRow() - alteracaoLinhaLinha, position.getColumn() + 2);

           if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
               mat[p.getRow()][p.getColumn()] = true;
           }

           if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
               mat[p.getRow()][p.getColumn()] = true;
           }

           cont += 1;
           alteracaoLinhaLinha = - 1;
       }

        return mat;

    }

    

}