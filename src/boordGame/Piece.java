package boordGame;

public abstract class Piece {
    
    protected Position position;
    private Board board;

    public Piece(Board board){
        this.board=board;
        position = null;
    }

    protected Board getBoard(){
        return board;
    }

    //Matriz abstrata para fazer a verificação de TRUE or FALSE para os campos para cada peça//
    public abstract boolean[][] possibleMove();

    //Verifica se uma peça pode ser movida para uma determinada possição//
    public boolean possibleMove(Position position){
        return possibleMove()[position.getRow()][position.getColumn()];
    }
   
    /*Instancia uma matriz abstrata do tipo possibleMove, que contém true or false em suas possições,
    e passa por cada possição na matriz para verificar se é possivel mover uma peça para este lugar*/
    public boolean isThereAnyPossibleMove(){

        boolean[][] mat = possibleMove();

        for(int i = 0; i<mat.length; i++){

            for(int j = 0; j<mat.length; j++){

                if(mat[i][j]){ // Verifica se a possição é verdadeira //
                    return true;
                }
            }
        }

        return false;
    }
}
