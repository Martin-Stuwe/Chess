package schach;

import game.Board;
import game.GuiCalcs;
import game.Zug;


import javafx.application.Application;
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
import javafx.scene.control.ToggleGroup;
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

import java.io.IOException;

import figures.Bishop;
import figures.Knight;
import figures.Queen;
import figures.Rook;
import game.AI;

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
	 * height of the screen
	 */
	double screenHeight;
	
	/**
	 * width of the screen
	 */
	double screenWidth;
	
	/**
	 * main BorderPane of the GUI
	 */
	BorderPane border= new BorderPane();
	
	/**
	 * check if rotate checkbox is ticked
	 */
	boolean rotate = false;
	
	/**
	 * check if showCheck checkbox is ticked
	 */
	boolean showCheck = true;
	
	/**
	 * check if showMove checkbox is ticked
	 */
	boolean showMove = true;
	
	/**
	 * check if touchMove checkboxis is ticked
	 */
	boolean touchMove = false;
	
	/**
	 * check if figure has been clicked on
	 */
	boolean clicked = false;
	
	/**
	 * ListView of all the moves played
	 */
	static ListView<String> historie = new ListView<String>();
	
	/**
	 * ListView of all beaten figures
	 */
	ListView<String> beaten = new ListView<String>();
	
	/**
	 *  calculator of the game
	 */
	GuiCalcs rechner = new GuiCalcs();
	
	/**
	 * Ai of the game
	 */
	AI ki = new AI(1);
	
	/**
	 * check if it's an Ai game
	 */
	boolean aiGame =false;
	
	boolean saveGame = false;
	
	/**
	 * main-method for the game
	 * @param args
	 */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * set-method for rotate
     * @param isSelected current state of the rotate checkbox
     */
    public void setRotate(boolean isSelected) {
    	rotate = isSelected;
    }
    
    /**
     * set-method for showCheck
     * @param isSelected current state of the showCheck checkbox
     */
    public void setShowCheck(boolean isSelected) {
    	showCheck = isSelected;
    }
    
    /**
     * set-method for showMove
     * @param isSelected current state of the show checkbox
     */
    public void setShowMove(boolean isSelected) {
    	showMove = isSelected;
    }
    
    /**
     * set-method for touchMove
     * @param isSelected current state of the rotate checkbox
     */
    public void setTouchMove(boolean isSelected) {
    	touchMove = isSelected;
    }
    
    /**
     * set-method for clicked
     * @param clicked true if something was clicked
     */
    public void setClicked(boolean click) {
    	clicked = click;
    }
    
    public static ListView<String> getHistorie(){
    	return historie;
    }
    
 
    
    
    /**
     * startscreen of the game
     * @param primaryStage main stage
     */
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
    
    /**
     * stage to choose mode and options
     * @param primaryStage main stage
     */
    public void startOptions(Stage primaryStage) {
        primaryStage.setTitle("Options");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Button btn = new Button();
        btn.setText("start game");
        Button btn2 = new Button("load game");
        HBox chobox = new HBox(100, btn, btn2);
 
        
        RadioButton white = new RadioButton("white");
        white.setSelected(true);
        RadioButton black = new RadioButton("black");
        HBox colorbox = new HBox(100, white, black);
        
        RadioButton pla = new RadioButton("player vs player");
        RadioButton ai = new RadioButton("player vs ai");
        pla.setSelected(true);
        HBox modebox = new HBox(100, pla, ai);
        
        white.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
               white.setSelected(true);
               black.setSelected(false);
            }
        });
        
        black.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
               black.setSelected(true);
               white.setSelected(false);
            }
        });
        
        pla.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
               pla.setSelected(true);
               ai.setSelected(false);
            }
        });
        
        ai.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
               ai.setSelected(true);
               pla.setSelected(false);
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	saveGame = true;
           		if(ai.isSelected()&& white.isSelected()) {
        		aiGame =true;
        		ki.setColor(1);
           		}
           		
           		else if(ai.isSelected()&& black.isSelected()) {
           			aiGame=true;
           			ki.setColor(0);
           			}
           		else {
           			aiGame=false;
           		}
           		startGame(primaryStage);
            }
        });
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	if(ai.isSelected()&& white.isSelected()) {
            		aiGame =true;
            		ki.setColor(1);
            	}
            	else if(ai.isSelected()&& black.isSelected()) {
            		aiGame=true;
            		ki.setColor(0);
            	}
            	else {
            		aiGame=false;
            	}
            	startGame(primaryStage);
            }
        });
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
    public void startGame(Stage primaryStage) {
        primaryStage.setTitle("Chess");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        screenHeight =primaryScreenBounds.getHeight();
        screenWidth =primaryScreenBounds.getWidth();
        Board brett = new Board();
        brett.setStart();
        
        if(saveGame) {
        	rechner.loadGuiSave(brett);
        	saveGame = false;
        }

        //add elements to BorderPane
        border.setTop(drawTop(brett, primaryStage));
        drawBoard(brett);

        
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
    public GridPane drawBoard (Board brett) {
        GridPane board = drawFeld(brett);     
        
        // check whose turn it is
        if(brett.getCurrentTurn() == 0) {
        	board.add(new Label ("  white to move"), 8, 0);
        }
        else if(brett.getCurrentTurn() == 1) {
        	board.add(new Label ("  black to move"), 8, 0);
        }
        
        // check if there is check
        if(Zug.checkCheck(brett) && showCheck) {
        	if(brett.whiteCheck) {
        		board.add(new Label ("  white is in check"), 8, 1);
        	}
        	else if(brett.blackCheck) {
        		board.add(new Label ("  black is in check"), 8, 1);
        	}
        	
        }
        
        // check if checkmate or stalemate + new popup if so
        if(!Zug.checkPossibleMoves(brett)) {
        	Stage window = new Stage();
        	window.setTitle("Game End");
            window.initModality(Modality.APPLICATION_MODAL);
           
            HBox box = new HBox();
            if(Zug.checkCheck(brett)) {
            	box.getChildren().add(new Label("Checkmate"));
            }
            else {
            	box.getChildren().add(new Label("Stalemate"));
            }
            
         
            StackPane root = new StackPane();
            root.getChildren().add(box);
            window.setScene(new Scene(root, 200,200));
            window.show();
        }
        border.setCenter(board);
        border.setLeft(drawLeft(brett));
        border.setBottom(drawBottom(brett));
        border.setRight(drawRight(brett));
        aiMove(brett);
        return board;
    }
    
    /**
     * method for an ai move
     * @param brett board the game is on
     */
    public void aiMove(Board brett) {
   
    	if(aiGame &&brett.getCurrentTurn()==ki.getColor()) {
            
            ki.findPossMoves(brett,ki.getColor());
            ki.Calculate(brett);
            ki.DoMinMove(brett);
          
            drawBoard(brett);
    		if (brett.movedList.size()!=0) {
    		int a = brett.movedList.get(brett.movedList.size()-1).getFrom1();
    		int b = brett.movedList.get(brett.movedList.size()-1).getFrom2();
    		String to  = Integer.toString(brett.movedList.get(brett.movedList.size()-1).getTo1())+Integer.toString(brett.movedList.get(brett.movedList.size()-1).getTo2());
    		convertInputToHistorie(a, b , to);
    		}
    	}
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
        
        check1.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                setRotate(check1.isSelected());
                drawBoard(brett);
            }
        });
        check2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                setShowMove(check2.isSelected());
            }
        });
        
        check3.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
               setShowCheck(check3.isSelected());
               drawBoard(brett);
            }
        });
        
        check4.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent event) {
               setTouchMove(check4.isSelected());
                
            }
        });
    	
        back.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);
                historie.getItems().clear();
            }
        });
        
        testSave.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
         
				rechner.makeSaveGui(historie);
			
            }
        });
        
  

        
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
        if(!rotate || brett.getCurrentTurn()==0) {
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
        if(!rotate || brett.getCurrentTurn()==0) {
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
     * method to show the symbol of the figure 
     * @param brett board the game is on
     * @param i x axis position
     * @param y y axis position
     * @return image visual of the figure
     */
    public Label getImage(Board brett, int i, int y) {
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

    	if(!clicked && touchMove || !touchMove) {
        	image.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                	 setClicked(true);
                    showPossibleMoves(brett,i,y);
                 
                }

            	});
        	
        	}
     
    		return image;
        }
    
    /**
     * method to show possible moves of figures
     * @param brett board the game is on
     * @param i x axis position
     * @param y y axis position
     */
    
    public void showPossibleMoves(Board brett, int a, int b){
    	GridPane possible = drawBoard(brett);
    	for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				String to = ""+i+y;
				int rrow =y;
				int rcol =i;
            	if(rotate && brett.getCurrentTurn()==1) {
            		rrow = (rrow-7)*-1;
            		rcol = (rcol-7)*-1;
            	}
				if(brett.getField(a, b) != null && brett.getField(a, b).hasPossibleMove(brett, a, b,"" +i+y)) {
					Rectangle poss = new Rectangle(screenHeight /10.1,screenHeight /10.1);
					
					if(showMove) {
						poss.setStroke(Color.RED);
						poss.setFill(Color.TRANSPARENT);
					}
					else {
						poss.setStroke(Color.TRANSPARENT);
						poss.setFill(Color.TRANSPARENT);
					}
					poss.setOnMouseClicked(new EventHandler<MouseEvent>() {
			            @Override
			            public void handle(MouseEvent event) {
			            	
			            	makeMove(brett,a,b,to );
			            	
			            }

			        });
					possible.add(poss, rcol,rrow);
					
				}
		}
			
		}
    	border.setCenter(possible);
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
    public void pawnPromo(Board brett, int to1, int to2) {
    	Stage window = new Stage();
    	window.setTitle("pawn promotion");
        window.initModality(Modality.APPLICATION_MODAL);
        Button queen = new Button("♕/♛");
        Button rook = new Button("♖/♜");
        Button knight = new Button("♘/♞");
        Button bishop = new Button ("♗/♝");
        HBox box = new HBox();
        box.getChildren().add(queen);
        box.getChildren().add(rook);
        box.getChildren().add(knight);
        box.getChildren().add(bishop);
        StackPane root = new StackPane();
        root.getChildren().add(box);
        window.setScene(new Scene(root, 200,200));
        window.show();
        queen.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	brett.setField(to1, to2, new Queen(to1,to2,brett.getField(to1, to2).getColor()));
            	 drawBoard(brett);
                window.close();
            }
        });
        
        rook.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	brett.setField(to1, to2, new Rook(to1,to2,brett.getField(to1, to2).getColor()));
            	 drawBoard(brett);
                window.close();
            }
        });
        
       knight.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	brett.setField(to1, to2, new Knight(to1,to2,brett.getField(to1, to2).getColor()));
            	 drawBoard(brett);
                window.close();
            }
        });
        
        bishop.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	brett.setField(to1, to2, new Bishop(to1,to2,brett.getField(to1, to2).getColor()));
            	 drawBoard(brett);
                window.close();
            }
        });
  
    }

	/**
	 * method to move figures on the board
     * @param brett board the game is on
     * @param i x axis starting position
     * @param y y axis starting position
	 * @param to x and y axis ending position
	 */
	public void makeMove(Board brett, int a, int b, String to ) {
		setClicked(false);
		int to1=Character.getNumericValue(to.charAt(0));
		int to2=Character.getNumericValue(to.charAt(1));

		brett.getField(a, b).move(brett, a, b, to);
		convertInputToHistorie(a, b , to);
		
		if(brett.getField(to1, to2)!= null&&brett.getField(to1, to2).getType()==4 && (brett.getField(to1, to2).getColor()=="w"&& to2==0 ||brett.getField(to1, to2).getColor()=="b"&& to2==7  )) {
		pawnPromo(brett,to1,to2);
		}
		drawBoard(brett);
		
		
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
            	if(rotate && brett.getCurrentTurn()==1) {
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
                	Label image = getImage(brett,col,row);
                	board.setHalignment(image, HPos.CENTER);
                	
                	board.add(image, rcol, rrow);
                
                }
                
            }
        }
        return board;
	}
	}
