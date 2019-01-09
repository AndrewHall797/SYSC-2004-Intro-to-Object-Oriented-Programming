/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Program creates a replica of a ladder and a snake on the board.
 * @author Andrew
 */
public class SorLSquare extends SnLSquare {
    private int endSquare;
    
    /**
     * The constructor for a SorLSquare, this is the base class for the SnakeSquare and LadderSqauare
     * @param number provides the number of the square to be generated, its location.
     * @param endSquare provides the square this square will travel the player to, down a snake or up a ladder.
     */
    public SorLSquare(int number, int endSquare){
        super(number);
        this.endSquare = endSquare;
        
        if(number == endSquare){
            throw new IllegalArgumentException("Oops! The start and end point were the same");
        }
    }
    
    /**
     * 
     * @return returns the square the the current square will move the player to.
     */
    public int getEndSquare(){
        return this.endSquare;
    }
    
    /**
     * 
     * @return returns the square the player will be moved to.
     */
    public int landOn(){
        return this.endSquare;
    }
    
    /**
     * 
     * @return returns the formated location of the current square and the square that the player will be moved to.
     */
    public String toString(){
        return super.toString() + ":" + this.endSquare;
    }
    
    /**
     * The equals method for the SoRLSquare, is also used for the SnakeSquare and LadderSquare.
     * This was done to reduce the amount of code written. This works for both classes as it checks the same instance variables between the two classes.
     * There is also no errors when differentiating between the different classes as a SnakeSquare and LadderSquare cannot have the same endpoints due to their restrictions in their constructors.
     * The SnakeSqaure requires the endpoint to be less than the start point and the LadderSquare requires the endpoint be greater than the start point, this means that a Snake Square can never be equal to a Ladder Square.
     * @param o The object that will be compared to.
     * @return returns true if the objects are the same and false if they are not.
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
        
        SorLSquare s = (SorLSquare)o;
        
        return(s.endSquare == this.endSquare && super.equals(s));
    }
}
