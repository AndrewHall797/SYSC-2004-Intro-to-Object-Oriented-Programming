/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Program creates a model of a square on a Snakes and Ladders board game.
 * @author Andrew
 */
public class SnLSquare {
    private int number;
    
    /**
     * Constructor for the SnLSquare, this square is the default square on a snakes and ladder board.
     * @param number tells the constructor the number of the square on the board, its location. 
     */
    public SnLSquare(int number){
        this.number = number;
    }
    
    /**
     * 
     * @return the location number of the block.
     */
    public int getNumber(){
        return this.number;
    }
    
    /**
     * 
     * @return return the location this square will move the block too, since it a regular square does nothing, it does not move the player. 
     */
    public int landOn(){
        return this.number;
    }
    
    /**
     * Equals methods checks to see if the objects are equal to each other.
     * @param o is the object passed into the equals method to be compared with.
     * @return the boolean result of the comparison, returns true if they are the same and false if they are not.
     */
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        
        SnLSquare s = (SnLSquare)o;
        
        return(s.number == this.number);
    }
    
    /**
     * 
     * @return the printed out data of the square, its location. 
     */
    public String toString(){
        return "" + this.number;
    }
}
