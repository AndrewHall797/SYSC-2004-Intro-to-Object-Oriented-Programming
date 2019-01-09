/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Program creates a replica board of the game Snakes and Ladders
 * @author Andrew
 */

import java.util.HashMap;
        
public class SnakesAndLadders {
    public static int  NUM_PLAYERS;
    public static final int  NUM_SQUARES = 100;
    private SnLSquare[] board;
    private Dice dice;
    private int[] players;
    
    /**
     * SnakesAndLadders is the constructor for the snake and ladders game. It initializes all required objects and variables to play.
     * @param nPlayer designates the amount of players that the user wants to have in the game.
     */
    public SnakesAndLadders(int nPlayer){
        NUM_PLAYERS = nPlayer;
        board = new SnLSquare[NUM_SQUARES];
        players = new int[NUM_PLAYERS];
        for(int i = 0; i < NUM_PLAYERS; i++){
            players[i] = 1;
        }
        dice = new Dice();
        int ladderPoint = 0;
        int snakePoint = 0;
        
        int[] ladderStart = {4,9,20,28,40,63,71};
        int[] ladderEnd = {14,31,38,84,59,81,91};
        int[] snakeStart = {54,62,64,87,93,95,99};
        int[] snakeEnd = {34,18,60,24,73,75,78};
        
        for(int i = 0; i < NUM_SQUARES; i++){
            if(ladderPoint < ladderStart.length &&  (i+1) == ladderStart[ladderPoint]){
                board[i] = new LadderSquare(ladderStart[ladderPoint] , ladderEnd[ladderPoint]);
                ladderPoint++;
            }else if(snakePoint < snakeStart.length && (i+1) == snakeStart[snakePoint]){
                board[i] = new SnakeSquare(snakeStart[snakePoint] , snakeEnd[snakePoint]);
                snakePoint++;
            }else{
                board[i] = new SnLSquare(i+1);
            }
        }
        
    }
    
    /**
     * SnakesAndLadders creates the default amount of players which is two if not given an value for the amount of players.
     */
    public SnakesAndLadders(){
        this(2);
    }
    
    /**
     * takeTurn controls the logic for a player taking a turn in the game.
     * It generates a random number the player will move by and then sees what type of square the player landed on and moves them up or down.
     * @param player picks the players that is being moved for that turn.
     * @return returns true if the number rolled is a double and false if it is not.
     */
    public boolean takeTurn(int player){
        int roll = dice.roll();
        System.out.println("player " + player + " rolled " + roll);
        int[] diceValues = dice.getDieValues();
        if((players[player] + roll) > 100){
            players[player] = 100 - ((players[player] + roll) - 100);
        }else{
            players[player] += roll;
        }
        
        if(board[players[player]-1] instanceof SorLSquare){
            players[player] = ((SorLSquare)board[players[player]-1]).getEndSquare();
        }
        
        if(diceValues[0] == diceValues[1]){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * isPlayerWinner checks to see if the player picked is the winner of the game.
     * @param player chooses the player to be checked if their a winner.
     * @return returns true if the player is the winner and false if they are not.
     */
    public boolean isPlayerWinner(int player){
        
        if(players[player] == 100){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * This function tells the user what player one the game.
     * @return returns the number of the player who won the game , if there is no winner it returns -1.
     */
    public int getWinner(){
        for(int i = 0; i < NUM_PLAYERS; i++){
            if(players[i] == 100){
                return i;
            }
        }
        
        return -1;
        
    }
    
    /**
     *  getPlayersPosition Gives the position of the player.
     * @param player the chosen player
     * @return returns the position of the player.
     */
    public int getPlayerPosition(int player){
        return players[player];
    }
    
    /**
     * the toString method for the SnakesAndLadders CLass
     * @return returns the layout of the entire board will all the squares. 
     */
    public String toString(){
        String s = new String();
        int increment = 0;
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                s += ("| " + board[increment].toString()); 
                increment ++;
            }
            s += "\n";
        }
        
        return s;
    }
    
    /**
     * toStringCurrentPosition tells the user the players current position.
     * @return returns the current players position.
     */
    public String toStringCurrentPositions(){
        String s = new String();
        for(int i = 0; i < NUM_PLAYERS; i++){
            s += (i + ":" + players[i] + " ");
        }
        return s;
    }
    
    /**
     * The main method of the game, runs the game until on of the players wins.
     * @param args 
     */
    public static void main(String args[]){
        SnakesAndLadders game = new SnakesAndLadders(7);
        System.out.print(game.toString());
        boolean isDouble = false;
        boolean isWinner = false;
        int winPlayer = -1;
        
        for(int i = 0; isWinner == false; i++){
               
            // Checks to see if the player index is greter than the number of indexes in 
            //the array of player if so it resets back to zero to reset the turns.
            if(i == NUM_PLAYERS){
                i = 0;
            }
            isDouble = game.takeTurn(i);
                
            // Prints out the positions of all the players after a move.
            for(int j = 0; j < NUM_PLAYERS; j++){
                System.out.print(j + ":" + game.getPlayerPosition(j) + " ");
            }
            System.out.println();
                
            // Reruns the players turn aslong as they roll a double.
            while(isDouble == true){
                isDouble = game.takeTurn(i);
                    
                for(int j = 0; j < NUM_PLAYERS; j++){
                    System.out.print(j + ":" + game.getPlayerPosition(j) + " ");
                }
                System.out.println();
            }
                
            //Chekcs to see if the current player has won the game and then increments to the next players turn.
            isWinner = game.isPlayerWinner(i);
            if(isWinner == true) winPlayer = game.getWinner();  

        }
        
        System.out.println("Player " + winPlayer + " won!");
    }
    
}
