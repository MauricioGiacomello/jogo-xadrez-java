package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

//Classe responsavel pela impresão de peças e do tabuleiro para o usuario //

public class UI {

    // Cores do textos
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Cores de fundo//
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // Limpa a tela após uma ação//
    public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    /*
     * 1 - Recebe o input do usuario, separa o char em COLUMN e ROW e retorna esses
     * valores 2 - Valida qualquer erro de excessão no método
     */
    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.next();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);

        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }

    //Imprime o tabuleiro e fala a pessoa que está esperando para jogar//
    public static void printMatch(ChessMatch ChessMatch){
        printBoard(ChessMatch.getPieces());
        System.out.println();
        System.out.println("Turn: " + ChessMatch.getTurn());
        System.out.println("Wating player: " + ChessMatch.getCurrentPlayer());
    }

    /*Imprime apenas o tabuleiro com as peças em suas determinadas posições*/
    public static void printBoard(ChessPiece[][] pieces) {

		for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
    }
 
         /*Imprime o tabuleiro com as peças em suas determinadas posições e as possibilidades de mover elas*/
         public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {

            for (int i = 0; i < pieces.length; i++) {
                System.out.print((8 - i) + " ");
                
                for (int j = 0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }

    // Emprime o conteudo de 1 peça já com a coloração prevista para a peça//
    public static void printPiece(ChessPiece piece, boolean background) {

        if(background){

            System.out.print(ANSI_BLUE_BACKGROUND);
        }

        if (piece == null) {

            System.out.print("-" + ANSI_RESET);

        } else {

            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);

            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }

        System.out.print(" ");

    }

}
