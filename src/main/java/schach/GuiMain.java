package schach;

import game.Board;
import game.StartGame;
import game.Zug;
import figures.*;
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
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import game.AI;
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
	boolean clicked = false;
	ListView<String> historie = new ListView<String>();
	
	
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
    public void setClicked(boolean click) {
    	clicked = click;
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
        border.setTop(drawTop(brett, primaryStage));
        drawBoard(brett);

        
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.show();
    }
    public GridPane drawBoard (Board brett) {
        GridPane board = drawFeld(brett);     

        if(brett.getCurrentTurn() == 0) {
        	board.add(new Label ("  white to move"), 8, 0);
        }
        else if(brett.getCurrentTurn() == 1) {
        	board.add(new Label ("  black to move"), 8, 0);
        }
        if(Zug.checkCheck(brett) && showCheck) {
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
        
        return board;
    }
    
    public HBox drawTop(Board brett, Stage primaryStage) {
    	HBox topHbox = new HBox();
        topHbox.setSpacing(screenHeight /20);
        CheckBox check1 = new CheckBox("rotate board");
        CheckBox check2 = new CheckBox("show moves");
        CheckBox check3 = new CheckBox("show being in check");
        CheckBox check4 = new CheckBox("touch-move rule");
        Button back = new Button("back to menu");
        Button test = new Button("AI test");
       
        
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
        
        test.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                AI.findPossMoves(brett);
                AI.Calculate(brett);
                AI.DoMinMove(brett);
                drawBoard(brett);
                
            }
        });
        
        topHbox.getChildren().add(check1);
        topHbox.getChildren().add(check2);
        topHbox.getChildren().add(check3);
        topHbox.getChildren().add(check4);
        topHbox.getChildren().add(back);
        topHbox.getChildren().add(test);
        
        topHbox.setPadding(new Insets(screenHeight/20,screenHeight/10,screenHeight/20,screenHeight/4));
        return topHbox;
    }
    
    public VBox drawRight(Board brett) {
    	 VBox rightVbox = new VBox();
         rightVbox.setSpacing(20);
         historie.minHeight(screenHeight/4);
         rightVbox.getChildren().add(new Label("historie"));
         rightVbox.getChildren().add(historie);
         rightVbox.getChildren().add(new Label("beaten figures"));
         rightVbox.getChildren().add(addBeaten(brett));
         rightVbox.setPadding(new Insets(20,screenHeight/12,0,20));
         return rightVbox;
    }
    
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
    		image.setText(checkWhiteSymbols(brett.getField(i, y).getBoardVisual()));
    	}
    	else {
    		image.setText(checkBlackSymbols(brett.getField(i, y).getBoardVisual()));
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
    
    public String checkWhiteSymbols(String visual) {
    	String white = "";
    	if(visual=="P") {
    		white="♙" ;
    	}
    	if(visual=="N") {
    		white="♘" ;
    	}
    	if(visual=="B") {
    		white="♗" ;
    	}
    	if(visual=="R") {
    		white="♖" ;
    	}
    	if(visual=="Q") {
    		white="♕" ;
    	}
    	if(visual=="K") {
    		white="♔" ;
    	}
    	return white;
    }
    public String checkBlackSymbols(String visual) {
    	String black = "";
     	if(visual=="p") {
    		black="♟" ;
    	}
    	if(visual=="n") {
    		black="♞" ;
    	}
    	if(visual=="b") {
    		black="♝" ;
    	}
    	if(visual=="r") {
    		black="♜" ;
    	}
    	if(visual=="q") {
    		black="♛" ;
    	}
    	if(visual=="k") {
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
    
    public ListView<String> addBeaten(Board brett) {
    	  ListView <String>beaten = new ListView<String>();
          beaten.minHeight(screenHeight/4);
          for(int i=0; i<brett.beaten.size();i++) {
        		  beaten.getItems().add(checkWhiteSymbols(brett.beaten.get(i))+checkBlackSymbols(brett.beaten.get(i)));
        	  

          }
          return beaten;

    }
    
    public void convertInputToHistorie(int a, int b, String to) {
    	String output ="";
    	
    	int to1=Character.getNumericValue(to.charAt(0));
		int to2=Character.getNumericValue(to.charAt(1));
		output = numberToString(a) + numberToNumber(b) + "-" + numberToString(to1) + numberToNumber(to2);
    	historie.getItems().add(output);
    }
    
    public int numberToNumber(int a) {
    	if(a == 0) {
    		a = 8;
    	}
    	else if (a == 1) {
    		a = 7;
    	}
    	else if (a == 2) {
    		a = 6;
    	}
    	else if (a == 3) {
    		a = 5;
    	}
    	else if (a == 4) {
    		a = 4;
    	}
    	else if (a == 5) {
    		a = 3;
    	}
    	else if (a == 6) {
    		a = 2;
    	}
    	else if (a == 7) {
    		a = 1;
    	}
    	return a;
    }
    
    public String numberToString(int a) {
    	String b ="";
    	if(a == 0) {
    		b = "a";
    	}
    	else if (a == 1) {
    		b = "b";
    	}
    	else if (a == 2) {
    		b = "c";
    	}
    	else if (a == 3) {
    		b = "d";
    	}
    	else if (a == 4) {
    		b = "e";
    	}
    	else if (a == 5) {
    		b = "f";
    	}
    	else if (a == 6) {
    		b = "g";
    	}
    	else if (a == 7) {
    		b = "h";
    	}
    	return b;
    }
    
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
