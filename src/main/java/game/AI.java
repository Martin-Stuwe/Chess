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
	
	private Board copy;
	
	/**
	 * the from figure to restore
	 */
	private Figures restoreFrom;
	
	/**
	 * the to figure to restore
	 */
	private Figures restoreTo;
	
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
	
	
	public Board boardCopy(Board boardtocop) {
		Board boardcopy= new Board();
		for(int az = 0; az < 8; az++) {
			for(int ax=0; ax< 0; ax++) {
				boardcopy.setField(az, ax, boardtocop.copy(az, ax));
			}
		}
		return boardcopy;
	}
	
	/**
	 * method to find possible Moves for a side and save them in a list
	 * @param board board the moves should take place on
	 * @param turn the side to find possible moves for
	 */
	public void findPossMoves(Board board, int turn ) {
		Board COPY = boardCopy(board);
		copy=COPY;
		System.out.println(board.positionen.length);
		System.out.println(copy.positionen.length);
		copy.setCurrentTurn(board.getCurrentTurn());
		List<Zug> possibleMoveList = new ArrayList<Zug>();
	
		convTurn=convertTurn(turn);
		 
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				for (int x=0;x<8;x++) {
					for (int y=0;y<8;y++) {
						if(board.getField(i, j)!=null&&convTurn==board.getField(i, j).getColor()){
							
							checkPossMoves(board,Integer.toString(i)+Integer.toString(j)+Integer.toString(x)+Integer.toString(y),turn, possibleMoveList);
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
		
		int i1 = Character.getNumericValue(movePos.charAt(0));
		int j1 = Character.getNumericValue(movePos.charAt(1));	
		int x1 = Character.getNumericValue(movePos.charAt(2));
		int y1 = Character.getNumericValue(movePos.charAt(3));
		Figures restoreTo2 = board.getField(x1,y1);
		Figures restoreFrom2=board.getField(i1, j1);
		if (board.getField(x1,y1)!=null){
			restoreTo2=board.getField(x1, y1);
		}
		if (board.getField(x1,y1)==null) {
			restoreTo2=null;
		}	
		if(turn!=color) {
			board.setCurrentTurn(turn);
		}
		if (board.getField(i1, j1).hasPossibleMove(board,i1,j1,Integer.toString(x1)+Integer.toString(y1))) {
		
			Zug zug = new Zug(board.getField(i1, j1),i1,j1,Integer.toString(x1)+Integer.toString(y1));
			possibleMoveList.add(zug);
			board.setField(i1, j1, restoreFrom2);
		if (restoreTo2!=null) {
			board.setField(x1, y1,restoreTo2);
		}
		if (restoreTo2==null) {
			board.positionen[x1][y1]=null;
		}
		//board.setCurrentTurn(color);
	}
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
		for (int E=0;E<possibleMoves.size();E++) {
			EnemyValue.add(0);
			Figures f = board.getField(possibleMoves.get(E).to1,possibleMoves.get(E).to2);
			Figures from = board.getField(possibleMoves.get(E).from1, possibleMoves.get(E).from2);
			board.positionen[possibleMoves.get(E).to1][possibleMoves.get(E).to2]=from;
			board.positionen[possibleMoves.get(E).from1][possibleMoves.get(E).from2]=null;
			//board.initializeBoard();

			EnemyValue.set(E, calculateValue(copy));
			
			switch (color) {
			case 0:
				convTurn = "w";
				break;
			case 1:	
				convTurn = "b";
				break;
			}
		if (convTurn == "b") {
			board.setCurrentTurn(0);
		findPossMoves2(board, 0);
		System.out.println(this.enPossibleMoves);
		//convTurn = "b";
		//board.setCurrentTurn(1);
		//board.setCurrentTurn(savecolor);
		}
		else {
			//findPossMoves(board,1);
			//board.setCurrentTurn(savecolor);
			}
		for (int K=0; K<enPossibleMoves.size();K++) {
		
		if (copy.getField(enPossibleMoves.get(K).to1,enPossibleMoves.get(K).to2)!=null){
			
			
			int valuex=0;
			
			
			int y4 = calculateFigure(board.getField(enPossibleMoves.get(K).to1,enPossibleMoves.get(K).to2),board.getField(enPossibleMoves.get(K).to1,enPossibleMoves.get(K).to2).getColor());
			
			if (y4>valuex) {
				valuex=y4;
			}
			EnemyValue.set(E, EnemyValue.get(E)+valuex);
		
	}}
		
		enPossibleMoves = new ArrayList<Zug>(); ;
			
					
		board.positionen[possibleMoves.get(E).from1][possibleMoves.get(E).from2]=from;
			
		board.positionen[possibleMoves.get(E).to1][possibleMoves.get(E).to2]=f;

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
	 * method to evaluate one single figure
	 * @param figure the figure to evaluate
	 * @param color the color from who's perspective to evaluate for
	 */
	public int calculateFigure(Figures figure, String color) {
		int value=0;
	
				if (figure!=null&&figure.getColor()!=color) {
				
					if (figure.getClass()==Bishop.class) {
						
						value=3;
					}
					if (figure.getClass()==King.class) {
						value=5000;
					}
				
					if (figure.getClass()==Knight.class) {
						value=3;
					}
					
					if (figure.getClass()==Pawn.class) {
						value=1;
					}
					
					if (figure.getClass()==Queen.class) {
						value=10;
					}
					
					if (figure.getClass()==Rook.class) {
						value=5;
					}
					
				}
				
			
		
		return value;
	}
	
	/**
	 * method to move random
	 * @param board board the moves should take place on
	 */
	public void DoRndMove(Board board) {
		Random rnd= new Random();

		Zug rndMove = possibleMoves.get(rnd.nextInt(possibleMoves.size()));	
		
		System.out.println("Tried move: "+rndMove.from1 + rndMove.from2 + rndMove.to1 + rndMove.to2);
		//System.out.println("hasPossMoveCheck: "+board.getField(rndMove.from1, rndMove.from2).hasPossibleMove(board,rndMove.from1,rndMove.from2,Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2)));
		
		//System.out.println(board.getField(rndMove.from1, rndMove.from2));
		//System.out.println(board.getField(rndMove.to1, rndMove.to2));
		
		board.getField(rndMove.from1, rndMove.from2).move(board,rndMove.from1,rndMove.from2,Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2));
		
		
		
		//System.out.println(Arrays.deepToString(board.positionen));
		
		board.movedList.add(rndMove);
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
			
		}
		
		else {
			
			if(sortedList.get(sortedList.size()-1).equals(sortedList.get(0))) {
				System.out.println("3");
				DoRndMove(board);
				System.out.println("2. RNDmove");
				possibleMoves.clear();
				
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
				
				board.movedList.add(minMove);
			}
		}
		
		
	
	}
	
	
	public void findPossMoves2(Board board2, int turn ) {
	
		System.out.println(board2.positionen.length);
		System.out.println(copy.positionen.length);
		copy.setCurrentTurn(board2.getCurrentTurn());
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
	
			enPossibleMoves = possibleMoveList;
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
} 
