package tictactoe;

public class AIPlayer {
    public int[] findBestMove(char[][] board){
        int bestVal = -1000;
        int [] bestMove = new int[2];
        bestMove[0] = -1;
        bestMove[1] = -1;

        for (int row = 0; row < 3; row ++){
            for (int col = 0; col < 3; col++){
                if (board[row][col] == ' '){
                    board[row][col] = 'O';
                    int moveVal = minimax(board, 0, false);
                    board[row][col] = ' ';

                    if (moveVal > bestVal){
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    public boolean isMovesLeft(char[][] board){
        for (int row = 0; row < 3; row++){
            for (int col = 0; col <3; col++){
                if(board[row][col] == ' '){
                    return true;
                }
            }
        }
        return false;
    }

    public int evaluate(char[][] board){
        for (int row = 0; row < 3; row ++){
            if (board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]){
                if (board[row][0] == 'O') return 10;
                if (board[row][0] == 'X') return -10;
            }
        }
        for (int col = 0; col < 3; col ++){
            if (board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]){
                if (board[0][col] == 'O') return 10;
                if (board[0][col] == 'X') return -10;
            }
        }
        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]){
            if (board[0][0] == 'O') return 10;
            if (board[0][0] == 'X') return -10;
        }
        if (board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]){
            if (board[0][2] == 'O') return 10;
            if (board[0][2] == 'X') return -10;
        }
        return 0;
    }
    public int minimax(char[][] board, int depth, boolean isMax){
        int score = evaluate(board);
        if (score == 10){
            return score;
        }
        if (score == -10){
            return score;
        }
        if (!isMovesLeft(board)){
            return 0;
        }
        if (isMax){
            int best = -1000;
            for (int row =0; row < 3; row ++){
                for (int col = 0; col < 3; col ++){
                    if (board[row][col] == ' '){
                        board[row][col] = 'O';

                        best = Math.max(best, minimax(board, depth + 1, false));
                        board[row][col] = ' ';
                    }
                }
            }
            return best;
        }
        else {
            int best = 1000;
            for (int row = 0; row < 3; row ++){
                for (int col = 0; col < 3; col++){
                    if (board[row][col] == ' '){
                        board[row][col] = 'X';

                        best = Math.min(best, minimax(board, depth + 1, true));
                        board[row][col] = ' ';
                    }
                }
            }
            return best;
        }
    }
}


