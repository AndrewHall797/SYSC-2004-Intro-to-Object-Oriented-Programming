
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This program runs a main file that emulates a flash cards test for spelling.
 * @author Andrew
 */
public class LanguageFlashCardApplication {
    
    /** Runs a program that emulates flash cards for words and gets the questions and answers from an uploaded cvs file.
     * 
     * @param args
     * @throws IOException If the a file name is entered that does not exist
     */
    public static void main( String args[]) throws IOException{
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        
        // Starts the game
        LanguageFlashCards game = new LanguageFlashCards(scanner.nextLine());
        game.reset();
        
        boolean play = true;
        
        // Runs while the game is still being played and while the user still wants to see another card.
        while(game.hasNext() == true && play == true){
            
            game.nextCard();
            System.out.println("Score = " + game.getScore());
            System.out.println("Next? (Y/N)");
            
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
