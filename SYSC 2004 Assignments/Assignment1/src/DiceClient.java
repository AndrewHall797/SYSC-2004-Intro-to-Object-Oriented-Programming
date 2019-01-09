/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Program creates a histogram of random dice rolls and provides the average dice rolls 
 * and standard deviation of the dice rolls.
 * 
 * @author Andrew
 */

import java.lang.Math;
public class DiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Creates a histogram of 2000 random dice rolls for two dice and gives the
         * mean and standard deviation of the dice.
         */
        Dice dice = new Dice();
        double sum = 0;
        double sq_diff_sum = 0;
        int[] rolls = new int[6];
        
        for(int i = 0; i < 2000;i++){
            sum += dice.roll();
            for(int j = 0; j < 6;j++){
                if(dice.getDieValues()[0] == (j + 1) || dice.getDieValues()[1] == (j + 1) ){
                    rolls[j] += 1;
                }
            }
        }
        
        double mean = sum/4000;
        for(int i=0; i<2000; i++){
            sq_diff_sum = (dice.getDieValues()[0] - mean)*(dice.getDieValues()[0] - mean);
            sq_diff_sum = (dice.getDieValues()[1] - mean)*(dice.getDieValues()[1] - mean);
        }
        
        
        System.out.println("The average roll was " + mean);
        System.out.println("The standard deviation of the rolls was " + Math.sqrt(sq_diff_sum));
        
        for(int i = 0; i < 6; i++){
            System.out.print( (i + 1) +"(" + rolls[i] + ") :");
            for(int j = 0; j < (rolls[i]/10) ;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
