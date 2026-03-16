package tictactoe;

public class TicTacToe {
    char[][] board = new char[3][3];

    public TicTacToe() {
        initializeBoard();
    }

    public void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (int row = 0; row < 3; row++) {
            System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);

            if (row < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    public void makeMove(int row, int col, char symbol) {
        board[row][col] = symbol;

    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != ' ') {
            return false;
        }
        return true;
    }

    public char checkWinner() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' ' &&
                    board[row][0] == board[row][1] &&
                    board[row][0] == board[row][2]) {
                return board[row][0];
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' &&
                    board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                return board[0][col];
            }
        }
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return ' ';
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


}
