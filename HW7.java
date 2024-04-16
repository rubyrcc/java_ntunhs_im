package HW7;

import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;
    private boolean againstComputer;

    public TicTacToeGame(boolean playAgainstComputer) {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // X starts the game
        this.againstComputer = playAgainstComputer;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public boolean hasWinner() {
        return checkWinner(currentPlayer);
    }

    private boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char[][] getGameBoard() {
        return board;
    }

    public void computerMove() {
        if (!againstComputer || currentPlayer == 'O') return;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = currentPlayer;
                    return;
                }
            }
        }
    }
}


public class HW7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play against another player (p) or computer (c)?");
        String mode = scanner.next().trim();
        boolean againstComputer = mode.equalsIgnoreCase("c");

        TicTacToeGame game = new TicTacToeGame(againstComputer);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard(game.getGameBoard());
            boolean validInput = false;

            if (againstComputer && game.getCurrentPlayer() == 'X') {
                game.computerMove();
                validInput = true; // Automatically true because computer always makes a valid move
            } else {
                while (!validInput) {
                    System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row [0-2] and column [0-2]): ");
                    try {
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();
                        if (game.makeMove(row, col)) {
                            validInput = true;
                        } else {
                            System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter numbers only.");
                        scanner.nextLine();
                    }
                }
            }

            if (game.hasWinner()) {
                gameEnded = true;
                printBoard(game.getGameBoard());
                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
            } else if (game.isBoardFull()) {
                printBoard(game.getGameBoard());
                System.out.println("It's a tie!");
                break;
            } else {
                game.switchPlayer();
            }
        }

        scanner.close();
    }

    private static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-+-+-");
        }
    }
}