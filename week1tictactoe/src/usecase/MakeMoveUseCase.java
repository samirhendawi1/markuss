package usecase;

import entity.TicTacToeBoard;

public class MakeMoveUseCase implements MakeMoveInputBoundary {
    private final TicTacToeBoard board;
    private final MakeMoveOutputBoundary outputBoundary;

    public MakeMoveUseCase(TicTacToeBoard board, MakeMoveOutputBoundary outputBoundary) {
        this.board = board;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void makeMove(int row, int col) {
        // Check if the move is valid first (i.e., the cell is empty)
        if (board.isValidMove(row, col)) {
            // Make the move on the board
            board.makeMove(row, col);

            // Check if there is a winner after this move
            char winner = board.checkWin();
            if (winner != '-') {
                outputBoundary.presentWinner(winner);
            } else if (board.isFull()) {
                // If the board is full and no winner, it's a draw
                outputBoundary.presentWinner('D'); // Draw
            } else {
                // Switch player after a valid move
                board.switchPlayer();
            }
        } else {
            // If the move is invalid, present an error message
            outputBoundary.presentError("Invalid move. Try again.");
        }
    }
}