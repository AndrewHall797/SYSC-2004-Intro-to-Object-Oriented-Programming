/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Program creates a model pair or more of dice
 * 
 * 
 * @author Andrew
 * @Version 1.0
 */
import java.util.Random;
import java.util.Date;

public class Dice {
    private int[] dice;
    private Random random;
    
    public Dice(){
        /**
         * Creates an array of two dice objects.
         */
       this(2);
    }
    
    public Dice(int numDice){
        /**
         * Creates an array of requested dice objects and initializes them with random values.
         * 
         * @param numDice corresponds to the number of dice created in the array.
         */
        random = new Random(new Date().hashCode());
        if (numDice < 1) 
        throw new IllegalArgumentException ("Oops! You must enter more than one dice to be created!");
        
        this.dice = new int[numDice];
        for(int i = 0; i < this.dice.length; i++){
            dice[i] = (random.nextInt(6) + 1);
        }
    }
    
    public int roll(){
        /**
         * Assigns random values between 1 and 6 and inclusive for each of the dice objects in the array
         * and returns the sum of all the dices values.
         * 
         * @return an integer sum of the dices values.
         */
        int sum = 0;
        for(int i = 0; i < this.dice.length;i++){
            this.dice[i] = rollDie();
            sum += this.dice[i];
        }
        return sum;
    }
    
    private int rollDie(){
        /**
         * returns a random value between 1 and 6 inclusive.
         */
        return (random.nextInt(6) +1);
    }
    
    public int[] getDieValues(){
        /**
         * returns a copy array of the dice values. 
         * 
         * @return a copy array of the dices values.
         */
        int[] dice = new int[this.dice.length];
        for(int i = 0; i < this.dice.length; i++){
            dice[i] = this.dice[i];
        }
        return dice;
    }
    
    public boolean hasDoubles(){
        /**
         * Checks to see if there are any repeating values in the array of dice.
         * 
         * @return true if there are repeating values and false if there are no returning values.
         */
        for(int i = 0; i < this.dice.length; i++){
            for(int j = 0; j < this.dice.length;j++){
                if(dice[i] == dice[j]){
                    return true;
                }
            }
        }
        return false;
    }
    
    public String toString(){
        /**
         * Creates a string containing all the values of the dice in the array.
         * 
         * @return a string containing the values of all the dice in the array.
         */
        String diceValues = new String();
        
        for(int i = 0; i<this.dice.length;i++){
            diceValues += dice[i] + " ";
        }
        System.out.println(diceValues);
        return diceValues;
    }
}
