/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * An object to simplify how the coordinates are sent to the observer.
 * @author Andrew
 */
public class ConnectMove {
    
    private int row;
    private int column;
    private ConnectFourEnum colour;
    
    /**
     * A constructor for the ConnectMove object.
     * @param row the row of the button to selected.
     * @param column the column of the button to be selected.
     * @param colour indicated what player checked the button.
     */
    public ConnectMove(int row, int column, ConnectFourEnum colour){
        this.row = row;
        this.column = column;
        this.colour = colour;
    }
    
    /** 
     * Gives the user the row that the button is contained in.
     * @return the row of the of the button.
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Gives the column that the button is contained in.
     * @return the column of the button.
     */
    public int getColumn(){
        return this.column;
    }
    
    /**
     * Gives the user the person who pressed the button.
     * @return the color of the player that selected the button.
     */
    public ConnectFourEnum getColour(){
        return this.colour;
    }
}
