package schach;


import javafx.application.Application;

import javafx.stage.Stage;


/**
 * Main Class
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it2
 */

public class GuiMain extends Application {

	/**
	 * main-method for the game
	 * @param args
	 */
    public static void main(String[] args) {
        launch(args);
    }
    
  
    
    /**
     * startscreen of the game
     * @param primaryStage main stage
     */
    public void start(Stage primaryStage) {
    	GuiController gc = new GuiController();
    	gc.start(primaryStage);
    }
    
    
    
 
   
	}
