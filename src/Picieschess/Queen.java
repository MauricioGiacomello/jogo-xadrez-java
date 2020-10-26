package Picieschess;

import boordGame.Board;
import boordGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    // Verifica se a posição existe e se a posição na qual a peça vai ser movida é
    // uma peça adversaria//
    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        /*************************************
         * NORTE
         *****************************************/

        p.setValues(position.getRow() - 1, position.getColumn()); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn()); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * NOROESTE
         *****************************************/

        p.setValues(position.getRow() - 1, position.getColumn() - 1); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * NORDESTE
         *****************************************/

        p.setValues(position.getRow() - 1, position.getColumn() + 1); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * SUL
         *****************************************/

        p.setValues(position.getRow() + 1, position.getColumn()); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn()); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * SULDESTE
         *****************************************/

        p.setValues(position.getRow() + 1, position.getColumn() + 1); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * SULDOESTE
         *****************************************/

        p.setValues(position.getRow() + 1, position.getColumn() - 1); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * LESTE
         *****************************************/

        p.setValues(position.getRow(), position.getColumn() - 1); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn() - 1); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        /*************************************
         * OESTE
         *****************************************/

        p.setValues(position.getRow(), position.getColumn() + 1); // Position é a possição da peça //
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn() + 1); // Mudando a posição //
        }
        if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) { // Verifica se a peça que tem lá é do adversario
                                                                       // //
            mat[p.getRow()][p.getColumn()] = true;

        }

        return mat;
    }

}
