
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Emulates a flash card test for times tables.
 * @author Andrew
 */
public class MultiplicationFlashCardApplication {
    
    /**
     * Runs a program that runs a game of flash cards for times tables until all the questions are answered or the user does not want to play.
     * @param args 
     */
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What times table are you testing?");
        String[] nums = scanner.nextLine().split(" ");
        int[] intNums = new int[nums.length];
        
        
        for(int i = 0; i < nums.length; i++){
            intNums[i] = Integer.parseInt(nums[i]);
        }
        
        // Decides on which constructor to use depending on th amount of numbers entered by the user.
        MultiplicationFlashCards game;
        if(intNums.length > 1){
            game = new MultiplicationFlashCards(intNums);
        }else{
            game = new MultiplicationFlashCards(intNums[0]);
        }
        
        game.reset();
        
        boolean play = true;
        
        // Runs the game until the user answers all the questins or the user no longer wants to play the game.
        while(game.hasNext() == true && play == true){
            
            game.nextCard();
            System.out.println("Score = " + game.getScore());
            System.out.println("Next? (Y/N)");
            
            System.out.println("You have a score of " + game.getScore());
            
            boolean rightAnswer = false;
            // Checks to see if the user enters y, if so the game continues and if n it exits the program. If the wrong input is entered it prompts the user again.
            while(rightAnswer == false){    
                
                String answer = scanner.nextLine().toLowerCase();
                if(answer.equals("n") == true){
                    
                    rightAnswer = true;
                    play = false;
                    System.out.println("Your score so far is " + game.getScore());
                }else if(answer.equals("y") == true){
                    
                    rightAnswer = true;
                }else{
                    
                    System.out.println("Sorry, thats the wrong input, please enter y or n, case does not matter.");
                }

            }
        }
    }
    
    
}

