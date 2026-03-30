package tictactoe;
import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int mode;

        System.out.println("Select #1 for 2 Players (2 Human Players)");
        System.out.println("Select #2 for 1 Player (Human vs Intelligent AI)");
        System.out.print("Choose player mode: ");
        mode = input.nextInt();

        if (mode == 1) {
            TicTacToe game = new TicTacToe();

            input.nextLine();

            System.out.print("Enter Player 1 name: ");
            String player1Name = input.nextLine();

            System.out.print("Enter Player 2 name: ");
            String player2Name = input.nextLine();

            System.out.print(player1Name + ", choose your symbol (X or O): ");
            char player1Symbol = Character.toUpperCase(input.next().charAt(0));
            char player2Symbol;

            if (player1Symbol == 'X') {
                player2Symbol = 'O';
            } else {
                player1Symbol = 'O';
                player2Symbol = 'X';
            }

            char currentPlayer = 'X';

            game.displayBoard();

            while (true) {
                if (currentPlayer == player1Symbol) {
                    System.out.println(player1Name + "'s turn (" + currentPlayer + ")");
                } else {
                    System.out.println(player2Name + "'s turn (" + currentPlayer + ")");
                }

                System.out.print("Enter row (0, 1, or 2): ");
                int row = input.nextInt();

                System.out.print("Enter column (0, 1, or 2): ");
                int col = input.nextInt();

                while (row < 0 || row > 2 || col < 0 || col > 2 || !game.isValidMove(row, col)) {
                    System.out.println("Invalid move. Enter row and column from 0 to 2, and choose an empty position.");

                    System.out.print("Enter row (0, 1, or 2): ");
                    row = input.nextInt();

                    System.out.print("Enter column (0, 1, or 2): ");
                    col = input.nextInt();
                }

                game.makeMove(row, col, currentPlayer);
                System.out.println();
                game.displayBoard();

                char winner = game.checkWinner();
                if (winner != ' ') {
                    if (winner == player1Symbol) {
                        System.out.println(player1Name + " wins!");
                    } else {
                        System.out.println(player2Name + " wins!");
                    }
                    break;
                }

                if (game.isBoardFull()) {
                    System.out.println("Draw game!");
                    break;
                }

                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }

        else if (mode == 2) {
            TicTacToe game = new TicTacToe();
            AIPlayer ai = new AIPlayer();

            input.nextLine();

            System.out.print("Enter your name: ");
            String playerName = input.nextLine();

            System.out.print(playerName + ", choose your symbol (X or O): ");
            char playerSymbol = Character.toUpperCase(input.next().charAt(0));
            char aiSymbol;

            if (playerSymbol == 'X') {
                aiSymbol = 'O';
            } else {
                playerSymbol = 'O';
                aiSymbol = 'X';
            }

            char currentPlayer = 'X';

            game.displayBoard();

            while (true) {
                int row;
                int col;

                if (currentPlayer == playerSymbol) {
                    System.out.println(playerName + "'s turn (" + currentPlayer + ")");
                } else {
                    System.out.println("Intelligent AI's turn (" + currentPlayer + ")");
                }

                if (currentPlayer == playerSymbol) {
                    System.out.print("Enter row (0, 1, or 2): ");
                    row = input.nextInt();

                    System.out.print("Enter column (0, 1, or 2): ");
                    col = input.nextInt();

                    while (row < 0 || row > 2 || col < 0 || col > 2 || !game.isValidMove(row, col)) {
                        System.out.println("Invalid move. Enter row and column from 0 to 2, and choose an empty position.");

                        System.out.print("Enter row (0, 1, or 2): ");
                        row = input.nextInt();

                        System.out.print("Enter column (0, 1, or 2): ");
                        col = input.nextInt();
                    }
                } else {
                    int[] bestMove = ai.findBestMove(game.getBoard());
                    row = bestMove[0];
                    col = bestMove[1];
                    System.out.println("Intelligent AI chose: " + row + ", " + col);
                }

                game.makeMove(row, col, currentPlayer);
                System.out.println();
                game.displayBoard();

                char winner = game.checkWinner();
                if (winner != ' ') {
                    if (winner == playerSymbol) {
                        System.out.println(playerName + " wins!");
                    } else if (winner == aiSymbol) {
                        System.out.println("Intelligent AI wins!");
                    }
                    break;
                }

                if (game.isBoardFull()) {
                    System.out.println("Draw game!");
                    break;
                }

                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }

        else {
            System.out.println("Invalid mode selected.");
        }

        input.close();
    }
}