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
    board gameBoard = new board();
    @BeforeEach
    public void setupPlayer(){
        String input = "John\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        player player1 = new player(scanner);
        player1.configurePlayer(1, 'x');
        currentPlayer = player1;
    }
    }
    

