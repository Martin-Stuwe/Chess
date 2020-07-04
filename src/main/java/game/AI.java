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
	* the position for the min move
	*/
	private int min;
	
	/**
	 * the color of the AI 
	 */
	private int color;
	
	/**
	 * the from figure to restore
	 */
	private static  Figures restoreFrom;
	
	/**
	 * the to figure to restore
	 */
	private static Figures restoreTo;
	
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
	 * method to find possible Moves for a side and save them in a list
	 * @param board board the moves should take place on
	 * @param turn the side to find possible moves for
	 */
	public void findPossMoves(Board board, int turn ) {
		List<Zug> possibleMoveList = new ArrayList<Zug>();
	
		convTurn=convertTurn(turn);
		 
		for (int i22=0;i22<8;i22++) {
			for (int j22=0;j22<8;j22++) {
				for (int x22=0;x22<8;x22++) {
					for (int y22=0;y22<8;y22++) {
						if(board.getField(i22, j22)!=null&&convTurn==board.getField(i22, j22).getColor()){
							
							checkPossMoves(board,Integer.toString(i22)+Integer.toString(j22)+Integer.toString(x22)+Integer.toString(y22),turn, possibleMoveList);
						}
					}
				}
			}
		}
		if(turn==color) {
			possibleMoves = possibleMoveList;
		}
		else {
			enPossibleMoves = possibleMoveList;
		}
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
	 * method to evaluate the the board after every possible move
	 * @param board board the moves should take place on
	 */
	public void Calculate(Board board) {
		EnemyValue.removeAll(EnemyValue);

		switch (board.getCurrentTurn()) {
			case 0:
				convTurn = "w";
				break;
			case 1:	
				convTurn = "b";
				break;
		}
		int savecolor = color;
		System.out.println("Test3");
		
		
		
		
		for (int E=0;E<possibleMoves.size();E++) {
			EnemyValue.add(0);
			System.out.println(possibleMoves.size());
			
			
			restoreTo = board.copy(possibleMoves.get(E).to1,possibleMoves.get(E).to2);
			restoreFrom = board.copy(possibleMoves.get(E).from1, possibleMoves.get(E).from2);
			board.positionen[possibleMoves.get(E).to1][possibleMoves.get(E).to2]=board.getField(possibleMoves.get(E).from1, possibleMoves.get(E).from2);
			board.positionen[possibleMoves.get(E).from1][possibleMoves.get(E).from2]=null;
			//board.initializeBoard();

			EnemyValue.set(E, calculateValue(board));
			
			switch (color) {
			case 0:
				convTurn = "w";
				break;
			case 1:	
				convTurn = "b";
				break;
			}
			
			System.out.println("test4");
			
			
		
		if (convTurn == "b") {
		
		board.setCurrentTurn(0);
		enPossibleMoves=findPossMoves2(board, 0);
		//convTurn = "b";
		//board.setCurrentTurn(1);
		//board.setCurrentTurn(savecolor);
		
		}
		else {
			enPossibleMoves= findPossMoves2(board,1);
			//board.setCurrentTurn(savecolor);
		}
	
	
		
		
		
		System.out.println("Size is "+ enPossibleMoves.size());
		for (int K=0; K<enPossibleMoves.size();K++) {
		System.out.println("Test");
		System.out.println(board.getField(enPossibleMoves.get(K).from1,enPossibleMoves.get(K).from2));
		if (board.getField(enPossibleMoves.get(K).from1,enPossibleMoves.get(K).from2)!=null){
			Figures restoreFromEn= board.copy(enPossibleMoves.get(K).from1, enPossibleMoves.get(K).from2);
			Figures restoreToEn=null;
			if (board.getField(enPossibleMoves.get(K).to1, enPossibleMoves.get(K).to2)!=null) {
				restoreToEn= board.copy(enPossibleMoves.get(K).to1, enPossibleMoves.get(K).to2);
			}
			
			board.positionen[enPossibleMoves.get(K).to1][enPossibleMoves.get(K).to2]=board.getField(enPossibleMoves.get(K).from1,enPossibleMoves.get(K).from2);
			board.positionen[enPossibleMoves.get(K).from1][enPossibleMoves.get(K).from2]=null;
			
				//EnemyValue2.add(calculateValueFor(board,0));
				//AIValue2.add(calculateValueFor(board,1));
			
			
			board.initializeBoard();
				

			int valuex=calculateValueFor(board,0)-calculateValueFor(board,1);
		
			
			//board.setCurrentTurn(0);
			List<Zug> AImove2 = findPossMoves2(board,0);
			//board.setCurrentTurn(1);
			//System.out.println("Second AI Move would be"+ AImove2);
				
				board.positionen[enPossibleMoves.get(K).from1][enPossibleMoves.get(K).from2]=restoreFromEn;
				
				board.positionen[enPossibleMoves.get(K).to1][enPossibleMoves.get(K).to2]=restoreToEn;
				
			
		
			//int y4 = calculateFigure(board.getField(enPossibleMoves.get(K).to1,enPossibleMoves.get(K).to2),board.getField(enPossibleMoves.get(K).to1,enPossibleMoves.get(K).to2).getColor());
			

	}}
		
		enPossibleMoves = new ArrayList<Zug>(); ;
			
					
			board.positionen[possibleMoves.get(E).from1][possibleMoves.get(E).from2]=restoreFrom;
			
			board.positionen[possibleMoves.get(E).to1][possibleMoves.get(E).to2]=restoreTo;

		}
	
		board.setCurrentTurn(savecolor);
		
		
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
						
						valuez=valuez+3;
					}
					if (figure.getClass()==King.class) {
						valuez=valuez+5000;
					}
				
					if (figure.getClass()==Knight.class) {
						valuez=valuez+3;
					}
					
					if (figure.getClass()==Pawn.class) {
						
						valuez=valuez+1;
					}
					
					if (figure.getClass()==Queen.class) {
						valuez=valuez+10;
					}
					
					if (figure.getClass()==Rook.class) {
						valuez=valuez+5;
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
	
	
	
	
	/**
	 * method to find do the least valued move if the is one
	 * @param board board the moves should take place on
	 */
	public void DoMinMove(Board board) {
		List<Integer> sortedList = new ArrayList<>(EnemyValue);
		Collections.sort(sortedList);
		for (int x = 0; x<EnemyValue.size();x++) {
			if(EnemyValue.get(x)==sortedList.get(0)) {
				min = x;
			}
		}
		if (sortedList.size()==0 ) {
			
			DoRndMove(board);
			System.out.println("1. RNDmove");
			possibleMoves.clear();
			return;
			
		}
		
		//else {
			
			if(sortedList.get(sortedList.size()-1).equals(sortedList.get(0))) {
				System.out.println("3");
				DoRndMove(board);
				System.out.println("2. RNDmove");
				possibleMoves.clear();
				return;
				
			}
			else {
				Zug minMove = possibleMoves.get(min);	
				
				System.out.println("Tried move: "+minMove.from1 + minMove.from2 + minMove.to1 + minMove.to2);
				System.out.println("hasPossMoveCheck: "+board.getField(minMove.from1, minMove.from2).hasPossibleMove(board,minMove.from1,minMove.from2,Integer.toString(minMove.to1)+Integer.toString(minMove.to2)));
				
				System.out.println(board.getField(minMove.from1, minMove.from2));
				System.out.println(board.getField(minMove.to1, minMove.from2));
				
				board.getField(minMove.from1, minMove.from2).move(board,minMove.from1,minMove.from2,Integer.toString(minMove.to1)+Integer.toString(minMove.to2));
				

				//System.out.println(Arrays.deepToString(board.positionen));
				possibleMoves.clear();
				//board.movedList.add(minMove);
				return;
				
				
			}
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
	       return calculateValueFor(board,1)-calculateValueFor(board,0);
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
	    	return calculateValueFor(board,1)-calculateValueFor(board,0);
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
	 
	
} 