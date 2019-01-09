/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * used to run a flash card game for multiplication tables.
 * Uses the AbstractFlashCards class to run use full methods.
 * @author Andrew
 */
public class MultiplicationFlashCards extends AbstractFlashCards {
    
    /**
     * Constructor for the set of question and answers for the flash cards.
     * @param multiplier Takes in the value for the multiplication table from 1 to 12.
     */
    public MultiplicationFlashCards(int multiplier){
        
        String s1 = null;
        
        for(int i = 1; i < 13; i++){
           s1 = i + " X " + multiplier;
           this.addCard(s1, Integer.toString(i*multiplier));
        }
    }
    
    /**
     * 
     * @param multipliers Takes in an array of values and creates questions for all the different numbers entered.
     */
    public MultiplicationFlashCards(int []multipliers){
        
        String s1 = null;
        
        for(int i = 0; i < multipliers.length; i++){
    
            for(int j = 1; j < 13; j++){
                
                s1 = j + " X " + multipliers[i];
                this.addCard(s1, Integer.toString(j*multipliers[i]));
            }
        
        }
    }
}
