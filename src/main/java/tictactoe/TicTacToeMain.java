package tictactoe;

import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int mode;
        System.out.println("Select #1 for 2 Players (2 Human Players)");
        System.out.println("Select #2 for 1 Player (Human vs Intelligent AI)");
        System.out.println("Choose player mode: ");
        mode = input.nextInt();

        if (mode == 1){
            TicTacToe game = new TicTacToe();
            char currentPlayer = 'X';

            game.displayBoard();
            while (true){
                System.out.println("Player " + currentPlayer + "'s turn");

                System.out.println("Enter row (0, 1, or 2): ");
                int row = input.nextInt();
                System.out.println("Enter column (0, 1, or 2): ");
                int col = input.nextInt();

                while(!game.isValidMove(row, col)){
                    System.out.println("Invalid move, position unavailable. Try again!");

                    System.out.println("Enter row (0, 1, or 2): ");
                    row = input.nextInt();

                    System.out.println("Enter column (0, 1, or 2): ");
                    col = input.nextInt();
                }

                game.makeMove(row, col, currentPlayer);
                System.out.println();
                game.displayBoard();

                char winner = game.checkWinner();
                if (winner != ' '){
                    System.out.println("Player " + winner + " wins!");
                    break;
                }

                if (game.isBoardFull()){
                    System.out.println("Draw game!");
                    break;
                }

                if (currentPlayer == 'X'){
                    currentPlayer = 'O';
                }else {
                    currentPlayer = 'X';
                }
            }
        }

        else if (mode == 2){
            TicTacToe game = new TicTacToe();
            AIPlayer ai = new AIPlayer();
            char currentPlayer = 'X';
            game.displayBoard();

            while (true){
                int row;
                int col;
                System.out.println("Player " + currentPlayer + "'s turn");
                if (currentPlayer == 'X'){
                    System.out.println("Enter row (0, 1, 2): ");
                    row = input.nextInt();
                    System.out.println("Enter column (0, 1, 2): ");
                    col = input.nextInt();

                    while(!game.isValidMove(row, col)){
                        System.out.println("Invalid move, position unavailable. Try again!");

                        System.out.println("Enter row (0, 1, or 2): ");
                        row = input.nextInt();

                        System.out.println("Enter column (0, 1, or 2): ");
                        col = input.nextInt();
                    }
                } else {
                    int[] bestMove = ai.findBestMove(game.getBoard());
                    row = bestMove[0];
                    col = bestMove[1];
                    System.out.println("Computer chose: " + row + ", " + col);
                }
                game.makeMove(row, col, currentPlayer);
                System.out.println();
                game.displayBoard();

                char winner = game.checkWinner();
                if (winner != ' '){
                    System.out.println("Player " + winner + " wins!");
                    break;
                }
                if (game.isBoardFull()){
                    System.out.println("Draw game!");
                    break;
                }
                if (currentPlayer == 'X'){
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }
    }
}

