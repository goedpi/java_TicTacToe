package com.tictactoe;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.StringBuilder;
import java.io.FileWriter;

public class LogGameHistory {
    private player player1;
    private player player2;
    private board gamBoard;
    private int NumSquaresPlayed;

    public LogGameHistory(player player1, player player2, board gamBoard, int NumSquaresPlayed) {
        this.player1 = player1;
        this.player2 = player2;
        this.gamBoard = gamBoard;
        this.NumSquaresPlayed = NumSquaresPlayed;
    }
    
    public player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(player player1) {
        this.player1 = player1;
    }

    public player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(player player2) {
        this.player2 = player2;
    }

    public board getGamBoard() {
        return this.gamBoard;
    }

    public void setGamBoard(board gamBoard) {
        this.gamBoard = gamBoard;
    }

    public int getNumSquaresPlayed() {
        return this.NumSquaresPlayed;
    }

    public void setNumSquaresPlayed(int NumSquaresPlayed) {
        this.NumSquaresPlayed = NumSquaresPlayed;
    }
    private static void writeLogToFile(String log){
        try(FileWriter writer = new FileWriter("tictactoe/resources/game_results.txt", true)){
            writer.write(log);
        } catch (Exception e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
    
    public void logGameResult(String result){
        String timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        StringBuilder log = new StringBuilder();
        log.append("====================== Game Log " + timestamp + " ====================== ").append("\n\n");
        log.append("Game played on: ").append(timestamp).append("\n");
        log.append("Player 1: ").append(player1.getName()).append(" (").append(player1.getSymbol()).append(")\n");
        log.append("Player 2: ").append(player2.getName()).append(" (").append(player2.getSymbol()).append(")\n");
    
        log.append("Final Board:\n");
        char[] boardArray = gamBoard.getBoard();
        log.append(" ").append(boardArray[6]).append(" | ").append(boardArray[7]).append(" | ").append(boardArray[8]).append("\n");
        log.append(" - + - + - \n");
        log.append(" ").append(boardArray[3]).append(" | ").append(boardArray[4]).append(" | ").append(boardArray[5]).append("\n");
        log.append(" - + - + - \n");
        log.append(" ").append(boardArray[0]).append(" | ").append(boardArray[1]).append(" | ").append(boardArray[2]).append("\n");
        
        log.append("Result: ").append(result).append("\n");
        log.append("Number of moves: ").append(NumSquaresPlayed).append("\n\n");
        log.append("=======================================================================").append("\n\n");
        // Write the log to a file
        writeLogToFile(log.toString());
        // Optionally print to console
        System.out.println(log);
    }
}    

