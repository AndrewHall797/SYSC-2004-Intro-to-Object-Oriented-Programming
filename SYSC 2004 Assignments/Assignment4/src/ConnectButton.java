
import javafx.scene.control.Button;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * An object for the buttons on the grid of the GUI.
 * @author Andrew
 */
public class ConnectButton extends Button{
    
    private int row;
    private int column;
    
    /**
     * The constructor for the button on the GUI.
     * @param label indicates if the button is checked by a player or if it is empty.
     * @param row the row of the current button.
     * @param column the column of the current button.
     */
    public ConnectButton(String label , int row, int column){
        super(label);
        this.row = row;
        this.column = column;
    }
    
    /**
     * 
     * @return the row of the button. 
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * 
     * @return the column of the button. 
     */
    public int getColumn(){
        return this.column;
    }
    
    /**
     * Creates a string which states the row and column location of the button.
     * @return a string which contains the row and column of the button.
     */
    public String toString(){
        return ("(<" + this.row + ">,<" + this.column + ">)");
    }
    
}
