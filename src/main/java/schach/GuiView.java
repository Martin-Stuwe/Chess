package schach;

import figures.Bishop;
import figures.Knight;
import figures.Queen;
import figures.Rook;
import game.AI;
import game.Board;
import game.GuiCalcs;
import game.Zug;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GuiView {
	
	/**
	 * main BorderPane of the GUI
	 */
	BorderPane border= new BorderPane();
	
	/**
	 * ListView of all the moves played
	 */
	ListView<String> historie = new ListView<String>();
	
    Board brett = new Board();
    GridPane board = new GridPane();
    double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
    double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    GuiCalcs rechner = new GuiCalcs();
    GuiController gc;
 	Stage window = new Stage();
    public Board getBrett() {
    	return brett;
    }
   
	public GridPane getBoard() {
		return board;
	}
	public void setScreenHeigt(double newHeight) {
		this.screenHeight = newHeight;
	}
	
	
	public GuiView(GuiController guiC) {
		this.gc = guiC;
	}
	
	 /**
     * startscreen of the game
     * @param primaryStage main stage
     */
	public void start(Stage primaryStage) {

        primaryStage.setTitle("Startscreen");
        Button ngBtn = new Button();
        ngBtn.setText("new game");
        ngBtn.setId("ngBtn");
        
        StackPane root = new StackPane();
        root.getChildren().add(ngBtn);
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
	}
	  /**
     * stage to choose mode and options
     * @param primaryStage main stage
     */
	
	public void startOptions(Stage primaryStage) {
        primaryStage.setTitle("Options");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Button btn = new Button();
        btn.setId("start");
        btn.setText("start game");
        Button btn2 = new Button("load game");
        btn2.setId("load");
        HBox chobox = new HBox(100, btn, btn2);
 
        
        RadioButton white = new RadioButton("white");
        white.setId("white");
        white.setSelected(true);
        RadioButton black = new RadioButton("black");
        black.setId("black");
        HBox colorbox = new HBox(100, white, black);
        
        RadioButton pla = new RadioButton("player vs player");
        pla.setId("pla");
        RadioButton ai = new RadioButton("player vs ai");
        ai.setId("ai");
        pla.setSelected(true);
        HBox modebox = new HBox(100, pla, ai);
        
       
        VBox option = new VBox();
        option.setSpacing(primaryScreenBounds.getHeight() /20);
        option.getChildren().add(colorbox);
        option.getChildren().add(modebox);
        option.getChildren().add(chobox);
        option.setPadding(new Insets(primaryScreenBounds.getHeight() /3,primaryScreenBounds.getWidth() /3,primaryScreenBounds.getHeight() /3,primaryScreenBounds.getWidth() /3));
        
        StackPane root = new StackPane();
        root.getChildren().add(option);
        primaryStage.setScene(new Scene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight()));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
	
	   /**
     * stage for the main game
     * @param primaryStage main stage
     */
    public void startGame(Stage primaryStage, boolean saveGame) {
        primaryStage.setTitle("Chess");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        screenHeight =primaryScreenBounds.getHeight();
        screenWidth =primaryScreenBounds.getWidth();
     
        brett.setStart();
        


        //add elements to BorderPane
        border.setTop(drawTop(brett, primaryStage));
        drawBoard();

        
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
    /**
     * method to draw the center pat of the gui including the main board
     * @param brett board of the game
     * @return board GridPane of the whole cnter part of the game
     */
    public GridPane drawBoard() {
    	board = drawFeld(brett);     
        
        // check whose turn it is
        if(brett.getCurrentTurn() == 0) {
        	board.add(new Label ("  white to move"), 8, 0);
        }
        else if(brett.getCurrentTurn() == 1) {
        	board.add(new Label ("  black to move"), 8, 0);
        }
        
        // check if there is check
        
        
        // check if checkmate or stalemate + new popup if so
  
        border.setCenter(board);
        border.setLeft(drawLeft(brett));
        border.setBottom(drawBottom(brett));
        border.setRight(drawRight(brett));
        gc.aiMove(brett);
        return board;
    }
    
    
    /**
     * method to draw top part (settings) of the gui
     * @param brett board the game is on
     * @param primaryStage main stage
     * @return topHbox box including all settings
     */
    public HBox drawTop(Board brett, Stage primaryStage) {
    	HBox topHbox = new HBox();
        topHbox.setSpacing(screenHeight /20);
        CheckBox check1 = new CheckBox("rotate board");
        CheckBox check2 = new CheckBox("show moves");
        CheckBox check3 = new CheckBox("show being in check");
        CheckBox check4 = new CheckBox("touch-move rule");
        Button back = new Button("back to menu");
        Button testSave = new Button("save");

       
        
        check2.setSelected(true);
        check3.setSelected(true);
        
        check1.setId("check1");
        check2.setId("check2");
        check3.setId("check3");
        check4.setId("check4");
        
        back.setId("back");
        testSave.setId("save");
        
        
        
  

        
        topHbox.getChildren().add(check1);
        topHbox.getChildren().add(check2);
        topHbox.getChildren().add(check3);
        topHbox.getChildren().add(check4);
        topHbox.getChildren().add(back);
        topHbox.getChildren().add(testSave);

        
        topHbox.setPadding(new Insets(screenHeight/20,screenHeight/10,screenHeight/20,screenHeight/4));
        return topHbox;
    }
    
    /**
     * method to draw right part of gui including historie and beaten figures list
     * @param brett board the game is on
     * @return rightVbox VBox that includes historie and beaten figures
     */
    public VBox drawRight(Board brett) {
    	 VBox rightVbox = new VBox();
         rightVbox.setSpacing(20);
         historie.minHeight(screenHeight/4);
         rightVbox.getChildren().add(new Label("historie"));
         rightVbox.getChildren().add(historie);
         rightVbox.getChildren().add(new Label("beaten figures"));
         rightVbox.getChildren().add(rechner.addBeaten(brett, screenHeight));
         rightVbox.setPadding(new Insets(20,screenHeight/12,0,20));
         return rightVbox;
    }
    
    /**
     * method to draw the bottom part of the gui including labels a to h
     * @param brett board the game is on
     * @return bottomHbox with labels a to h
     */
    public HBox drawBottom(Board brett) {
        //define Bottom
        HBox bottomHbox = new HBox();
        bottomHbox.setSpacing(screenHeight/10.5);
        if(!gc.rotate || brett.getCurrentTurn()==0) {
        	bottomHbox.getChildren().add(new Label("a"));
        	bottomHbox.getChildren().add(new Label("b"));
        	bottomHbox.getChildren().add(new Label("c"));
        	bottomHbox.getChildren().add(new Label("d"));
        	bottomHbox.getChildren().add(new Label("e"));
        	bottomHbox.getChildren().add(new Label("f"));
        	bottomHbox.getChildren().add(new Label("g"));
        	bottomHbox.getChildren().add(new Label("h"));
        }
        else {
        	bottomHbox.getChildren().add(new Label("h"));
        	bottomHbox.getChildren().add(new Label("g"));
        	bottomHbox.getChildren().add(new Label("f"));
        	bottomHbox.getChildren().add(new Label("e"));
        	bottomHbox.getChildren().add(new Label("d"));
        	bottomHbox.getChildren().add(new Label("c"));
        	bottomHbox.getChildren().add(new Label("b"));
        	bottomHbox.getChildren().add(new Label("a"));
        }
        bottomHbox.setPadding(new Insets(0,0,screenHeight/10 -20,screenHeight/12));
        return bottomHbox;
        
    }
    
    /**
     * method to draw the left part of the gui including labels 1 to 8
     * @param brett board the game is on
     * @return leftVbox with labels 1 to 8
     */
    public VBox drawLeft(Board brett) {
    	 //define left 
        VBox leftVbox = new VBox();
        leftVbox.setSpacing(screenHeight /12);
        if(!gc.rotate || brett.getCurrentTurn()==0) {
        	leftVbox.getChildren().add(new Label("8"));
        	leftVbox.getChildren().add(new Label("7"));
        	leftVbox.getChildren().add(new Label("6"));
        	leftVbox.getChildren().add(new Label("5"));
        	leftVbox.getChildren().add(new Label("4"));
        	leftVbox.getChildren().add(new Label("3"));
        	leftVbox.getChildren().add(new Label("2"));
        	leftVbox.getChildren().add(new Label("1"));
        }
        else {
            leftVbox.getChildren().add(new Label("1"));
            leftVbox.getChildren().add(new Label("2"));
            leftVbox.getChildren().add(new Label("3"));
            leftVbox.getChildren().add(new Label("4"));
            leftVbox.getChildren().add(new Label("5"));
            leftVbox.getChildren().add(new Label("6"));
            leftVbox.getChildren().add(new Label("7"));
            leftVbox.getChildren().add(new Label("8"));
        }
        leftVbox.setPadding(new Insets(screenHeight /20,20,0,20));
        return leftVbox;
    }
    
 

    /**
     * method to convert input into valid chess notation and save it
     * @param i x axis starting position
     * @param y y axis starting position
     * @param to x and y axis ending position
     */
    public void convertInputToHistorie(int a, int b, String to) {
    	String output ="";
    	
    	int to1=Character.getNumericValue(to.charAt(0));
		int to2=Character.getNumericValue(to.charAt(1));
		output = rechner.numberToString(a) + rechner.numberToNumber(b) + "-" + rechner.numberToString(to1) + rechner.numberToNumber(to2);
    	historie.getItems().add(output);
    	
    }
    
    /**
     * method to open a window and let the user decide what a pawn should be promoted to
     * @param brett board the game is on
     * @param to1 x axis position
     * @param to2 y axis position
     */
    public void pawnPromo() {
  
    	window.setTitle("pawn promotion");
        window.initModality(Modality.APPLICATION_MODAL);
        Button queen = new Button("♕/♛");
        queen.setId("queen");
        Button rook = new Button("♖/♜");
        rook.setId("rook");
        Button knight = new Button("♘/♞");
        knight.setId("knight");
        Button bishop = new Button ("♗/♝");
        bishop.setId("bishop");
        HBox box = new HBox();
        box.getChildren().add(queen);
        box.getChildren().add(rook);
        box.getChildren().add(knight);
        box.getChildren().add(bishop);
        StackPane root = new StackPane();
        root.getChildren().add(box);
        window.setScene(new Scene(root, 200,200));
        window.show();
        
  
    }

    public Label drawImage(Board brett, int i, int y) {
    	Label image = new Label("");
    	if(brett.getField(i, y).getColor()=="w") {
    		image.setText(rechner.checkWhiteSymbols(brett.getField(i, y).getBoardVisual()));
    	}
    	else {
    		image.setText(rechner.checkBlackSymbols(brett.getField(i, y).getBoardVisual()));
    	}
    	image.setScaleX(screenHeight/200);
    	image.setScaleY(screenHeight/200);
    	image.autosize();
    	image.setTextAlignment(TextAlignment.CENTER);
    	return image;
    }
	
	
	
	/**
	 * method to draw chess pattern
	 * @param brett board the game is on
	 * @return board chess patterned GridPane
	 */
	public GridPane drawFeld(Board brett) {
        GridPane board = new GridPane();
		final int size = 8 ;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                Rectangle Feld = new Rectangle(screenHeight /10,screenHeight /10);
                Paint color ;
                int rrow =row;
                int rcol =col;
            	if(gc.rotate && brett.getCurrentTurn()==1) {
            		rrow = (rrow-7)*-1;
            		rcol = (rcol-7)*-1;
            	}
                if ((rrow + col) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.LIGHTGRAY;
                }
                Feld.setFill(color);
                board.add(Feld, rcol, rrow);
                if(brett.getField(col, row)!=null) {
                	Label image = gc.getImage(brett,col,row);
                	board.setHalignment(image, HPos.CENTER);
                	
                	board.add(image, rcol, rrow);
                
                }
                
            }
        }
        return board;
	}
}
