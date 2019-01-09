/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Program creates a replica of Snake Square on a snakes and ladders board.
 * @author Andrew
 */
public class SnakeSquare extends SorLSquare{
    
    /**
     * The constructor for the snake square, has a restriction that requires the end square be less than the start point.
     * @param number The start point and location of the square.
     * @param endSquare The point that the player will be moved to after landing on the square.
     */
    public SnakeSquare(int number, int endSquare){
        super(number, endSquare);
        if(endSquare >= number){
            throw new IllegalArgumentException("Oops! This snake goes up!");
        }
    }
    
    /**
     * 
     * @return returns the square that the player will land on after landing on the start point of the square.
     */
    public int landOn(){
        return this.getEndSquare();
    }
    
    /**
     * The toString for the SnakeSquare Class
     * @return returns the formated start and endpoint for the square.
     */
    public String toString(){
        return this.getNumber() + "-" + this.getEndSquare();
    }
}
