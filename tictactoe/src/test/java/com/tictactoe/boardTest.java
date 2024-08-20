package com.tictactoe;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class boardTest {
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
    
    
    board Board = new board();
    char[] defaultBoard = { '1', '2', '3','4', '5', '6','7', '8', '9' };

    @Test
    public void getBoard(){
        //validates that board is set to expected default
        assertArrayEquals(Board.getBoard(),defaultBoard, "initial board matches is as expected");
    }
    @Test
    public void setSquareTest(){
        char[] expectedBoard = { '1', 'x', 'x','4', '5', '6','7', '8', '9' };
        Board.setSquare(1, currentPlayer);
        Board.setSquare(2, currentPlayer);
        assertArrayEquals(Board.getBoard(), expectedBoard);
    }
    @Test
    public void getSquareTest(){
        assertEquals(Board.getSquare(4), '5');
    }
}
