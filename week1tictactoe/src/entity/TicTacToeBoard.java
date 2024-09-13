package entity;

public class TicTacToeBoard {
    private char[][] board;
    private char currentPlayer;

    // Constructor to initialize the board
    public TicTacToeBoard() {
        board = new char[3][3];
        currentPlayer = 'X'; // Set initial player to 'X'
        initializeBoard();
    }

    // Initialize the board with empty cells
    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';  // Use '-' for empty cells
            }
        }
    }

    // Method to print the current board state
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Method to make a move at the given row and column
    public boolean makeMove(int row, int col) {
        // Check if the move is valid (i.e., cell is empty)
        if (row < 0 || col < 0 || row >= 3 || col >= 3) {
            return false; // Invalid move if out of bounds
        }

        if (board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true; // Move made successfully
        } else {
            return false; // Cell is already occupied
        }
    }

    // Method to switch players
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Method to check if the current player has won
    public char checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return currentPlayer; // Row win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return currentPlayer; // Column win
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return currentPlayer; // Diagonal win
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return currentPlayer; // Diagonal win
        }
        return '-'; // No winner yet
    }

    // Check if the board is full (i.e., no more valid moves)
    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false; // There are still empty spaces
                }
            }
        }
        return true; // Board is full
    }
}
