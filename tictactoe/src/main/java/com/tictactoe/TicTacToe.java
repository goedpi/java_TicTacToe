package com.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        char[] board = {'1', '2','3',
                        '4', '5','6',
                        '7', '8', '9'};
        var NumSquaresPlayed = 0;
        var WhosTurn = 'x';

        printTheBoard(board);
        
    }
    private static void printTheBoard(char[] board){
        System.out.println( board[0] + " | " +  board[1] + " | " + board[2]);
        System.out.println( " - + - + - " );
        System.out.println( board[3] + " | " +  board[4] + " | " + board[5]);
        System.out.println( " - + - + - " );
        System.out.println( board[6] + " | " +  board[7] + " | " + board[8]);
    }

    
}
