package com.tictactoe;

import java.util.Scanner;


public class TicTacToe {
    static char[] board = { '1', '2', '3',
            '4', '5', '6',
            '7', '8', '9' };
    static int NumSquaresPlayed = 0;
    static int IsThereWinner = 0;
    //-1 = tie
    // 0 = no winner
    // 1 = winner

    static Scanner scanner = new Scanner(System.in);
    static int squareToPlay;
    public static void main(String[] args) {
        board gameBoard = new board();
        
        player player1 = new player(scanner);
        player1.configurePlayer(1, 'x');

        player player2 = new player(scanner);
        player2.configurePlayer(2, 'o');

        player currentpPlayer = player1;

        while (NumSquaresPlayed < 9) {
            gameBoard.printBoard();
            System.out.printf("Choose a square player %s:", currentpPlayer.getName());
            playerInput(gameBoard, currentpPlayer, scanner);
      // check if there is a winner or not
            checkWinner(gameBoard, currentpPlayer, squareToPlay);
            if (IsThereWinner == 1) {
                System.out.println("Congrats you have won player " + currentpPlayer.getName() + "!!");

                System.out.println("==== The winning board ====");
                gameBoard.printBoard();
                break;
            } else if(NumSquaresPlayed == 9){
                System.out.println("It's a tie");
                break;
            }
            currentpPlayer = (currentpPlayer == player1) ? player2 : player1;

        }

    }

    
    static void playerInput(board gameBoard, player currentPlayer, Scanner inputScanner) {
        //handles validation and input
        Scanner input;
            if (inputScanner != null) {
                input = inputScanner; // Use the provided scanner if it is not null
            } else {
                input = scanner; // Otherwise, use the default global scanner
            }
        boolean validInput = false;
        while (validInput == false) {
            try {
                squareToPlay = input.nextInt();
                if (squareToPlay < 1 || squareToPlay > 9 ) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    System.out.printf("Choose a square player %s:", currentPlayer.getName());
                } else if(gameBoard.getSquare(squareToPlay - 1) == 'o' || gameBoard.getSquare(squareToPlay - 1) == 'x'){
                    System.out.println("This square is taken. Please try another one");
                    System.out.printf("Choose a square player %s:", currentPlayer.getName());
                    gameBoard.printBoard();
                } else{
                    gameBoard.setSquare(squareToPlay-1, currentPlayer);
                    NumSquaresPlayed++;
                    validInput=true;
                }
            }  catch (Exception e) {
                System.out.println("Input is not a number. Please enter a number between 1 and 9");
                System.out.printf("Choose a square player %s:", currentPlayer.getName());
                scanner.next();
            }
           
        }
    }

    // private static void printTheBoard(char[] board) {
    //     System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    //     System.out.println(" - + - + - ");
    //     System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
    //     System.out.println(" - + - + - ");
    //     System.out.println(board[0] + " | " + board[1] + " | " + board[2]);

    // }

    static int checkWinner(board gameBoard, player currentPlayer, int NumSquaresPlayed) {
        if ((gameBoard.getSquare(0) + gameBoard.getSquare(1) + gameBoard.getSquare(2) == (currentPlayer.getSymbol() * 3)) // first row
        || (gameBoard.getSquare(3) + gameBoard.getSquare(4) + gameBoard.getSquare(5) == (currentPlayer.getSymbol() * 3)) // second row
        || (gameBoard.getSquare(6) + gameBoard.getSquare(7) + gameBoard.getSquare(8) == (currentPlayer.getSymbol() * 3)) // third row
        || (gameBoard.getSquare(0) + gameBoard.getSquare(3) + gameBoard.getSquare(6) == (currentPlayer.getSymbol() * 3)) // first column
        || (gameBoard.getSquare(1) + gameBoard.getSquare(4) + gameBoard.getSquare(7) == (currentPlayer.getSymbol() * 3)) // second column
        || (gameBoard.getSquare(2) + gameBoard.getSquare(5) + gameBoard.getSquare(8) == (currentPlayer.getSymbol() * 3)) // third column
        || (gameBoard.getSquare(0) + gameBoard.getSquare(4) + gameBoard.getSquare(8) == (currentPlayer.getSymbol() * 3)) // first diagonal
        || (gameBoard.getSquare(2) + gameBoard.getSquare(4) + gameBoard.getSquare(6) == (currentPlayer.getSymbol() * 3)) // second diagonal
        ) {
            return IsThereWinner = 1;
        } else {
            return IsThereWinner = 0;
        }
    }
}
