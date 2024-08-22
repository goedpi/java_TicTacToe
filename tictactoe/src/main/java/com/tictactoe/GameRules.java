package com.tictactoe;

public class GameRules {
 
 
    public boolean checkWinner(board gameBoard, player currentPlayer){
        if ((gameBoard.getSquare(0) + gameBoard.getSquare(1) + gameBoard.getSquare(2) == (currentPlayer.getSymbol() * 3)) // first row
        || (gameBoard.getSquare(3) + gameBoard.getSquare(4) + gameBoard.getSquare(5) == (currentPlayer.getSymbol() * 3)) // second row
        || (gameBoard.getSquare(6) + gameBoard.getSquare(7) + gameBoard.getSquare(8) == (currentPlayer.getSymbol() * 3)) // third row
        || (gameBoard.getSquare(0) + gameBoard.getSquare(3) + gameBoard.getSquare(6) == (currentPlayer.getSymbol() * 3)) // first column
        || (gameBoard.getSquare(1) + gameBoard.getSquare(4) + gameBoard.getSquare(7) == (currentPlayer.getSymbol() * 3)) // second column
        || (gameBoard.getSquare(2) + gameBoard.getSquare(5) + gameBoard.getSquare(8) == (currentPlayer.getSymbol() * 3)) // third column
        || (gameBoard.getSquare(0) + gameBoard.getSquare(4) + gameBoard.getSquare(8) == (currentPlayer.getSymbol() * 3)) // first diagonal
        || (gameBoard.getSquare(2) + gameBoard.getSquare(4) + gameBoard.getSquare(6) == (currentPlayer.getSymbol() * 3)) // second diagonal
        ) {
            return true;
        } else {
            return false;
        }
 }
 public boolean validateInput(int SquareToPlay, player currentPlayer, board gameBoard){
    boolean validInput = false;
            if (SquareToPlay < 1 || SquareToPlay > 9 ) {      
                System.out.println("Invalid input. Please enter a number between 1 and 9.\n");
                System.out.printf("Choose a square player %s: \n", currentPlayer.getName());
            } else if (gameBoard.getSquare(SquareToPlay-1) == 'o' || gameBoard.getSquare(SquareToPlay-1)== 'x') {
                System.out.println("This square is taken. Please try another one \n");
                System.out.printf("Choose a square player %s: \n", currentPlayer.getName());
                gameBoard.printBoard();
            } else{
                gameBoard.setSquare(SquareToPlay, currentPlayer);
                validInput = true; 
            }
            return validInput;
        } 
    }
    
    
 



/** 
public boolean validateSetSquare(int squareToPlay, Scanner input){
    while (validInput == false) {
        try {
            squareToPlay = input.nextInt();
            if (squareToPlay < 1 || squareToPlay > 9 ) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                System.out.printf("Choose a square player %s:", currentPlayer.getName());
            } else if(getSquare(squareToPlay - 1) == 'o' || getSquare(squareToPlay - 1) == 'x'){
                System.out.println("This square is taken. Please try another one");
                System.out.printf("Choose a square player %s:", currentPlayer.getName());
                printBoard();
            } else{
                setSquare(squareToPlay-1, currentPlayer);
                //NumSquaresPlayed++;
                validInput=true;
            }
        }  catch (Exception e) {
            System.out.println("Input is not a number. Please enter a number between 1 and 9");
            System.out.printf("Choose a square player %s:", currentPlayer.getName());
            scanner.next();
        }
       
    }
    return validInput;
}
    */