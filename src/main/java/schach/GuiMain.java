package schach;

import game.StartGame;
/**
 * no changes made yet
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
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
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        GridPane board = new GridPane();
        Button btn = new Button();
        btn.setText("start game");
       
        final int size = 8 ;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                Rectangle Feld = new Rectangle(primaryScreenBounds.getHeight() /10,primaryScreenBounds.getHeight() /10);
                Paint color ;
                if ((row + col) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.BLACK;
                }
                Feld.setFill(color);
                board.add(Feld, col, row);
            }
        }
 
        BorderPane border = new BorderPane();
        border.setTop(new Rectangle(primaryScreenBounds.getWidth(),100,Color.GREY));
        border.setBottom(new Label("Bottom"));
        border.setLeft(new Label("Left"));
        border.setRight(new Label("Right"));
        border.setCenter(board);

        
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight()));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
}
