package com.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TicTacToeTest {
   @Test
    public void testCheckWinnerRow() {
        char[] board = {'x', 'x', 'x', '4', '5', '6', '7', '8', '9'};
        char whosTurn = 'x';
        
        int result = TicTacToe.checkWinner(board, whosTurn, 3);
        assertEquals(1, result, "Player X should win by completing the first row.");
    }
    @Test
    public void testCheckWinnerDiagonal(){
        char[] board = {'x', '2', '3', '4', 'x', '6', '7', '8', 'x'};
        char whosTurn = 'x';
        
        int result = TicTacToe.checkWinner(board, whosTurn, 3);
        assertEquals(1, result, "Player X should win by completing the first row.");
    }
    @Test
    public void testCheckWinnerColumn(){
        char[] board = {'1', 'x', '3', '4', 'x', '6', '7', 'x', '9'};
        char whosTurn = 'x';
        
        int result = TicTacToe.checkWinner(board, whosTurn, 3);
        assertEquals(1, result, "Player X should win by completing the first row.");
    }
    @Test public void noWinner(){
        char[] board = {'x', 'o', 'x', 'x', '0', '0', '7', '8', '9'};
        char whosTurn = 'x';
        int result = TicTacToe.checkWinner(board, whosTurn, 6);
        assertEquals(0, result, "No one should've won");
    }   
}
