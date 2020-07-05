package game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import figures.Bishop;
import figures.King;
import figures.Knight;
import figures.Pawn;
import figures.Queen;
import figures.Rook;

/**
 * Class for the AI
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it2
 */
public class AI {

	/**
	 * the possible Moves for the AI
	 */
	public List<Zug> possibleMoves;
	
	/**
	 * the possible Moves for the Player
	 */
	public List<Zug> enPossibleMoves;
	
	/**
	 * the players value after each AI move
	 */
	public List<Integer> EnemyValue ;
	
	/**
	 * the value for the AI
	 */
	public List<Integer> AIValue ;

	/**
	 * the converted turn
	 */
	private String convTurn;

	
	/**
	 * the color of the AI 
	 */
	private int color;
	

	private int desiredDepth;
	
	private Zug bestMove;
	
	
	/**
	 * the AI constructor
	 * @param The color chosen for the AI
	 */
	public AI(int color) {
		this.color = color;
		possibleMoves = new ArrayList<Zug>();
		enPossibleMoves = new ArrayList<Zug>();
		EnemyValue = new ArrayList<Integer>();
		AIValue = new ArrayList<Integer>();
	}
	
	public void setColor(int i) {
		this.color =i;
	}
	public int getColor() {
		return color;
	}
	
	
	

	
	/**
	 * method to check and restore possible moves
	 * @param board board the moves should take place on
	 * @param movePos String with each position for the move
	 * @param turn the value for the move turn
	 * @param possibleMoveList the list with each possible move
	 */
	public void checkPossMoves(Board board, String movePos, int turn,List<Zug> possibleMoveList )  {
		
		int i1 = Integer.parseInt(String.valueOf(movePos.charAt(0)));
		int j1 = Integer.parseInt(String.valueOf(movePos.charAt(1)));
		int x1 = Integer.parseInt(String.valueOf(movePos.charAt(2)));
		int y1 = Integer.parseInt(String.valueOf(movePos.charAt(3)));
		/*Figures restoreTo2 = board.getField(x1,y1);
		Figures restoreFrom2=board.getField(i1, j1);
		if (board.getField(x1,y1)!=null){
			restoreTo2=board.getField(x1, y1);
		}
		if (board.getField(x1,y1)==null) {
			restoreTo2=null;
		}	
		if(turn!=color) {
			board.setCurrentTurn(turn);
		**/
		if (board.getField(i1, j1).hasPossibleMove(board,i1,j1,Integer.toString(x1)+Integer.toString(y1))) {
		
			Zug zug = new Zug(board.getField(i1, j1),i1,j1,Integer.toString(x1)+Integer.toString(y1));
			possibleMoveList.add(zug);
			//board.setField(i1, j1, restoreFrom2);
		
		/**if (restoreTo2!=null) {
			board.setField(x1, y1,restoreTo2);
		}
		
		if (restoreTo2==null) {
			board.positionen[x1][y1]=null;
		}
			board.setCurrentTurn(color);
	**/}
	
	}
	

	
	
	/**
	 * method to convert a turn into system variable 0|1
	 * @param turn the turn to convert
	 */
	public String convertTurn(int turn) {
		switch (turn) {
		case 0:
			convTurn = "w";
			break;
		case 1:	
			convTurn = "b";
			break;
		}
		return convTurn;
	}
	
	
	
	/**
	 * method to evaluate the figures for the enemy
	 * @param board board the moves should take place on
	 */
	public int calculateValue(Board board) {
		int value=0;
		for (int x=0;x<8;x++) {
			for (int y=0;y<8;y++) {
				
				value = value+calculateFigure(board.getField(x, y),convertTurn(board.getCurrentTurn()));
					
			}
		}	
		return value;
	}
	
	/**
	 * method to evaluate the figures for the enemy
	 * @param board board the moves should take place on
	 */
	public int calculateValueFor(Board board, int Color) {
		String colorS = convertTurn(Color);
	
		int value=0;
		for (int x=0;x<8;x++) {
			for (int y=0;y<8;y++) {
				
				value = value+calculateFigure(board.getField(x, y),colorS);
				if (board.positionen[x][y]!=null&&board.positionen[x][y].getColor()==colorS) {
				value = value+positionEval(board.getField(x, y),x,y);
				}
				
				if (board.positionen[x][y] != null &&board.positionen[x][y].getColor()==colorS) {
					
					if (x == 1||y == 1) {
						value=value+1;
					}
					if (x == 2||y == 2) {
						value=value+2;
					}
					
					if (x == 3||y == 3) {
						value=value+4;
					}
					
					if (x == 4||y == 4) {
						value=value+4;
					}
					
					if (x == 5||y == 5) {
						value=value+3;
					}
					
					if (x == 6||y == 6) {
						value=value+2;
					}
					
					if (x==7||y == 7) {
						value=value+1;
					}
				}
			}
		}
		
		return value;
	}

