package schach;

import game.Board;
import game.StartGame;
/**
 * no changes made yet
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GuiMain extends Application {
	/**
	 * method to launch GUI
	 */
	double screenHeight;
	double screenWidth;
	BorderPane border= new BorderPane();
	boolean rotate = false;
	boolean showCheck = true;
	boolean showMove = true;
	boolean touchMove = false;
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public void setRotate(boolean isSelected) {
    	rotate = isSelected;
    }
    
    public void setShowCheck(boolean isSelected) {
    	showCheck = isSelected;
    }
    
    public void setShowMove(boolean isSelected) {
    	showMove = isSelected;
    }
    
    public void setTouchMove(boolean isSelected) {
    	touchMove = isSelected;
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

        //add elements to BorderPane
        border.setTop(drawTop(brett));
        border.setBottom(drawBottom());
        border.setLeft(drawLeft(brett));
        border.setRight(drawRight());
        drawBoard(brett);

        
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
                int rrow =row;
            	if(rotate && brett.getCurrentTurn()==1) {
            		rrow = (rrow-7)*-1;
            	}
                if ((rrow + col) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.LIGHTGRAY;
                }
                Feld.setFill(color);
                board.add(Feld, col, rrow);
                if(brett.getField(col, row)!=null) {
                	Label image = getImage(brett,col,row);
                	board.setHalignment(image, HPos.CENTER);
                	
                	board.add(image, col, rrow);
                
                }
            }
        }
        border.setCenter(board);
        border.setLeft(drawLeft(brett));
        return board;
    }
    
    public HBox drawTop(Board brett) {
    	HBox topHbox = new HBox();
        topHbox.setSpacing(screenHeight /20);
        CheckBox check1 = new CheckBox("rotate board");
        CheckBox check2 = new CheckBox("show moves");
        CheckBox check3 = new CheckBox("show being in check");
        CheckBox check4 = new CheckBox("touch-move rule");
        CheckBox check5 = new CheckBox("text");
        check2.setSelected(true);
        check3.setSelected(true);
        check1.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                setRotate(check1.isSelected());
                border.setLeft(drawLeft(brett));
                border.setBottom(drawBottom());
                drawBoard(brett);
            }
        });
        check2.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                setShowMove(check2.isSelected());
            }
        });
        
        topHbox.getChildren().add(check1);
        topHbox.getChildren().add(check2);
        topHbox.getChildren().add(check3);
        topHbox.getChildren().add(check4);
        topHbox.getChildren().add(check5);
        topHbox.setPadding(new Insets(screenHeight/20,screenHeight/10,screenHeight/20,screenHeight/4));
        return topHbox;
    }
    
    public VBox drawRight() {
    	 VBox rightVbox = new VBox();
         rightVbox.setSpacing(20);
         ListView historie = new ListView();
         historie.minHeight(screenHeight/4);
         ListView beaten = new ListView();
         beaten.minHeight(screenHeight/4);
         rightVbox.getChildren().add(new Label("historie"));
         rightVbox.getChildren().add(historie);
         rightVbox.getChildren().add(new Label("beaten figures"));
         rightVbox.getChildren().add(beaten);
         rightVbox.setPadding(new Insets(20,screenHeight/12,0,20));
         return rightVbox;
    }
    
    public HBox drawBottom() {
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
        return bottomHbox;
        
    }
    
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
    
    public Label getImage(Board brett, int i, int y) {
    	Label image = new Label("");
    	if(brett.getField(i, y).getColor()=="w") {
    		image.setText(checkWhiteSymbols(brett,i,y));
    	}
    	else {
    		image.setText(checkBlackSymbols(brett,i,y));
    	}
    	image.setScaleX(screenHeight/200);
    	image.setScaleY(screenHeight/200);
    	image.autosize();
    	image.setTextAlignment(TextAlignment.CENTER);

    	image.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showPossibleMoves(brett,i,y);
            }

        });
    	return image;
    }
    
    public String checkWhiteSymbols(Board brett, int i, int y) {
    	String white = "";
    	if(brett.getField(i, y).getBoardVisual()=="P") {
    		white="♙" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="N") {
    		white="♘" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="B") {
    		white="♗" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="R") {
    		white="♖" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="Q") {
    		white="♕" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="K") {
    		white="♔" ;
    	}
    	return white;
    }
    public String checkBlackSymbols(Board brett, int i, int y) {
    	String black = "";
     	if(brett.getField(i, y).getBoardVisual()=="p") {
    		black="♟" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="n") {
    		black="♞" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="b") {
    		black="♝" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="r") {
    		black="♜" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="q") {
    		black="♛" ;
    	}
    	if(brett.getField(i, y).getBoardVisual()=="k") {
    		black="♚" ;
    	}
    	return black;
    }
    
    public void showPossibleMoves(Board brett, int a, int b){
    	GridPane possible = drawBoard(brett);
    	for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				String to = ""+i+y;
				int rrow =y;
            	if(rotate && brett.getCurrentTurn()==1) {
            		rrow = (rrow-7)*-1;
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
			            	
			            	brett.getField(a, b).move(brett, a, b, to);
			            	drawBoard(brett);
			            }

			        });
					possible.add(poss, i,rrow);
					
				}
		}
			
		}
    	border.setCenter(possible);
    }
    
    public int convertRotate(int i) {
    	if(i == 0) {
    		i = 7;
    		
    	}
    	else if(i == 1) {
    		i = 6;
    		
    	}
    	else if(i == 2) {
    		i = 5;
    		
    	}
    	else if(i == 3) {
    		i = 4;
    		
    	}
    	else if(i == 4) {
    		i = 3;
    		
    	}
    	else if(i == 5) {
    		i = 2;
    		
    	}
    	else if(i == 6) {
    		i = 1;
    		
    	}
    	else if (i == 7) {
    		i = 0;
    		
    	}
    	return i;
    }
}
