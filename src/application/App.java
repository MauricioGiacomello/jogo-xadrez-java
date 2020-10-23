package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boordGame.Board;
import boordGame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {

            try {

               //UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.println("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                // Coloração para as possições que podem mover//
                 boolean[][] possibleMove = chessMatch.possibleMoves(source);
                 //UI.clearScreen();
                 UI.printBoard(chessMatch.getPieces(), possibleMove);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChesseMove(source, target);

                if(capturedPiece != null){
                    captured.add(capturedPiece); // Adiciona na lista de peças capturadas //
                }

            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
