package boordGame;

// Está classe contém os atributos linhas, culunas e a matriz utlizada no jogo //

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        this.rows=rows;
        this.columns=columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows=rows;
    }

    public int getColumns(){
        return columns;
    }

    public void setColumns(int columns){
        this.columns=columns;
    }

    // Retorna a posição passada para os argumentos
    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    // Busca a posição da peça passado para os argumentos em Piece//
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }

    /* O método placePiece faz a inserção da peça no tabuleiro, 
    //requisitando a linha e a coluna que será inserido pelo usuario*/

    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    
}
