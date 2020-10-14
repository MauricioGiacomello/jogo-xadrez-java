package boordGame;

import boordGame.*;

// Está classe contém os atributos linhas, culunas e a matriz utlizada no jogo //

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){

        // Verifica se ROWS and COLUMNS passado é valido para criar um tabuleiro //
        if(rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows=rows;
        this.columns=columns;
        pieces = new Piece[rows][columns];
    
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    // Retorna a posição passada para os argumentos//
    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    // Retorna a peça que contém na posição passada em POSITION//
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    /* O método placePiece faz a inserção da peça no tabuleiro, 
    requisitando a linha e a coluna que será inserido pelo usuario*/
    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    /*Valida se a posição passada existe no tabuleiro 
    ROWS e COLUMS-> é a altura e largura do tabuleiro */
    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    /*Verifica se a posição existe no tabuleiro */
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());

    }

    // Retorna se existe alguma peça na posição passada e recebida do  outro método piece //
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
    
}