	/**
	 * method to evaluate one single figure
	 * @param figure the figure to evaluate
	 * @param color the color from who's perspective to evaluate for
	 */
	public int calculateFigure(Figures figure, String color) {
		int valuez=0;
		int multiply;
	
	
	
		
	
		
		
				if (figure!=null&&figure.getColor()==color) {
				
					if (figure.getClass()==Bishop.class) {
						
						valuez=valuez+30;
					}
					if (figure.getClass()==King.class) {
						valuez=valuez+5000;
					}
				
					if (figure.getClass()==Knight.class) {
						valuez=valuez+30;
					}
					
					if (figure.getClass()==Pawn.class) {
						
						valuez=valuez+10;
					}
					
					if (figure.getClass()==Queen.class) {
						valuez=valuez+100;
					}
					
					if (figure.getClass()==Rook.class) {
						valuez=valuez+50;
					}
					
				}
				
			
		
		return valuez;
	}
	/**
	 * method to move random
	 * @param board board the moves should take place on
	 */
	public void DoRndMove(Board board) {
		Random rnd= new Random();

		Zug rndMove = possibleMoves.get(rnd.nextInt(possibleMoves.size()));	
		
		System.out.println("Tried move: "+rndMove.from1 + rndMove.from2 + rndMove.to1 + rndMove.to2);
		System.out.println("hasPossMoveCheck: "+board.getField(rndMove.from1, rndMove.from2).hasPossibleMove(board,rndMove.from1,rndMove.from2,Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2)));
		
		System.out.println(board.getField(rndMove.from1, rndMove.from2));
		System.out.println(board.getField(rndMove.to1, rndMove.from2));
		
