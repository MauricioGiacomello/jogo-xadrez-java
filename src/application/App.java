package application;

import java.util.Scanner;

import boordGame.Board;
import boordGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true){
        
        UI.printBoard(chessMatch.getPieces());
        System.out.println();
        System.out.println("Source: ");
        ChessPosition source = UI.readChessPosition(sc);

        System.out.println();
        System.out.println("Target: ");
        ChessPosition target = UI.readChessPosition(sc);

        ChessPiece capturedPiece = chessMatch.performChesseMove(source, target);


    }
   }
}
