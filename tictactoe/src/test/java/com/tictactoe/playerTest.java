package com.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class playerTest {
 @Test
 public void playerSetupTest(){
  
   String input = "John\n";
   ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
   Scanner scanner = new Scanner(in);

   // Create a player object with the simulated scanner
   player player1 = new player(scanner);

    player1.configurePlayer(1, 'o');
    
    assertEquals("John", player1.getName());
    assertEquals('o', player1.getSymbol());  
   }


}
