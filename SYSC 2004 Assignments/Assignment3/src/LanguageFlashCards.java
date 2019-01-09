import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * used to run flash cards game for a spelling and language test.
 * Uses the AbstractFlashCards class to run use full methods.
 * @author Andrew
 */
public class LanguageFlashCards extends AbstractFlashCards {
    
    private final String COMMA_DELIMITER = ",";
    private String filename;
    
    /**
     * Constructor for the set of answers and questions for the flash cards game.
     * @param filename takes in the name of a file that can be read to enter the questions and answers from.
     * @throws IOException if the user enters an invalid file name.
     */
    public LanguageFlashCards(String filename) throws IOException{
        this.filename = filename;
        
        FileReader reader = null;
        BufferedReader buffered = null;
        ArrayList<String> question = new ArrayList<String>();
        ArrayList<String> answer = new ArrayList<String>();
        
        try{
            reader = new FileReader(this.filename);
            buffered = new BufferedReader(reader);
            
            buffered.readLine();
            String line;
            int i = 0;
            
            while((line = buffered.readLine()) != null){
               
                question.add(line.split(COMMA_DELIMITER)[0]);
                answer.add(line.split(COMMA_DELIMITER)[1]);
                
                this.addCard(question.get(i), answer.get(i));
                i++;
            }
            
            
            
        }catch(IOException e1){
            System.out.println(e1);
        }finally{
            buffered.close();
        }
    }
    
    
}
