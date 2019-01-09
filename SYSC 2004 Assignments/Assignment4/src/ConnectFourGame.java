
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Runs the Logic for a game engine that contains methods to run a game of Connect Four
 * @author Andrew
 */
public class ConnectFourGame extends Observable{
    
    private int nColumns;
    private int nRows;
    private int numToWin;
    private ConnectFourEnum[][] grid;
    private ConnectFourEnum gameState;
    private ConnectFourEnum turn;
    
    /**
     * The default constructor for the board of a game of connect four.
     * @param initialTurn sets player who has the first turn. 
     */
    public ConnectFourGame(ConnectFourEnum initialTurn){
        this(8,8,4,initialTurn);
    }
    
    /**
     * The constructor for the the game engine which contains the logic for a game of connect four.
     * @param nRows the number of rows in the grid.
     * @param nColumns the number of columns in the grid.
     * @param numToWin the number of items in a row required to win.
     * @param initialTurn sets player who has the first turn.
     */
    public ConnectFourGame(int nRows , int nColumns , int numToWin , ConnectFourEnum initialTurn){
        
        this.nColumns = nColumns;
        this.nRows = nRows;
        this.numToWin = numToWin;
        this.grid = new ConnectFourEnum[nRows][nColumns];
        
        for(int i = 0; i < this.nRows; i++){
            for(int j = 0; j < this.nColumns; j++){
                grid[i][j] = ConnectFourEnum.EMPTY;
            }
        }
        
        this.gameState = ConnectFourEnum.IN_PROGRESS;
        this.turn = initialTurn;
    }
    
    /**
     * Resets the contents of the board of connect four back to empty.
     * @param initialTurn sets player who has the first turn.
     */
    public void reset(ConnectFourEnum initialTurn){
        
        for(int i = 0; i < this.nRows; i++){
            for(int j = 0; j < this.nColumns; j++){
                grid[i][j] = ConnectFourEnum.EMPTY;
            }
        }
        
        this.turn = initialTurn;
        this.gameState = ConnectFourEnum.IN_PROGRESS;
    }
    
    /**
     * Sets the checker on the place that the player placed it on the board.
     * If the button is not below anything or it is out of bounds the checker will not be placed.
     * @param row the row of the selected button.
     * @param column the column of the selected button.
     * @return the turn of the next player.
     */
    public ConnectFourEnum takeTurn(int row, int column){
        if(row >=0 && row < this.nRows && column< this.nColumns && column >=0 && this.grid[row][column] == ConnectFourEnum.EMPTY){
            
            if(row > 0 && this.grid[row - 1][column] == ConnectFourEnum.EMPTY){
                throw new IllegalArgumentException("You selected a spot with nothing below it! Pleas enter again.");
            }else{
                
                this.grid[row][column] = this.turn;
                this.gameState = findWinner(row+1);
                
                this.setChanged();
                this.notifyObservers(new ConnectMove(row,column,this.getTurn()));
            
                if(this.turn == ConnectFourEnum.BLACK){
                    this.turn = ConnectFourEnum.RED;
                }else{
                    this.turn = ConnectFourEnum.BLACK;
                }
            }

        }else{
            System.out.println("You selected a row or column which has a spot which already contains an input! Pleas enter again.");
        }
        
        return this.turn;
    }
    
    /**
     * Informs the user if the game is still being played.
     * @return the ConnectFourEnum of the state of the game.
     */
    public ConnectFourEnum getGameState(){
        return this.gameState;
    }
    
    /**
     * Returns the current users turn.
     * @return returns a ConnectFourEnum for who is playing.
     */
    public ConnectFourEnum getTurn(){
        return this.turn;
    }
    
    /**
     * Creates a string of the board at the current moment.
     * @return the string of the board.
     */
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
    
    /**
     * Figures out if there is a winner on the board, if it is a draw or if the game is still being played.
     * @param rowCeiliing indicated the row that the player has indicated so it only checks for blocks below the one selected.
     * @return returns the current turn of the user.
     */
    private ConnectFourEnum findWinner(int rowCeiliing){
        
        int numInRow = 0;
        int numInColumn = 0;
        boolean allFill = true;
        boolean seen = false;
        
        
        //Checks to see if any Rows all have the same value.
        for(int i = 0; i < rowCeiliing;i++){
            seen = false;
            for(int j = 0; j < this.nColumns;j++){
                if(this.grid[i][j] == this.turn && seen == true && this.grid[i][j-1] == this.turn){
                    numInRow++;
                }else if(this.grid[i][j] == this.turn && seen == false){
                    numInRow++;
                    seen = true;
                }else{
                    numInRow = 0;
                }
                
                if(numInRow >= this.numToWin){
                    return this.turn;
                }
            }
                numInRow = 0;
        }
        
        
        //Checks to see if any columns have the same value.
        for(int i = 0; i<this.nColumns;i++){
            seen = false;
            for(int j = 0; j< rowCeiliing;j++){
                if(this.grid[j][i] == this.turn && seen == true && this.grid[j-1][i] == this.turn){
                    numInColumn++;
                }else if(this.grid[j][i] == this.turn && seen == false){
                    numInColumn++;
                    seen = true;
                }else{
                    numInColumn = 0;
                }
                
                if(numInColumn >= this.numToWin){
                    return this.turn;
                }
                
            }
                numInColumn = 0;
        }
        
        //Checks to see if the entire board game is filled, if so it cuts the game at a draw.
        for(int i = 0; i <this.nRows;i++){
            for(int j = 0; j <this.nColumns;j++){
                if(this.grid[i][j] == ConnectFourEnum.EMPTY){
                    allFill = false;
                }
            }
        }
        
        if(allFill == true){
            System.out.println("Draw");
            return ConnectFourEnum.DRAW;
        }
        
        //If no other test has been completed the program determines the game is still on.
        return ConnectFourEnum.IN_PROGRESS;
    }
}
