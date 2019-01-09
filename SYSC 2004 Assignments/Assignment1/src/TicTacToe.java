/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Program creates a model of a game of tictactoe.
 * 
 * @author Andrew
 */
import java.util.Scanner;

public class TicTacToe {
    private int nRows;
    private int nColumns;
    private int numToWin;
    private char grid[][];
    private char turn;
    private TicTacToeEnum gameState;
    private int nMarks;
    
    public TicTacToe(char initialTurn){
        /**
         * Creates a TicTacToe object and initializes a default 3 by 3 table.
         * 
         * @param initialTurn selects which player gets to go first.
         */
        this.nRows = 3;
        this.nColumns = 3;
        this.numToWin = 3;
        this.grid = new char[nRows][nColumns];
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++ ){
                grid[i][j] = ' ';
            }
        }
        this.turn = initialTurn;
        this.gameState = TicTacToeEnum.IN_PROGRESS;
        this.nMarks = 0;
    }
    
    public TicTacToe(int nRows, int nColumns, int numToWin, char initialTurn){
        /**
         * Creates a TicTacToe object with a table the size of the users choosing.
         * 
         * @param nRows allows the user to decide on the number of rows in the table.
         * @param nColumns allows the user to set the number of columns in the table.
         * @param numToWin the amount of objects in a row to win the game.
         * @param initialTurn selects which player gets to go first.
         */
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.grid = new char[nRows][nColumns];
        for(int i = 0; i < this.nRows; i++){
            for(int j = 0; j < this.nColumns; j++ ){
                this.grid[i][j] = ' ';
            }
        }
        this.turn = initialTurn;
        this.gameState = TicTacToeEnum.IN_PROGRESS;
        this.nMarks = 0;
    }
    
    public void reset(char intialTurn){
        /**
         * Method resets the game back to its default values.
         * 
         * @param initialTurn selects which player gets to go first.
         */
        for(int i = 0; i < this.nRows; i++){
            for(int j = 0; j < this.nColumns; j++ ){
                this.grid[i][j] = ' ';
            }
        }
        this.turn = intialTurn;
        this.gameState = TicTacToeEnum.IN_PROGRESS; 
        this.nMarks = 0;
        
    }
    
    public int getTurn(){
        /**
         * @return the player who has the current turn. 
         */
        return this.turn;
    }
    
    public TicTacToeEnum getGameState(){
        /**
         * @return the current state of the game, if either player has won or if it is still being played.
         */
        return this.gameState;
    }
    
    public TicTacToeEnum charToEnum(char player){
        /**
         * Converts the char of the player and then informs the program if a player has won the game.
         * 
         * @param player enters the char of the player who has won.
         * 
         * @return the Enum of the player who has won to end the game.
         */
        if(player == 'X'){
            return this.gameState.X_WON;
        }else if(player == 'O'){
            return this.gameState.O_WON;
        }else {
        return this.gameState.IN_PROGRESS;
        }
    }
    
    public TicTacToeEnum takeTurn(int row, int column){
        /**
         * Records a turn by a player and then checks to see if any players had won.
         * 
         * @param row indicates the row the player wants to enter a value.
         * @param column indicates the column the player wants to enter a value.
         * 
         * @return the the state of the game.
         */
        if(row >=0 &&row < this.nRows && column< this.nColumns && column >=0 && this.grid[row][column] == ' '){
            
            this.grid[row][column] = this.turn;
            this.gameState = findWinner();
            
            if(this.turn == 'X'){
                this.turn = 'O';
            }else{
                this.turn = 'X';
            }
            
        }else{
            System.out.println("You selected a row or column which is out of bounds or a spot which already contains an input! Pleas enter again.");
        }
        return this.gameState;
    }
    
    private TicTacToeEnum findWinner(){
        /**
         * Checks to see if any players have won the game.
         * 
         * @return the result if anybody won the game or if the game is still in progress.
         */
        int numInRow = 0;
        int numInColumn = 0;
        boolean allFill = true;
        
        //Checks to see if any Rows all have the same value.
        for(int i = 0; i < this.nRows;i++){
            for(int j = 0; j < this.nColumns;j++){
                if(this.grid[i][j] == this.turn){
                    numInRow++;
                }
            }
            if(numInRow >= this.numToWin){
                return charToEnum(this.turn);
            }else{
                numInRow = 0;
            }
        }
        //Checks to see if any columns have the same value.
        for(int i = 0; i<this.nColumns;i++){
            for(int j = 0; j< this.nRows;j++){
                if(this.grid[j][i] == this.turn){
                    numInColumn++;
                }
            }
            if(numInColumn >= this.numToWin){
                return charToEnum(this.turn);
            }else{
                numInColumn = 0;
            }
        }
        //Checks to see if the entire board game is filled, if so it cuts the game at a draw.
        for(int i = 0; i <this.nRows;i++){
            for(int j = 0; j <this.nColumns;j++){
                if(this.grid[i][j] == ' '){
                    allFill = false;
                }
            }
        }
        if(allFill == true){
            return this.gameState.DRAW;
        }
        //If no other test has been completed the program determines the game is still on.
        return this.gameState.IN_PROGRESS;
    }
    
    public String toString(){
        String board = new String();
        for(int i = 0; i< this.nRows; i++){
            for(int j = 0; j< this.nColumns; j++){
                board  += (this.grid[i][j] + " | ");
            }
            board += "\n";
        }
        return board;
    }
    
    public static void main(String args[]) {
        /**
         * Runs a game of tictactoe.
         */
        TicTacToe game = new TicTacToe('X');
        Scanner scanner = new Scanner(System.in);

        do { 
            System.out.println(game.toString());
            System.out.println((char)game.getTurn() + 
                ": Where do you want to mark? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            scanner.nextLine();
            game.takeTurn(row, column);
            
        } while (game.getGameState() == TicTacToeEnum.IN_PROGRESS);
        System.out.println( game.getGameState());
       
    }

    
}
