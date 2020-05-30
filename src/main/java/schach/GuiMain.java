package schach;

import game.StartGame;
/**
 * no changes made yet
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuiMain extends Application {
	/**
	 * method to launch GUI
	 */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Startscreen");
        Button btn = new Button();
        btn.setText("new game");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                startOptions(primaryStage);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
    }
    public void startOptions(Stage primaryStage) {
        primaryStage.setTitle("Options");
        Button btn = new Button();
        btn.setText("start game");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	startGame(primaryStage);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
    }
    public void startGame(Stage primaryStage) {
        primaryStage.setTitle("Chess");
        Button btn = new Button();
        btn.setText("todo");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	start(primaryStage);
            }
        });  
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
    }
}
