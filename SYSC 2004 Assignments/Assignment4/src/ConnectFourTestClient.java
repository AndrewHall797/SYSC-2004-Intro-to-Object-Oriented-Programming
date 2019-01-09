
import java.util.Scanner;
import static javafx.application.Application.launch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A test client for a game of Connect four done through the output of the program and with a string.
 * @author Andrew
 */
public class ConnectFourTestClient {
    
    private final static int NUM_COLUMNS = 8;
    private final static int NUM_ROWS = 8;
    private final static int NUM_TO_WIN = 4;
    private final static int BUTTON_SIZE = 20;
    
    private ConnectFourGame gameEngine;
    private ConnectButton[][] buttons;
    private int row;
    private int column;
    
    /**
     * The main method that runs the game until is is won or a draw occurs.
     * @param args 
     */
    public static void main(String args[]) {
 
        ConnectFourGame game = new ConnectFourGame(NUM_ROWS,NUM_COLUMNS,NUM_TO_WIN,ConnectFourEnum.BLACK);
        Scanner scanner = new Scanner(System.in);

        do { 
            System.out.println(game.toString());
            System.out.println(game.getTurn() + ": Where do you want to mark? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            scanner.nextLine();
            game.takeTurn(row, column);
            
        } while (game.getGameState() == ConnectFourEnum.IN_PROGRESS);
        System.out.println( game.getGameState());
       
    }
    
}
