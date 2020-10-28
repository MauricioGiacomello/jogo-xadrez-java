package chess;

import boordGame.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.border.Border;

import Picieschess.*;

// ChessMatch é responsavel pelo inicioda da partida //

public class ChessMatch {

    private static final String ChessPiece = null;
    private static final String opponentPieces = null;
    private int turn;
    private static Color currentPlayer;
    private Board board;
    private boolean check = false;
    private boolean CheckMate;

    private List<Piece> piecesOnTheBoard = new ArrayList<>(); // Peças no tabuleiro //
    private List<Piece> capturedPieces = new ArrayList<>(); // Peças capturadas //

    public ChessMatch() {

        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();

    }

    public boolean getCheckMate() {
        return CheckMate;
    }

    public int getTurn() {
        return turn;
    }

    public static Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck() {
        return check;
    }

    // Método instancia um obejeto que é passado por BOARD.GET* e para cada posição
    // ele faz uma inserção na matriz //
    public ChessPiece[][] getPieces() {

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {

            for (int j = 0; j < board.getColumns(); j++) {

                mat[i][j] = (ChessPiece) board.piece(i, j);

            }
        }
        return mat;
    }

    // Usado para imprimir as possições possiveis a partir de uma possição de
    // origem//
    public boolean[][] possibleMove(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMove();
    }

    /*
     * 1 - Recebe posição de destino e posição de origem 2 - Valida se a posição
     * existe com validateSourcePosition
     */
    public ChessPiece performChesseMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if (testCheck(currentPlayer)) {
            DesfazerMovimento(source, target, capturedPiece);
            throw new ChessException("Você não pode ser colocar em check!");
        }

        // testa se o oponente está em check//
        check = (testCheck(opponent(currentPlayer))) ? true : false;

        if (testCheckMate(opponent(currentPlayer))) { // testa se estar em check mate//

            CheckMate = true;

        } else {

            nextTurn();

        }

        return (ChessPiece) capturedPiece;
    }

    // Função que faz o redirecionamento para saber se é possivel mover da posição
    // inicial a final//
    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    // Recebe a posição digitada pelo usuario e verifica se tem alguma coisa nesta
    // posição//
    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }

        if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) { // teste de cor
            throw new ChessException("The chosen piece is not yours");
        }

        if (!board.piece(position).isThereAnyPossibleMove()) { // Retornar a mensagem se nâo tiver nehuma posssição para
                                                               // mover a peça //
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    // Faz a mudança de um turno de um usuario para o outro //
    private void nextTurn() {
        turn++;
        // Expressão IF avançada //
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    /*
     * 1 - Remove a peça da posição de origem 2 - Remove a peça na posição de
     * destino 3 - Adiciona na posição de destino a nova peça
     */
    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source); // Remove a peça da posição de origem//
        Piece capturedPiece = board.removePiece(target); // Captura e remove a peça na possição de destino //
        board.placePiece(p, target); // Adiciona na posição de destino//

        if (capturedPiece != null) { // Lista de peças capturadas //
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece; // retorna a peça capturada//
    }

    // Desfaz a lógica de makeMove//
    private void DesfazerMovimento(Position source, Position target, Piece capturedPiece) {
        Piece p = board.removePiece(target);// Retirando a peça de destino //
        board.placePiece(p, source); // Devolvendo a peça para sua posição de origem //

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, target);
            capturedPiece.remove(capturedPiece); // Remove da lista de capturadas//
            piecesOnTheBoard.add(capturedPiece); // Adiciona da lista de peças no tabuleiro //
        }

    }

    private Color opponent(Color color) {

        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;

    }

    private ChessPiece king(Color color) { // Vare o tabuleiro buscando o rei referente a cor passado no arg//
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
                .collect(Collectors.toList());

        for (Piece p : list) {

            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board");
    }

    // Este método testa se o rei do oponente está em check//
    private boolean testCheck(Color color) {
        Position PosicaoDoRei = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream()
                .filter(x -> ((ChessPiece) x).getColor() == opponent(color)).collect(Collectors.toList());

        // for (Piece CheckAllPieces : piecesOnTheBoard) {

        // if (((chess.ChessPiece) CheckAllPieces).getColor() == opponent(color))
        // ;
        // List<Piece> opponentPieces = (List<Piece>) ((Stream<Piece>)
        // CheckAllPieces).collect(Collectors.toList());

        // }

        for (Piece p : opponentPieces) {

            boolean[][] mat = p.possibleMove();

            if (mat[PosicaoDoRei.getRow()][PosicaoDoRei.getColumn()]) {
                return true; // Caso ele retorne true indica que o rei está em check //
            }
        }

        return false; // rei não está em check//
    }

    private boolean testCheckMate(Color color) {

        if (!testCheck(color)) {
            return CheckMate;
        }

        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == opponent(color))
                .collect(Collectors.toList());

        for (Piece p : list) {

            boolean[][] mat = p.possibleMove();

            for (int i = 0; i < board.getRows(); i++) {

                for (int j = 0; j < board.getColumns(); j++) {

                    if (mat[i][j]) {

                        Position source = ((ChessPiece) p).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target); // Fazendo o movimento da peça para testar //
                        boolean TestCheck = testCheck(color);
                        DesfazerMovimento(source, target, capturedPiece);

                        if (!TestCheck) {
                            return false;
                        }
                    }

                }
            }
            return true;
        }
        return true;
    }
    // Insere uma nova peça no game e chama o toString para converter os valores
    // para as posições na variavel//
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    // Montar a mesa inicial para fazer a partida de xadrez //
    private void initialSetup() {
        placeNewPiece('h', 7, new Rook(board, Color.WHITE));
        // placeNewPiece('e', 5, new Knight(board, Color.WHITE));
        // placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        // placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        // placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        // placeNewPiece('d', 4, new Knight(board, Color.WHITE));
        placeNewPiece('d', 1, new Rook(board, Color.WHITE));
        // placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        // placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        // placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        // placeNewPiece('d', 1, new Pawn(board, Color.WHITE));
        // placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        // placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        // placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        // placeNewPiece('h', 7, new Pawn(board, Color.WHITE));

        placeNewPiece('b', 8, new Rook(board, Color.BLACK));
        // placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        // placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        // placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('a', 8, new King(board, Color.BLACK));
        // placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        // placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        // placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        // placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        // placeNewPiece('h', 7, new Pawn(board, Color.BLACK));

    }

}
