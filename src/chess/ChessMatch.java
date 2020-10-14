package chess;

import boordGame.*;
import Picieschess.*;

import boordGame.Board;

// ChessMatch é responsavel pelo inicioda da partida //

public class ChessMatch {

    private Board board;

    public ChessMatch(){

        board = new Board(8,8);
        initialSetup();

    }

    //Método instancia um obejeto que é passado por BOARD.GET* e para cada posição ele faz uma inserção na matriz //
    public ChessPiece[][] getPieces() {

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i=0;i<board.getRows();i++){

            for(int j=0;j<board.getColumns();j++){

                mat[i][j] = (ChessPiece) board.piece(i,j);

            }
        }
        return mat;
    }

    //Insere uma nova peça no game e chama o toString para converter os valores para as posições na variavel//
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    // Montar a mesa inicial para fazer a partida de xadrez //
    private void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Rook(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));


    }
    
}
