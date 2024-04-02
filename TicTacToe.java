package HW6;



import java.util.Scanner;



public class TicTacToe {

    private char[][] board;

    private char currentPlayer;

    private boolean gameEnded;

    private Scanner scanner;



    public TicTacToe() {

        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        currentPlayer = 'X';

        gameEnded = false;

        scanner = new Scanner(System.in);

    }



    public void playGame() {

        while (!gameEnded) {

            drawBoard();

            boolean validInput = false;

            while (!validInput) {

                System.out.println("Player " + currentPlayer + ", enter your move (row and column):");

                int row = getIntInput("row");

                int col = getIntInput("column");

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {

                    board[row][col] = currentPlayer;

                    validInput = true;

                } else {

                    System.out.println("This move is not valid. Try again.");

                }

            }

            gameEnded = checkWinner(currentPlayer);

            if (!gameEnded) {

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            }

        }

        drawBoard();

        System.out.println("Player " + currentPlayer + " wins!");

        scanner.close();

    }



    private void drawBoard() {

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



    private int getIntInput(String prompt) {

        System.out.print("Enter " + prompt + ": ");

        while (!scanner.hasNextInt()) {

            System.out.print("Invalid input. Please enter a number for " + prompt + ": ");

            scanner.next();

        }

        return scanner.nextInt();

    }



    private boolean checkWinner(char currentPlayer) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;

            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;

        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') return false;

            }

        }

        System.out.println("It's a tie!");

        return true;

    }



    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();

        game.playGame();

    }

}