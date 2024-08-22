package com.tictactoe;

import java.util.Scanner;


public class TicTacToe {
    static int NumSquaresPlayed = 0;

    static Scanner scanner = new Scanner(System.in);
    static int squareToPlay;
    public static void main(String[] args) {
        board gameBoard = new board();
        GameRules gameRules = new GameRules();
        player player1 = new player(scanner);
        player1.configurePlayer(1, 'x');

        player player2 = new player(scanner);
        player2.configurePlayer(2, 'o');

        player currentPlayer = player1;

        while (NumSquaresPlayed < 9) {
            boolean validInput = false;
            gameBoard.printBoard();
            System.out.printf("Choose a square player %s:", currentPlayer.getName());
            try {

                while(validInput == false){
                    int squareToPlay = scanner.nextInt();
                    validInput = gameRules.validateInput(squareToPlay, currentPlayer, gameBoard);
                }

            } catch (Exception e) {
                System.out.println("Input is not a number. Please enter a number between 1 and 9");
                System.out.printf("\n Choose a square player %s:", currentPlayer.getName());
                scanner.next();
            }
            NumSquaresPlayed++;
            if (gameRules.checkWinner(gameBoard, currentPlayer)) {
                System.out.println("Congrats you have won player " + currentPlayer.getName() + "!!");

                System.out.println("==== The winning board ====");
                gameBoard.printBoard();
                LogGameHistory logGameHistory = new LogGameHistory(player1, player2, gameBoard, NumSquaresPlayed);
                logGameHistory.logGameResult("Winner is: " + currentPlayer.getName() + "Symbol: " + currentPlayer.getSymbol());
                break;
            } else if(NumSquaresPlayed == 9){
                System.out.println("It's a tie");
                break;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;

            // playerInput(gameBoard, currentPlayer, scanner);
      // check if there is a winner or not
            // checkWinner(gameBoard, currentPlayer, squareToPlay);
           
            

        }

    }
}
