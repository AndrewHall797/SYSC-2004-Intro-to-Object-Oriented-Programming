/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Program creates a replica of a ladder square on a snakes and ladders board.
 * @author Andrew
 */
public class LadderSquare extends SorLSquare{
    
    /**
     * The constructor for the LadderSquare, has a restriction that requires the end square be greater than the start point.
     * @param number The Start point of the square.
     * @param endSquare The endpoint of the square.
     */
    public LadderSquare(int number, int endSquare){
        super(number, endSquare);
        if(endSquare <= number){
            throw new IllegalArgumentException("Oops! This ladder goes down!");
        }
    }
    
    /**
     * 
     * @return returns the location the player will be moved to after landing on the square.
     */
    public int landOn(){
        return this.getEndSquare();
    }
    
    /**
     * The toString for the LadderSquare class.
     * @return returns the formated start and end points of the square.
     */
    public String toString(){
        return this.getNumber() + "+" + this.getEndSquare();
    }
}
