package chess;

import boordGame.Position;

/* 1 - Faz a conversão do caracter row que vai ser recebido com uma letra
   2 - Verifica se a coluna ensirida é do tamanho permitido */

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row){
        // Valida tamanho e tipo de caracter //
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
        }
        this.column=column;
        this.row=row;
    }

    public char getColumn(){
        return column;
    }

    public int getRow(){
        return row;
    }

    /*matrix_row = 8 - chess_row -> para encontrar a linha basta fazer 8 - LinhaDigitada
      matrix_column = chess_column - 'a' -> para encontrar a coluna basta fazer ColunaDigitada - unicode de 'a' */
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    /*Mesmo processo do método toPosition, poém o inverso para encontrar o caracter de 'a' ou a coluna */
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row;
    }
    
}
