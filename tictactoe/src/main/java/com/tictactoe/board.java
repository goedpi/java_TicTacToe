package com.tictactoe;

public class board {
    player currentPlayer;
    private char[] board = { '1', '2', '3',
                             '4', '5', '6',
                             '7', '8', '9' };
    public char[] getBoard(){
        return board;
    }
    public void setBoard(char[] board){
        this.board = board;
    }

    public void setSquare(int index, player currentPlayer){
        board[index] = currentPlayer.getSymbol();
    }

    public char getSquare(int index){
        return board[index];
    }
    public void printBoard(){
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println(" - + - + - ");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(" - + - + - ");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    }
}
