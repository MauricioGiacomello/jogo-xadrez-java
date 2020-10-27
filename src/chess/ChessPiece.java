package chess;

import boordGame.Board;
import boordGame.Piece;
import boordGame.Position;

// Atribuir cor para cada peça no tabuleiro //

public abstract class ChessPiece extends Piece{

    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public ChessPosition getChessPosition(){ // Converte position (A1) para posição de xadrez [][]//
        return ChessPosition.fromPosition(position);
    }
    
    /* Este método verifica se a cor da peça de uma determinda possição 
    é diferente da cor da peça que estou trabalhando  */
    protected boolean IsThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position); // DownCasting //
        return p != null && p.getColor() != color; 
    }
    
}
