package com.tictactoe;
import java.util.Scanner;

public class player {
    private String name; 
    private char symbol;
    private Scanner scanner;

    public player(Scanner scanner){
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    // public String obtainName(int PlayerNumber){
    //     System.out.println("Whats your name player " + PlayerNumber);
        
    //     return name=scanner.next();
    // }
    public void configurePlayer(int playerNumber, char symbol){
        
        System.out.println("Whats your name player " + playerNumber);
        String nameSet = scanner.next();

        setName(nameSet);
        setSymbol(symbol);
    }
}
