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

    // Montar a mesa inicial para fazer a partida de xadrez //
    private void initialSetup(){
        //Instanciando cada peão no tabuleiro //
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(4, 6));


    }
    
}
