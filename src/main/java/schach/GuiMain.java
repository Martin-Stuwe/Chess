package schach;

import game.StartGame;
/**
 * no changes made yet
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        // create chessboard
        GridPane board = new GridPane();     
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
        //define left side
        VBox leftVbox = new VBox();
        leftVbox.setSpacing(primaryScreenBounds.getHeight() /12);
        leftVbox.getChildren().add(new Label("8"));
        leftVbox.getChildren().add(new Label("7"));
        leftVbox.getChildren().add(new Label("6"));
        leftVbox.getChildren().add(new Label("5"));
        leftVbox.getChildren().add(new Label("4"));
        leftVbox.getChildren().add(new Label("3"));
        leftVbox.getChildren().add(new Label("2"));
        leftVbox.getChildren().add(new Label("1"));
        leftVbox.setPadding(new Insets(primaryScreenBounds.getHeight() /20,20,0,20));
        //define Bottom
        HBox bottomHbox = new HBox();
        bottomHbox.setSpacing(primaryScreenBounds.getHeight() /10.5);
        bottomHbox.getChildren().add(new Label("a"));
        bottomHbox.getChildren().add(new Label("b"));
        bottomHbox.getChildren().add(new Label("c"));
        bottomHbox.getChildren().add(new Label("d"));
        bottomHbox.getChildren().add(new Label("e"));
        bottomHbox.getChildren().add(new Label("f"));
        bottomHbox.getChildren().add(new Label("g"));
        bottomHbox.getChildren().add(new Label("h"));
        bottomHbox.setPadding(new Insets(0,0,primaryScreenBounds.getHeight()/10 -20,primaryScreenBounds.getHeight()/12));
        //add elements to BorderPane
        BorderPane border = new BorderPane();
        border.setTop(new Rectangle(primaryScreenBounds.getWidth(),primaryScreenBounds.getHeight() /10,Color.GREY));
        border.setBottom(bottomHbox);
        border.setLeft(leftVbox);
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
