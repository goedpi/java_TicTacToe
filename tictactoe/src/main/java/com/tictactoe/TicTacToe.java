package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    static char[] board = { '1', '2', '3',
            '4', '5', '6',
            '7', '8', '9' };
    static int NumSquaresPlayed = 0;
    static char WhosTurn = 'x';
    
    static int IsThereWinner = 0;
    //-1 = tie
    // 0 = no winner
    // 1 = winner

    static Scanner scanner = new Scanner(System.in);
    static int squareToPlay;
    public static void main(String[] args) {
     
        while (NumSquaresPlayed < 9) {
            printTheBoard(board);
            System.out.printf("Choose a square player %s:", WhosTurn);
            playerInput(board, WhosTurn);
      // check if there is a winner or not
            checkWinner(board, WhosTurn, squareToPlay);
            if (IsThereWinner == 1) {
                System.out.println("Congrats you have won player " + WhosTurn + "!!");

                System.out.println("==== The winning board ====");
                printTheBoard(board);
                break;
            } else if(NumSquaresPlayed == 9){
                System.out.println("It's a tie");
                break;
            }
            WhosTurn = (WhosTurn == 'x') ? 'o' : 'x';

        }

    }

    
    private static void playerInput(char []board, char WhosTurn) {
        //handles validation and input
        
        boolean validInput = false;
        while (validInput == false) {
            try {
                squareToPlay = scanner.nextInt();
                if (squareToPlay < 1 || squareToPlay > 9 ) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    System.out.printf("Choose a square player %s:", WhosTurn);
                } else if(board[squareToPlay - 1] == 'o' || board[squareToPlay-1] == 'x'){
                    System.out.println("This square is taken. Please try another one");
                    System.out.printf("Choose a square player %s:", WhosTurn);
                    printTheBoard(board);
                } else{
                    board[squareToPlay - 1] = WhosTurn;
                    NumSquaresPlayed++;
                    validInput=true;
                }
            }  catch (Exception e) {
                System.out.println("Input is not a number. Please enter a number between 1 and 9");
                System.out.printf("Choose a square player %s:", WhosTurn);
                scanner.next();
            }
           
        }
    }

    private static void printTheBoard(char[] board) {
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println(" - + - + - ");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(" - + - + - ");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);

    }

    private static int checkWinner(char[] board, char WhosTurn, int NumSquaresPlayed) {
        if ((board[0] + board[1] + board[2] == (WhosTurn * 3)) // first row
                || (board[3] + board[4] + board[5] == (WhosTurn * 3)) // second row
                || (board[6] + board[7] + board[8] == (WhosTurn * 3)) // third row
                || (board[0] + board[3] + board[6] == (WhosTurn * 3)) // first column
                || (board[1] + board[4] + board[7] == (WhosTurn * 3)) // second column
                || (board[2] + board[5] + board[8] == (WhosTurn * 3)) // third column
                || (board[0] + board[4] + board[8] == (WhosTurn * 3)) // first diagonal
                || (board[2] + board[4] + board[6] == (WhosTurn * 3)) // second diagonal
        ) {

            return IsThereWinner = 1;

        } else {
            return IsThereWinner = 0;

        }
    }
}