		board.getField(rndMove.from1, rndMove.from2).move(board,rndMove.from1,rndMove.from2,Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2));
		
		
		
		//System.out.println(Arrays.deepToString(board.positionen));
		
		//board.movedList.add(rndMove);
		return;
	}
	
	
	
	
		
		
	
	//}
	
	public List<Zug> findPossMoves2(Board board2, int turn ) {
		
		System.out.println(board2.positionen.length);
		//System.out.println(copy.positionen.length);
		//copy.setCurrentTurn(board2.getCurrentTurn());
		List<Zug> possibleMoveList = new ArrayList<Zug>();
	
		convTurn=convertTurn(turn);
		 
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				for (int x=0;x<8;x++) {
					for (int y=0;y<8;y++) {
						if(board2.getField(i, j)!=null&&convTurn==board2.getField(i, j).getColor()){
							
							checkPossMoves(board2,Integer.toString(i)+Integer.toString(j)+Integer.toString(x)+Integer.toString(y),turn, possibleMoveList);
						}
					}
				}
			}
		}
	
			return possibleMoveList;
		}
		
	
	
	/**
	 * method to check and restore possible moves
	 * @param board board the moves should take place on
	 * @param movePos String with each position for the move
	 * @param turn the value for the move turn
	 * @param possibleMoveList the list with each possible move
	 */
	public void checkPossMoves2(Board board3, String movePos, int turn,List<Zug> possibleMoveList )  {
		
		int i1 = Character.getNumericValue(movePos.charAt(0));
		int j1 = Character.getNumericValue(movePos.charAt(1));	
		int x1 = Character.getNumericValue(movePos.charAt(2));
		int y1 = Character.getNumericValue(movePos.charAt(3));
		Figures restoreTo2 = board3.getField(x1,y1);
		Figures restoreFrom2=board3.getField(i1, j1);
		if (board3.getField(x1,y1)!=null){
			restoreTo2=board3.getField(x1, y1);
		}
		if (board3.getField(x1,y1)==null) {
			restoreTo2=null;
		}	
		if(turn!=color) {
			board3.setCurrentTurn(turn);
		}
		if (board3.getField(i1, j1).hasPossibleMove(board3,i1,j1,Integer.toString(x1)+Integer.toString(y1))) {
		
			Zug zug = new Zug(board3.getField(i1, j1),i1,j1,Integer.toString(x1)+Integer.toString(y1));
			possibleMoveList.add(zug);
			board3.setField(i1, j1, restoreFrom2);
		if (restoreTo2!=null) {
			board3.setField(x1, y1,restoreTo2);
		}
		if (restoreTo2==null) {
			board3.positionen[x1][y1]=null;
		}
		//board.setCurrentTurn(color);
	}
	}

	public void lookAhead(Board board, int desiredDepth, int color) {
		this.color=color;
		 bestMove= null;
		this.desiredDepth=desiredDepth;
		 int bewertung = max(board,desiredDepth,
		                     -100000000, 1000000000);
		 if (bestMove == null) {
		    System.out.println("Matt/Patt");
		 }
		 else {
			 board.setCurrentTurn(1);
			 board.getField(bestMove.from1, bestMove.from2).move(board, bestMove.from1,bestMove.from2, Integer.toString(bestMove.to1)+Integer.toString(bestMove.to2));
		 }
	}
	 int max(Board board, int tiefe, int alpha, int beta) {
		 List<Zug> AImoves;
		 AImoves=findPossMoves2(board,color);
	    if (tiefe == 0 || AImoves.size()==0) {
	    	
	    	
	    			int einsV=calculateValueFor(board,1);
	    			int zweiV=calculateValueFor(board,0);
	    			System.out.println(einsV);
	    			System.out.println(zweiV);
	    	System.out.println(einsV-zweiV);
	       return (calculateValueFor(board,1)-calculateValueFor(board,0))*10;
	    }
	    int maxWert = alpha;
	    for (Zug move: AImoves){
	    	Figures restoreFromEn= board.copy(move.from1, move.from2);
			Figures restoreToEn=null;
			if (board.getField(move.to1, move.to2)!=null) {
				restoreToEn= board.copy(move.to1, move.to2);
			}
			
			board.positionen[move.to1][move.to2]=board.getField(move.from1,move.from2);
			board.positionen[move.from1][move.from2]=null;
			move.getFigure().setPos(move.to1, move.to2);
			board.initializeBoard();
			int wert = min(board,tiefe-1,
	                      maxWert, beta);
			move.getFigure().setPos(move.from1, move.from2);
			board.positionen[move.from1][move.from2]=restoreFromEn;
			
			board.positionen[move.to1][move.to2]=restoreToEn;
			
			
	       if (wert > maxWert) {
	          maxWert = wert; 
	          if (tiefe == desiredDepth) { 
	             bestMove = move;
	          }
	          if (maxWert >= beta) {
	        	  System.out.println("=====================CUT=============");
	             break; 
	       }}
	    }
	    return maxWert;
	 }
	 
	 
	 
	 int min(Board board,int tiefe,int alpha, int beta) {
		 List<Zug> PlayerMoves;
		 board.setCurrentTurn(0);
		 PlayerMoves=findPossMoves2(board,0);
	    if (tiefe == 0 || PlayerMoves.size()==0) {
	    	System.out.println(calculateValueFor(board,1)-calculateValueFor(board,0));
	    	return (calculateValueFor(board,1)-calculateValueFor(board,0))*10;
	    }
	    int minWert = beta;
	   board.setCurrentTurn(0);
	    for  (Zug PlayerMove: PlayerMoves) {
	      	Figures restoreFromPl= board.copy(PlayerMove.from1, PlayerMove.from2);
	    			Figures restoreToPl=null;
	    			if (board.getField(PlayerMove.to1, PlayerMove.to2)!=null) {
	    				restoreToPl= board.copy(PlayerMove.to1, PlayerMove.to2);
	    			}
	    			
	    			board.positionen[PlayerMove.to1][PlayerMove.to2]=board.getField(PlayerMove.from1,PlayerMove.from2);
	    			board.positionen[PlayerMove.from1][PlayerMove.from2]=null;
	    			PlayerMove.getFigure().setPos(PlayerMove.to1, PlayerMove.to2);
	    			board.setCurrentTurn(1);
	       int wert = max(board,tiefe-1, alpha, minWert);
	       board.setCurrentTurn(1);
	       PlayerMove.getFigure().setPos(PlayerMove.from1, PlayerMove.from2);
	       board.positionen[PlayerMove.from1][PlayerMove.from2]=restoreFromPl;
			
			board.positionen[PlayerMove.to1][PlayerMove.to2]=restoreToPl;
	       if (wert < minWert) {
	          minWert = wert;
	          if (minWert <= alpha) {
	        	  System.out.println("=====================CUT=============");
	             break;
	       }
	    }}
	    return minWert;
	 }
	 
	 
     protected static int [] pawnTable = {
             0,  0,  0,  0,  0,  0,  0,  0,
             50, 50, 50, 50, 50, 50, 50, 50,
             10, 10, 20, 30, 30, 20, 10, 10,
             5,  5, 10, 25, 25, 10,  5,  5,
             0,  0,  0, 20, 20,  0,  0,  0,
             5, -5,-10,  0,  0,-10, -5,  5,
             5, 10, 10,-20,-20, 10, 10,  5,
             0,  0,  0,  0,  0,  0,  0,  0 };

           // Placement Precedence for all Knights
         protected static int [] knightTable = {
             -50,-40,-30,-30,-30,-30,-40,-50,
             -40,-20,  0,  0,  0,  0,-20,-40,
             -30,  0, 10, 15, 15, 10,  0,-30,
             -30,  5, 15, 20, 20, 15,  5,-30,
             -30,  0, 15, 20, 20, 15,  0,-30,
             -30,  5, 10, 15, 15, 10,  5,-30,
             -40,-20,  0,  5,  5,  0,-20,-40,
             -50,-40,-30,-30,-30,-30,-40,-50 };

         protected static int [] bishopPrecedence = {
             -20,-10,-10,-10,-10,-10,-10,-20,
             -10,  0,  0,  0,  0,  0,  0,-10,
             -10,  0,  5, 10, 10,  5,  0,-10,
             -10,  5,  5, 10, 10,  5,  5,-10,
             -10,  0, 10, 10, 10, 10,  0,-10,
             -10, 10, 10, 10, 10, 10, 10,-10,
             -10,  5,  0,  0,  0,  0,  5,-10,
             -20,-10,-10,-10,-10,-10,-10,-20 };

         protected static int [] rookTable = {
               0,  0,  0,  0,  0,  0,  0,  0,
               5, 10, 10, 10, 10, 10, 10,  5,
              -5,  0,  0,  0,  0,  0,  0, -5,
              -5,  0,  0,  0,  0,  0,  0, -5,
              -5,  0,  0,  0,  0,  0,  0, -5,
              -5,  0,  0,  0,  0,  0,  0, -5,
              -5,  0,  0,  0,  0,  0,  0, -5,
               0,  0,  0,  5,  5,  0,  0,  0 };
           
         protected static int [] queenTable = {
             -20,-10,-10, -5, -5,-10,-10,-20,
             -10,  0,  0,  0,  0,  0,  0,-10,
             -10,  0,  5,  5,  5,  5,  0,-10,
              -5,  0,  5,  5,  5,  5,  0, -5,
               0,  0,  5,  5,  5,  5,  0, -5,
             -10,  5,  5,  5,  5,  5,  0,-10,
             -10,  0,  5,  0,  0,  0,  0,-10,
             -20,-10,-10, -5, -5,-10,-10,-20 };

         protected static int [] kingTable = {
             -30,-40,-40,-50,-50,-40,-40,-30,
             -30,-40,-40,-50,-50,-40,-40,-30,
             -30,-40,-40,-50,-50,-40,-40,-30,
             -30,-40,-40,-50,-50,-40,-40,-30,
             -20,-30,-30,-40,-40,-30,-30,-20,
             -10,-20,-20,-20,-20,-20,-20,-10,
              20, 20,  0,  0,  0,  0, 20, 20,
              20, 30, 10,  0,  0, 10, 30, 20 };

        public int positionEval(Figures figure, int x, int y) {
         String name = figure.getClass().toString()+figure.getColor();
         int val=0;
         switch(name) {
         case "Pawnw":
          
           val = (100 + (pawnTable[8*(7 - y) + x])); 
           break;

         case "Pawnb":
           
           val -= (100 + (pawnTable[8 + (8* y) - (1 +x)]));
           break;


         case "Rookw":
           
           val += (500 + (rookTable[8*(7 - y) + x])); 
           break;

         case "Rookb":
           
           val -= (500 + (rookTable[8 + (8* y) - (1 +x)]));
           break;


         case "Bishopw":
           
           val += (330 + (rookTable[8*(7 - y) + x])); 
           break;

         case "Bishopb":
           
           val -= (330 + (rookTable[8 + (8* y) - (1 +x)]));
           break;


         case "Knightw":
           
           val += (320 + (knightTable[8*(7 - y) + x])); 
           break;

         case "Knightb":
           
           val -= (320 + (knightTable[8 + (8* y) - (1 +x)]));
           break;


         case "Queenw":
           
           val += (900 + (queenTable[8*(7 - y) + x])); 
           break;

         case "Queenb":
           
           val -= (900 + (queenTable[8 + (8* y) - (1 +x)]));
           break;


         case "Kingw":
           
           val += (20000 + (kingTable[8*(7 - y) + x])); 
           break;

         case "Kingb":
           
           val -= (20000 + (kingTable[8 + (8* y) - (1 +x)]));
           break;
       }
         return val;
     }
        
}

	
