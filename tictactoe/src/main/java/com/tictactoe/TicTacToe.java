package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[] board = {'1', '2','3',
                        '4', '5','6',
                        '7', '8', '9'};
        var NumSquaresPlayed = 0;
        var WhosTurn = 'x';

        while (NumSquaresPlayed < 9) {
            printTheBoard(board);
            System.out.printf("Choose a square player %s:" , WhosTurn);
            Scanner scanner = new Scanner(System.in);
            int squareToPlay = scanner.nextInt();

            board[squareToPlay-1] = WhosTurn;
        }
        
    }
    private static void printTheBoard(char[] board){
        System.out.println( board[6] + " | " +  board[7] + " | " + board[8]);
        System.out.println( " - + - + - " );
        System.out.println( board[3] + " | " +  board[4] + " | " + board[5]);
        System.out.println( " - + - + - " );
        System.out.println( board[0] + " | " +  board[1] + " | " + board[2]);
        
    }

    
}
