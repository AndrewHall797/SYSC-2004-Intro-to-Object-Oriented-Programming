
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Runs a GUI of a game of ConnectFour
 * @author Andrew
 */
public class ConnectFourApplication extends Application implements Observer{
    
    private final static int NUM_COLUMNS = 8;
    private final static int NUM_ROWS = 8;
    private final static int NUM_TO_WIN = 4;
    private final static int BUTTON_SIZE = 20;
    
    private ConnectFourGame gameEngine;
    private ConnectButton[][] buttons;
    private int row;
    private int column;
    
    /**
     * Main method that launches the GUI.
     * @param args 
     */
    public static void main(String args[]) {

        launch(args);  
       
    }
    
    /**
     * Creates the feel and view of the GUI.
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage){
        
        this.gameEngine = new ConnectFourGame(NUM_ROWS,NUM_COLUMNS,NUM_TO_WIN,ConnectFourEnum.BLACK);
        gameEngine.addObserver(this);
        buttons = new ConnectButton[NUM_ROWS][NUM_COLUMNS];
        TextField currPlayer = new TextField();
        currPlayer.setEditable(false);
        currPlayer.setText(gameEngine.getTurn().toString() + " begins.");
        
        
        for(int i = 0; i < NUM_ROWS; i++){
            for(int j = 0; j < NUM_COLUMNS; j++){
                buttons[i][j] = new ConnectButton( (ConnectFourEnum.EMPTY).toString() , i ,j);
                buttons[i][j].setMinHeight(20);
                buttons[i][j].setMaxWidth(Double.MAX_VALUE);
                buttons[i][j].setOnAction(new ButtonHandler(buttons[i][j]));
            }
        }
        
        Button turn = new Button("Take My Turn");
        turn.setOnAction( new EventHandler<ActionEvent>(){
           /**
            * The event handler for the take turn button which drops the checker on the board.
            * @param event 
            */
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Drop checker");
                gameEngine.takeTurn(row,column);
                currPlayer.setText("It's " + gameEngine.getTurn().toString() + "'s turn.");
                
                
            }
            
        });
        
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        
        for(int i = 0; i < NUM_ROWS; i++){
            for(int j = 0; j < NUM_COLUMNS; j++){
                grid.add( buttons[i][j] ,j , 7-i);
            }
        }
        
        root.setTop(currPlayer);
        root.setBottom(turn);
        root.setCenter(grid);
        
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    /**
     * 
     * @param o The Observable object being passed in this case is the gameEngine. 
     * @param arg The ConnectMove object which tells the GUI which button to update and what to.
     */
    @Override
    public void update(Observable o, Object arg) {
        ConnectMove move = (ConnectMove)arg;
        this.buttons[move.getRow()][move.getColumn()].setText(move.getColour().toString());
        
        
        if(this.gameEngine.getGameState() != ConnectFourEnum.IN_PROGRESS){
            Alert alert = new Alert(AlertType.INFORMATION);
            
            if(this.gameEngine.getGameState() != ConnectFourEnum.DRAW){
                alert.setContentText(this.gameEngine.getGameState().toString() + " WINS");
            }else{
                alert.setContentText(this.gameEngine.getGameState().toString());
            }
            
            alert.setTitle("Information Alert");
            alert.setHeaderText("Game Over");
            alert.showAndWait();
            this.gameEngine.reset(ConnectFourEnum.BLACK);
            
            for(int i = 0; i < NUM_ROWS; i++){
                for(int j = 0; j < NUM_COLUMNS; j++){
                    buttons[i][j].setText(ConnectFourEnum.EMPTY.toString());
            }
        }
            
        }
    }
    
    
    /**
     * Public class ButtonHandler is the EventHandler for all the buttons on the grid.
     * If pressed it highlights and records the coordinates of the button selected by the user.
     */
    class ButtonHandler implements EventHandler{
        
        private ConnectButton button;
        
        /**
         * Constructor for the EventHandler for each button to allow for variables to be brought in.
         * @param button the selected button by the user.
         * @param obs the refrence to the public class. 
         */
        public ButtonHandler(ConnectButton button){
            this.button = button;
        }
        
        /**
         * The handler for when a button on the grid is pressed is records the coordinates of selected button.
         * @param event 
         */
        @Override
        public void handle(Event event) {
            System.out.println(this.button.toString());
            row = this.button.getRow();
            column = this.button.getColumn();
        }
        
    }
}
