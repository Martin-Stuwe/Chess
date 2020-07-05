package schach;

import figures.Bishop;
import figures.Knight;
import figures.Queen;
import figures.Rook;
import game.AI;
import game.Board;
import game.GuiCalcs;
import game.Time;
import game.Zug;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
	ListView<Label> historie = new ListView<Label>();
	
	/**
	 * board of the game in the GUI
	 */
    Board brett = new Board();
    
    /**
     * GridPane with the fields of the board
     */
    GridPane board = new GridPane();
    
    /**
     * current screenHeight
     */
    double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
    
    /**
     * current screenWidht
     */
    double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    
    /**
     * GuiCalcs object for calculating
     */
    GuiCalcs rechner = new GuiCalcs();
    
    /**
     * GuiController of GuiView
     */
    GuiController gc;
    
    /**
     * window object for popups etc
     */
 	Stage window = new Stage();
 	
 	/**
 	 * clock object of GuiView
 	 */
 	public Time clock = new Time(0,0);
 	
 	/**
 	 * String for the stylesheet
 	 */
 	String sty = "style.css";
 	
 	/**
 	 * get-method of brett
 	 * @return brett board of the GUI game
 	 */
    public Board getBrett() {
    	return brett;
    }
    
    /**
     * get-method of board
     * @return board GridPane of the board
     */
	public GridPane getBoard() {
		return board;
	}
	
	/**
	 * get-method of the screenHeight
	 * @param newHeight height of the screen
	 */
	public void setScreenHeight(double newHeight) {
		this.screenHeight = newHeight;
	}
	
	/**
	 * get-method of the screenWidth
	 * @param newHeight width of the screen
	 */
	public void setScreenWidth(double newHeight) {
		this.screenWidth = newHeight;
	}
	
	/**
	 * set-method of gc
	 * @param guiC new GuiController
	 */
	public GuiView(GuiController guiC) {
		this.gc = guiC;
	}
	
	 /**
     * startscreen of the game
     * @param primaryStage main stage
     */
	public void start(Stage primaryStage) {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setTitle("Startscreen");
        Button ngBtn = new Button();
        ngBtn.setText("new game");
        ngBtn.setId("ngBtn");
        
        StackPane root = new StackPane();
        root.getChildren().add(ngBtn);
        primaryStage.setScene(new Scene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight()));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.getScene().getStylesheets().add(sty);
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
        TextField depth = new TextField();
        depth.setId("depth");
        depth.setPromptText("ai depth > 0");
        HBox modebox = new HBox(100, pla, ai, depth);
        
        
        CheckBox enableTime = new CheckBox("enable time");
        enableTime.setId("enable");
        TextField whiteTime = new TextField();
        whiteTime.setId("whTi");
        whiteTime.setPromptText("white in s");
        TextField blackTime = new TextField();
        blackTime.setId("blTi");
        blackTime.setPromptText("black in s");
        HBox timebox = new HBox(100, enableTime, whiteTime, blackTime);
        
             
        VBox option = new VBox();
        option.setSpacing(primaryScreenBounds.getHeight() /20);
        option.getChildren().add(colorbox);
        option.getChildren().add(modebox);
        option.getChildren().add(timebox);
        option.getChildren().add(chobox);
        option.setPadding(new Insets(primaryScreenBounds.getHeight() /4,primaryScreenBounds.getWidth() /4,primaryScreenBounds.getHeight() /4,primaryScreenBounds.getWidth() /4));
        
        StackPane root = new StackPane();
        root.getChildren().add(option);
        primaryStage.setScene(new Scene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight()));
        primaryStage.getScene().getStylesheets().add(sty);
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
	
	   /**
     * stage for the main game
     * @param primaryStage main stage
     */
    public void startGame(Stage primaryStage, boolean saveGame) {
    	gc.setGameParameters();
        primaryStage.setTitle("Chess");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        screenHeight =primaryScreenBounds.getHeight();
        screenWidth =primaryScreenBounds.getWidth();
     
        
        


        //add elements to BorderPane
        border.setTop(drawTop(brett));
        drawBoard();

        
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
        primaryStage.getScene().getStylesheets().add(sty);
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(850);
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
        
        Label whiteLa = new Label(" white time: " + clock.timeWhite);
        Label blackLa = new Label(" black time: " + clock.timeBlack);
        whiteLa.setId("whiteLa");
        blackLa.setId("blackLa");
        board.add(whiteLa, 8, 4);
        board.add(blackLa, 8, 3);


        border.setCenter(board);
        border.setLeft(drawLeft(brett));
        border.setBottom(drawBottom(brett));
        border.setRight(drawRight(brett));
        border.getTop().minHeight(screenHeight/10);
        if(!gc.aiTurn && brett.movedList.size()>0) {
        if(Zug.checkCheck(brett) && gc.gameParameters.get(1)) {
        	if(brett.whiteCheck) {
        		board.add(new Label ("  white is in check"), 8, 1);
        	}
        	else if(brett.blackCheck) {
        		board.add(new Label ("  black is in check"), 8, 1);
        	}
        	
        }
	      if(!Zug.checkPossibleMoves(brett)) {
	        	Stage window = new Stage();
	        	window.setTitle("Game End");
	            window.initModality(Modality.APPLICATION_MODAL);
	           
	            HBox box = new HBox();
	            Label checkmate = new Label("Checkmate");
	            Label stalemate = new Label("Stalemate");
	            checkmate.setId("checkmate");
	            stalemate.setId("stalemate");
	      
	            if(Zug.checkCheck(brett)) {
	            	box.getChildren().add(checkmate);
	            }
	            else {
	            	box.getChildren().add(stalemate);
	            }
	            
	         
	            StackPane root = new StackPane();
	            root.getChildren().add(box);
	            window.setScene(new Scene(root, 200,200));
	            window.getScene().getStylesheets().add("style.css");
	            window.show();
	        }
		      
        } 
        
     return board;
    }
    
    
    /**
     * method to draw top part (settings) of the gui
     * @param brett board the game is on
     * @param primaryStage main stage
     * @return topHbox box including all settings
     */
    public HBox drawTop(Board brett) {
    	HBox topHbox = new HBox();
        topHbox.setSpacing(screenHeight /20);
        topHbox.setMinHeight(screenHeight/10);
        CheckBox check1 = new CheckBox("rotate board");
        CheckBox check2 = new CheckBox("show moves");
        CheckBox check3 = new CheckBox("show being in check");
        CheckBox check4 = new CheckBox("touch-move rule");
        Button back = new Button("back to menu");
        Button testSave = new Button("save");
        Button undo = new Button("undo");
        Button redo = new Button("redo");
        undo.setId("undo");
        redo.setId("redo");
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
        topHbox.getChildren().add(undo);
        topHbox.getChildren().add(redo);
        topHbox.getChildren().add(back);
        topHbox.getChildren().add(testSave);
        
        topHbox.setPadding(new Insets(50,50,0,50));
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
         rightVbox.setPadding(new Insets(screenHeight/50,screenHeight/12,0,screenHeight/50));
         rightVbox.setMinHeight(screenHeight/10 *8);
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
        Label eight = new Label("h");
        eight.setMinWidth(screenHeight/10);
        Label seven = new Label("g");
        seven.setMinWidth(screenHeight/10);
        Label six = new Label("f");
        six.setMinWidth(screenHeight/10);
        Label five = new Label("e");
        five.setMinWidth(screenHeight/10);
        Label four = new Label("d");
        four.setMinWidth(screenHeight/10);
        Label three = new Label("c");
        three.setMinWidth(screenHeight/10);
        Label two = new Label("b");
        two.setMinWidth(screenHeight/10);
        Label one = new Label("a");
        one.setMinWidth(screenHeight/10);
        if(!gc.gameParameters.get(0) || brett.getCurrentTurn()==0) {
        	bottomHbox.getChildren().add(one);
        	bottomHbox.getChildren().add(two);
        	bottomHbox.getChildren().add(three);
        	bottomHbox.getChildren().add(four);
        	bottomHbox.getChildren().add(five);
        	bottomHbox.getChildren().add(six);
        	bottomHbox.getChildren().add(seven);
        	bottomHbox.getChildren().add(eight);
        }
        else {
        	bottomHbox.getChildren().add(eight);
        	bottomHbox.getChildren().add(seven);
        	bottomHbox.getChildren().add(six);
        	bottomHbox.getChildren().add(five);
        	bottomHbox.getChildren().add(four);
        	bottomHbox.getChildren().add(three);
        	bottomHbox.getChildren().add(two);
        	bottomHbox.getChildren().add(one);
        }
        bottomHbox.setPadding(new Insets(0,0,screenHeight/10 -screenHeight/54,screenHeight/16));
        bottomHbox.setMinHeight(screenHeight/10);
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
        leftVbox.setPadding(new Insets(0,screenHeight/200,0,screenHeight/200));
        leftVbox.setMinHeight(screenHeight/10 *8);
        Label eight = new Label("8");
        eight.setMinHeight(screenHeight/10);
        Label seven = new Label("7");
        seven.setMinHeight(screenHeight/10);
        Label six = new Label("6");
        six.setMinHeight(screenHeight/10);
        Label five = new Label("5");
        five.setMinHeight(screenHeight/10);
        Label four = new Label("4");
        four.setMinHeight(screenHeight/10);
        Label three = new Label("3");
        three.setMinHeight(screenHeight/10);
        Label two = new Label("2");
        two.setMinHeight(screenHeight/10);
        Label one = new Label("1");
        one.setMinHeight(screenHeight/10);
        if(!gc.gameParameters.get(0) || brett.getCurrentTurn()==0) {
        	leftVbox.getChildren().add(eight);
        	leftVbox.getChildren().add(seven);
        	leftVbox.getChildren().add(six);
        	leftVbox.getChildren().add(five);
        	leftVbox.getChildren().add(four);
        	leftVbox.getChildren().add(three);
        	leftVbox.getChildren().add(two);
        	leftVbox.getChildren().add(one);
        }
        else {
            leftVbox.getChildren().add(one);
            leftVbox.getChildren().add(two);
            leftVbox.getChildren().add(three);
            leftVbox.getChildren().add(four);
            leftVbox.getChildren().add(five);
            leftVbox.getChildren().add(six);
            leftVbox.getChildren().add(seven);
            leftVbox.getChildren().add(eight);
        }
    
        return leftVbox;
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
        window.getScene().getStylesheets().add(sty);
        window.show();
        
  
    }
    
    /**
     * method to draw the Images of the chess pieces
     * @param brett board the game is on
     * @param i x axis position
     * @param y y axis position
     * @return image Label of the figure
     */
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
            	if(gc.gameParameters.get(0) && brett.getCurrentTurn()==1) {
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
