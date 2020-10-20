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

    /* 1 - Recebe posição de destino e posição de origem 
       2 - Valida se a posição existe com validateSourcePosition */
    public ChessPiece performChesseMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }

    //Recebe a posição digitada pelo usuario e verifica se tem alguma coisa nesta posição//
    private void validateSourcePosition(Position position){
        if (!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){ // Retornar a mensagem se nâo tiver nehuma posssição para mover a peça //
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }
    /* 1 - Remove a peça da posição de origem 
       2 - Remove a peça na posição de destino
       3 - Adiciona na posição de destino a nova peça*/
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source); // Remove a peça da posição de origem//
        Piece capturedPiece = board.removePiece(target); // Captura e remove a peça na possição de destino //
        board.placePiece(p, target); // Adiciona na posição de destino//
        return capturedPiece; // retorna a peça capturada//
    }

    //Insere uma nova peça no game e chama o toString para converter os valores para as posições na variavel//
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    // Montar a mesa inicial para fazer a partida de xadrez //
    private void initialSetup(){
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));


    }
    
}
