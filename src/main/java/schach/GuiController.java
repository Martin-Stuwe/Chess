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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;

public class GuiController {

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
	
	GuiView gv = new GuiView(this);
	
	
	
	
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
    
  /*  public  ListView<String> getHistorie(){
    	return historie;
    }*/
    
    
	public void start(Stage primaryStage) {
    	gv.start(primaryStage);
    	Button btn = (Button) primaryStage.getScene().lookup("#ngBtn");
    	btn.setOnAction(new EventHandler<ActionEvent>() {
  		  
            @Override
            public void handle(ActionEvent event) {
               gv.startOptions(primaryStage);
               setOptions(primaryStage);
            }
        });;

	}
	
	public void setOptions(Stage primaryStage) {
		RadioButton white = (RadioButton) primaryStage.getScene().lookup("#white");
		RadioButton black = (RadioButton) primaryStage.getScene().lookup("#black");
		RadioButton pla = (RadioButton) primaryStage.getScene().lookup("#pla");
		RadioButton ai = (RadioButton) primaryStage.getScene().lookup("#ai");
		Button btn = (Button) primaryStage.getScene().lookup("#start");
		Button btn2 = (Button) primaryStage.getScene().lookup("#load");
		
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
	           		gv.startGame(primaryStage, saveGame);
	           		startPlay(primaryStage);
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
	            	gv.startGame(primaryStage, saveGame);
	            	startPlay(primaryStage);
	            }
	        });
		
	}
	
	public void startPlay(Stage primaryStage) {
		gv.brett = new Board();
		gv.brett.setStart();
		primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
		     gv.setScreenHeight(Math.min(primaryStage.getWidth(),primaryStage.getHeight()));
		     gv.drawBoard();
		});

		primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
			gv.setScreenHeight(Math.min(primaryStage.getWidth(),primaryStage.getHeight()));
			 gv.drawBoard();
		});
		
        if(saveGame) {
        	rechner.loadGuiSave(gv.brett);
        	for(int i = 0; i < gv.brett.movedList.size();i++) {
        			char from1 = (char) (gv.brett.movedList.get(i).getFrom1());
        			char from2 = (char) (gv.brett.movedList.get(i).getFrom2());
        			char to1 = (char) (gv.brett.movedList.get(i).getTo1());
        			char to2 = (char) (gv.brett.movedList.get(i).getTo2());
        		//	gv.historie.getItems().add(rechner.numberToString(from1) + rechner.numberToNumber(from2)
        		//	+ "-" +rechner.numberToString(to1) + rechner.numberToNumber(to2));
        			
        	}
        	saveGame = false;
        }
		
		gv.drawBoard();
		setTop(primaryStage);
		startAi();
		
	      
	      /* TEST 
	      Time clock = new Time(300,300);
	      
	      Timeline clockUpdate = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			
	    	  public void handle(ActionEvent event) {
	    		  clock.updateTime(gv.brett);
	    		  System.out.println("white: " + clock.timeWhite + " black: " + clock.timeBlack);
	    	  }
	      }));
	      clockUpdate.setCycleCount(Timeline.INDEFINITE);
	      clockUpdate.play();
	      */
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
          
           
    		
    		Platform.runLater(new Runnable() {
    		      @Override
    		      public void run() {
    		         //Update your GUI here
    		    	  gv.drawBoard();
    		    		if (brett.movedList.size()!=0) {
    		    		int a = brett.movedList.get(brett.movedList.size()-1).getFrom1();
    		    		int b = brett.movedList.get(brett.movedList.size()-1).getFrom2();
    		    		String to  = Integer.toString(brett.movedList.get(brett.movedList.size()-1).getTo1())+Integer.toString(brett.movedList.get(brett.movedList.size()-1).getTo2());
    		    		gv.historie.getItems().add(rechner.convertInputToHistorie(a, b , to));}
    		      }
    		  });
    		}
    	}
    

	public void setTop(Stage primaryStage) {
	    CheckBox check1 = (CheckBox) primaryStage.getScene().lookup("#check1");
        CheckBox check2 = (CheckBox) primaryStage.getScene().lookup("#check2");
        CheckBox check3 = (CheckBox) primaryStage.getScene().lookup("#check3");
        CheckBox check4 = (CheckBox) primaryStage.getScene().lookup("#check4");
        Button back = (Button) primaryStage.getScene().lookup("#back");
        Button testSave = (Button) primaryStage.getScene().lookup("#save");
		
		check1.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent event) {
                setRotate(check1.isSelected());
                if(!aiGame) {
               gv.drawBoard();
                }
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
               if(!aiGame) {
                   gv.drawBoard();
                    }
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
               
                gv.historie.getItems().clear();
            	start(primaryStage);
                
                
            }
        });
          
        testSave.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent event) {
         
				rechner.makeSaveGui(gv.historie);
		
            }
        });
	}
	
	  /**
     * method to show the symbol of the figure 
     * @param brett board the game is on
     * @param i x axis position
     * @param y y axis position
     * @return image visual of the figure
     */
	public Label getImage(Board brett, int i, int y) {
    	Label image = gv.drawImage(brett, i, y);
    	if(aiGame&&gv.brett.getCurrentTurn()==ki.getColor()) {
    		
    	}
    	else if(!clicked && touchMove || !touchMove) {
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
	    	GridPane possible = gv.drawBoard();
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
						Rectangle poss = new Rectangle(gv.screenHeight /10.1,gv.screenHeight /10.1);
						
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
	    	gv.border.setCenter(possible);
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
			Label zug = rechner.convertInputToHistorie(a, b , to);
			int zugnr =gv.historie.getItems().size()+1;
			zug.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	            	
	            	System.out.println("Load Zug"+zugnr);
	            	
	            }

	        });
			gv.historie.getItems().add(zug);
			if(brett.getField(to1, to2)!= null&&brett.getField(to1, to2).getType()==4 && (brett.getField(to1, to2).getColor()=="w"&& to2==0 ||brett.getField(to1, to2).getColor()=="b"&& to2==7  )) {
			gv.pawnPromo();
			Button queen = (Button) gv.window.getScene().lookup("#queen");
			queen.setOnAction(new EventHandler<ActionEvent>() {
				 
	            @Override
	            public void handle(ActionEvent event) {
	            	brett.setField(to1, to2, new Queen(to1,to2,brett.getField(to1, to2).getColor()));
	            	 gv.drawBoard();
	                gv.window.close();
	            }
	        });
			Button rook = (Button) gv.window.getScene().lookup("#rook");
	        rook.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	            	brett.setField(to1, to2, new Rook(to1,to2,brett.getField(to1, to2).getColor()));
	            	 gv.drawBoard();
	               gv.window.close();
	            }
	        });
	        Button knight = (Button) gv.window.getScene().lookup("#knight");
	       knight.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	            	brett.setField(to1, to2, new Knight(to1,to2,brett.getField(to1, to2).getColor()));
	            	 gv.drawBoard();
	                gv.window.close();
	            }
	        });
	       Button bishop = (Button) gv.window.getScene().lookup("#bishop");
	        bishop.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	            	brett.setField(to1, to2, new Bishop(to1,to2,brett.getField(to1, to2).getColor()));
	            	 gv.drawBoard();
	                gv.window.close();
	            }
	        });
			}
			gv.drawBoard();

		}


	public void startAi() {
		Timer t = new Timer();
		long i = 500;
		t.scheduleAtFixedRate(new TimerTask() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				aiMove(gv.brett);
				
				Platform.runLater(new Runnable() {
	    		      @Override
	    		      public void run() {
				if(Zug.checkCheck(gv.brett) && showCheck) {
		        	if(gv.brett.whiteCheck) {
		        		gv.board.add(new Label ("  white is in check"), 8, 1);
		        	}
		        	else if(gv.brett.blackCheck) {
		        		gv.board.add(new Label ("  black is in check"), 8, 1);
		        	}
		        	
		        }
			      if(!Zug.checkPossibleMoves(gv.brett)) {
			        	Stage window = new Stage();
			        	window.setTitle("Game End");
			            window.initModality(Modality.APPLICATION_MODAL);
			           
			            HBox box = new HBox();
			            if(Zug.checkCheck(gv.brett)) {
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
	    		      }
	    		  });
			}
			
		}, i, i);
	}
	}