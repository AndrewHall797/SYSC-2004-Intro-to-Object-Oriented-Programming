
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * An abstract class which all concrete methods that allow a user to create a flash cards application with the functions.
 * @author Andrew
 */
public abstract class AbstractFlashCards {
    
    private HashMap<String,String> flashCards;
    private ArrayList<String> unansweredCards;
    private int score;
    private Scanner scanner;
    private Random random;
    
    /**
     * Constructor for a AbstractFlashCards to be extended by another method and instantiates all the required variables.
     */
    public AbstractFlashCards(){
        this.flashCards = new HashMap<String,String>();
        this.unansweredCards = new ArrayList<String>();
        this.score = 0;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    
    /**
     * Adds a card to a stack of cards and constructs a hashmap with the corresponding questions and answer as well as a list of the questions.
     * @param question A string which contains a questions to be added to the hashmap.
     * @param answer A string which contains a answer to the added to an array list.
     */
    protected void addCard(String question , String answer){
        this.flashCards.put(question, answer);
        this.unansweredCards.add(question);
    }
    
    /**
     * Takes the current stack of cards and randomly reorganizes them back into the stack of cards.
     */
    public void reset(){
        this.score = 0;
        // It is understood that this rand varialbe did not be created, but it was to later make the code easier to read.
        int rand;
        //Creates an hashmap to store the randomized values and ensure that not duplicates are entered.
        HashMap<String,String> randQuestions = new HashMap<String,String>();
        
        //Adds questions in a random order until all the elements are added with no duplicates.
        while(randQuestions.size() < this.unansweredCards.size()){
            rand = random.nextInt(this.unansweredCards.size());
            randQuestions.put(this.unansweredCards.get(rand), null);
        }
        
        this.unansweredCards.clear();
        this.unansweredCards.addAll(randQuestions.keySet());
        System.out.println(this.unansweredCards.toString());
    }
    
    /**
     * Checks to see if there are any cards left in the stack.
     * @return If there are cards left in the stack returns true and returns false if there is not cards left.
     */
    public boolean hasNext(){
        if(this.unansweredCards.isEmpty() == true){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Selects the next card for the user to enter, if the user gets the answer right the card is removed from the stack, if
     * the user gets the answer wrong the card is randomly sorted back into the stack.
     * @return returns true if the user gets the answer right and false if they get it wrong.
     */
    public boolean nextCard(){
        
        System.out.println(this.unansweredCards.get(0));
        
        if(this.scanner.nextLine().equals(this.flashCards.get(unansweredCards.get(0))) ){
            
            System.out.println("Correct!");
            this.score++;
            this.unansweredCards.remove(0);
            return true;
            
        }else{
            
            int rand = random.nextInt(this.unansweredCards.size());
            String temp = this.unansweredCards.get(0);
            
            this.unansweredCards.remove(0);
            this.unansweredCards.add(rand, temp);
            System.out.println("Sorry, please try again");
            System.out.println(this.unansweredCards.toString());
            return false;
            
        }
    }
    
    /**
     * 
     * @return returns the score to the user. 
     */
    public int getScore(){
        return this.score;
    }
    
}
