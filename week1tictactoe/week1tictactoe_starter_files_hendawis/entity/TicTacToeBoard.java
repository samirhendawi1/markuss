package week1tictactoe.week1tictactoe_starter_files_hendawis.entity;

public class TicTacToeBoard {
    private final char[][] board;
    private char currentPlayer;

    public TicTacToeBoard() {
        board = new char[3][3];
        currentPlayer = 'X';
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                /*
                Assign '-' to the current row and column in board.
                 */
                board[row][col] = '-'; // Initializes each cell as empty with '-'
            }
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean makeMove(int row, int col) {
        /*
        This is from a long 1-line Boolean expression from inside the if. You'll need three pieces.
        Here are two:

        row >= 0 && col >= 0 &&
        row < 3 && col < 3 &&

        You'll also need a clause to check whether board[row][col] is equal to '-'.
         */
        if (row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == '-') {
            // Checks if the position is valid and the cell is empty
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public char checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            }
        }
        /*
        Check the main diagonal for a win.
         */
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            // Checks the main diagonal (from top-left to bottom-right)
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        }
        return '-';
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            /* The for loop looks so lonely with empty parentheses. What could
            go in there?
             */
            for (int col = 0; col < 3; col++) {
                // Loops through all columns in each row
                if (board[row][col] == '-') {
                    return false; // If any empty cell ('-') is found, return false
                }
            }
        }
        return true;
    }

    public char[][] getBoard() {
        return board;
    }
}
