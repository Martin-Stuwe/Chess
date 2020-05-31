package schach;

import game.Board;
import game.StartGame;
/**
 * no changes made yet
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	double screenHeight;
	double screenWidth;
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
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Button btn = new Button();
        btn.setText("start game");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	startGame(primaryStage);
            }
        });
        
        RadioButton white = new RadioButton("white");
        white.setSelected(true);
        RadioButton black = new RadioButton("black");
        final ToggleGroup color = new ToggleGroup();
        white.setToggleGroup(color);
        black.setToggleGroup(color);
        HBox colorbox = new HBox(100, white, black);
        
        RadioButton pla = new RadioButton("player vs player");
        RadioButton ai = new RadioButton("player vs ai");
        pla.setSelected(true);
        final ToggleGroup mode = new ToggleGroup();
        pla.setToggleGroup(mode);
        ai.setToggleGroup(mode);
        HBox modebox = new HBox(100, pla, ai);
        
        VBox option = new VBox();
        option.setSpacing(primaryScreenBounds.getHeight() /20);
        option.getChildren().add(colorbox);
        option.getChildren().add(modebox);
        option.getChildren().add(btn);
        option.setPadding(new Insets(primaryScreenBounds.getHeight() /3,primaryScreenBounds.getWidth() /3,primaryScreenBounds.getHeight() /3,primaryScreenBounds.getWidth() /3));
        
        StackPane root = new StackPane();
        root.getChildren().add(option);
        primaryStage.setScene(new Scene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight()));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
    public void startGame(Stage primaryStage) {
        primaryStage.setTitle("Chess");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        screenHeight =primaryScreenBounds.getHeight();
        screenWidth =primaryScreenBounds.getWidth();
        Board brett = new Board();
        brett.setStart();
        // create chessboard
        
        //define left 
        VBox leftVbox = new VBox();
        leftVbox.setSpacing(screenHeight /12);
        leftVbox.getChildren().add(new Label("8"));
        leftVbox.getChildren().add(new Label("7"));
        leftVbox.getChildren().add(new Label("6"));
        leftVbox.getChildren().add(new Label("5"));
        leftVbox.getChildren().add(new Label("4"));
        leftVbox.getChildren().add(new Label("3"));
        leftVbox.getChildren().add(new Label("2"));
        leftVbox.getChildren().add(new Label("1"));
        leftVbox.setPadding(new Insets(screenHeight /20,20,0,20));
        //define Bottom
        HBox bottomHbox = new HBox();
        bottomHbox.setSpacing(screenHeight/10.5);
        bottomHbox.getChildren().add(new Label("a"));
        bottomHbox.getChildren().add(new Label("b"));
        bottomHbox.getChildren().add(new Label("c"));
        bottomHbox.getChildren().add(new Label("d"));
        bottomHbox.getChildren().add(new Label("e"));
        bottomHbox.getChildren().add(new Label("f"));
        bottomHbox.getChildren().add(new Label("g"));
        bottomHbox.getChildren().add(new Label("h"));
        bottomHbox.setPadding(new Insets(0,0,screenHeight/10 -20,screenHeight/12));
        //define right
        VBox rightVbox = new VBox();
        rightVbox.setSpacing(20);
        ListView historie = new ListView();
        historie.minHeight(screenHeight/4);
        ListView beaten = new ListView();
        beaten.minHeight(primaryScreenBounds.getHeight()/4);
        rightVbox.getChildren().add(new Label("historie"));
        rightVbox.getChildren().add(historie);
        rightVbox.getChildren().add(new Label("beaten figures"));
        rightVbox.getChildren().add(beaten);
        rightVbox.setPadding(new Insets(20,screenHeight/12,0,20));
        //define top
        HBox topHbox = new HBox();
        topHbox.setSpacing(screenHeight /20);
        CheckBox check1 = new CheckBox("text");
        CheckBox check2 = new CheckBox("text");
        CheckBox check3 = new CheckBox("text");
        CheckBox check4 = new CheckBox("text");
        CheckBox check5 = new CheckBox("text");
        topHbox.getChildren().add(check1);
        topHbox.getChildren().add(check2);
        topHbox.getChildren().add(check3);
        topHbox.getChildren().add(check4);
        topHbox.getChildren().add(check5);
        topHbox.setPadding(new Insets(screenHeight/20,screenHeight/10,screenHeight/20,screenHeight/4));
        
        //add elements to BorderPane
        BorderPane border = new BorderPane();
        border.setTop(topHbox);
        border.setBottom(bottomHbox);
        border.setLeft(leftVbox);
        border.setRight(rightVbox);
        border.setCenter(drawBoard(brett));

        
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
    public GridPane drawBoard (Board brett) {
        GridPane board = new GridPane();     
        final int size = 8 ;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                Rectangle Feld = new Rectangle(screenHeight /10,screenHeight /10);
                Paint color ;
                if ((row + col) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.BLACK;
                }
                Feld.setFill(color);
                board.add(Feld, col, row);
                if(brett.getField(col, row)!=null) {
                board.add(new Label(brett.getField(col, row).getBoardVisual()), col, row);
                }
            }
        }
        return board;
    }
}
