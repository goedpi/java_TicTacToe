package com.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameRulesTest {
    player player1 = new player("John", 'x');
    GameRules gameRules = new GameRules();
    board gameBoard = new board();
   @Test
    public void checkWinnerRowTest(){
        char[] board = {'x', 'x', 'x', '4', '5', '6', '7', '8', '9'};
        gameBoard.setBoard(board);
        assertTrue(gameRules.checkWinner(gameBoard, player1), "Player won by horizontal Row");
    }
    @Test
    public void checkWinnerColTest(){
        char[] board = {'x', 'o', 'o', 'x', '5', '6', 'x', '8', '9'};
        gameBoard.setBoard(board);
        assertTrue(gameRules.checkWinner(gameBoard, player1), "Player won by Vertical line");
    }
    @Test
    public void checkWinnerDiagonalTest(){
        char[] board = {'x', 'o', 'o', 'o', 'x', '6', '7', '8', 'x'};
        gameBoard.setBoard(board);
        assertTrue(gameRules.checkWinner(gameBoard, player1), "Player won by diagonal line");
    }
    @Test
    public void checkWinnerNoWinnerTest(){
        char[] board = {'x', 'o', 'x', 'x', 'o', '6', '7', '8', '9'};
        gameBoard.setBoard(board);
        assertFalse(gameRules.checkWinner(gameBoard, player1), "No Winners");
    }
   
    @ParameterizedTest
    @CsvSource({
        "1, true", 
        "10, false",
        "0, false",
        "2, true",
        "9, false",
        "8, false"
    })
    public void validateInvalidInputTest(int squareToPlay, boolean expectedResult){
        board gameBoard = new board();
        char[] board = {'1', '2', '3',
                        '4', '5', '6',
                        '7', 'o', 'x'};
        gameBoard.setBoard(board);
        boolean isValid = gameRules.validateInput(squareToPlay, player1, gameBoard);
        assertEquals(expectedResult, isValid, "Unexpected result for SquareToPlay: " + squareToPlay);
    }

    

}
