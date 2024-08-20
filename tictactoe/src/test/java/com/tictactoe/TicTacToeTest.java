package com.tictactoe;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    player currentPlayer;
    @BeforeEach
    public void setupPlayer(){
        String input = "John\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        player player1 = new player(scanner);
        player1.configurePlayer(1, 'x');
        currentPlayer = player1;
    }
    
    @Test
    public void testCheckWinnerRow() {
        char[] board = {'x', 'x', 'x', '4', '5', '6', '7', '8', '9'};
        
        int result = TicTacToe.checkWinner(board, currentPlayer, 3);
        assertEquals(1, result, "Player X should win by completing the first row.");
    }
    @Test
    public void testCheckWinnerDiagonal(){
        char[] board = {'x', '2', '3', '4', 'x', '6', '7', '8', 'x'};
        
        int result = TicTacToe.checkWinner(board, currentPlayer, 3);
        assertEquals(1, result, "Player X should win by completing the first row.");
    }
    @Test
    public void testCheckWinnerColumn(){
        char[] board = {'1', 'x', '3', '4', 'x', '6', '7', 'x', '9'};
        
        int result = TicTacToe.checkWinner(board, currentPlayer, 3);
        assertEquals(1, result, "Player X should win by completing the first row.");
    }
    @Test public void noWinner(){
        char[] board = {'x', 'o', 'x', 'x', '0', '0', '7', '8', '9'};
        int result = TicTacToe.checkWinner(board, currentPlayer, 6);
        assertEquals(0, result, "No one should've won");
    }   
    }
    

