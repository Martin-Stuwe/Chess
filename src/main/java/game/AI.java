package game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import figures.*;


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
	
	
	
	
	/**
	 * method to find possible Moves for a side and save them in a list
	 * @param board board the moves should take place on
	 * @param turn the side to find possible moves for
	 */
	public void findPossMoves(Board board, int turn ) {
		List<Zug> possibleMoveList = new ArrayList<Zug>();
	
		switch (turn) {
		case 0:
			convTurn = "w";
			break;
		case 1:	
			convTurn = "b";
			break;
	}
		 
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				for (int x=0;x<8;x++) {
					for (int y=0;y<8;y++) {
						if(board.getField(i, j)!=null&&convTurn==board.getField(i, j).getColor()){
							
							restoreFrom=board.getField(i, j);
							if (board.getField(x,y)!=null){
							restoreTo=board.getField(x, y);}
							if (board.getField(x,y)==null) {
								restoreTo=null;
							}	
							if(turn!=color) {
								board.setCurrentTurn(turn);
							}
							if (board.getField(i, j).hasPossibleMove(board,i,j,Integer.toString(x)+Integer.toString(y))) {
							
							Zug zug = new Zug(board.getField(i, j),i,j,Integer.toString(x)+Integer.toString(y));
							possibleMoveList.add(zug);
							board.setField(i, j, restoreFrom);
							if (restoreTo!=null) {
							board.setField(x, y,restoreTo);
							}
							if (restoreTo==null) {
								board.positionen[x][y]=null;
							}
							board.setCurrentTurn(color);
						}
							}
					}
				}
			}
		}
		if(turn == color) {
			possibleMoves = possibleMoveList;
		}
		else {
			enPossibleMoves = possibleMoveList;
		}
	}
	
	
	/**
	 * method to evaluate the the board after every possible move
	 * @param board board the moves should take place on
	 */
	public void Calculate(Board board) {
		System.out.println("Calculate");
		EnemyValue.removeAll(EnemyValue);

		switch (board.getCurrentTurn()) {
			case 0:
				convTurn = "w";
				break;
			case 1:	
				convTurn = "b";
				break;
		}
		
		for (int z=0;z<possibleMoves.size();z++) {
			EnemyValue.add(0);
			Figures f = board.getField(possibleMoves.get(z).to1,possibleMoves.get(z).to2);
			board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2]=board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2];
			board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2]=null;
			board.initializeBoard();

			EnemyValue.set(z, calculateValue(board));
			//switch (color) {
			//case 0:
				//convTurn = "w";
				//break;
			//case 1:	
				//convTurn = "b";
				//break;
		
		//if (convTurn == "b") {
			//board.setCurrentTurn(0);
		//findPossMoves(board, 0);
		//board.setCurrentTurn(1);
		//}
		//else {
			//findPossMoves(board,1);
			//}
		//for (int x=0; x<enPossibleMoves.size();x++) {
		
		//if (board.getField(enPossibleMoves.get(x).to1,enPossibleMoves.get(x).to2)!=null){
			
			
			//int valuex=0;
			
			
			//int y = calculateFigure(board.getField(enPossibleMoves.get(x).to1,enPossibleMoves.get(x).to2),board.getField(enPossibleMoves.get(x).to1,enPossibleMoves.get(x).to2).getColor());
		
			//if (y>valuex) {
				//valuex=y;
			//}
			//EnemyValue.set(z, EnemyValue.get(z)+valuex);
		//}
		//}
					
		board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2]=board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2];
		board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2]=f;

		}
	
		board.setCurrentTurn(1);
		
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
				if (board.getField(x, y)!=null&&board.getField(x, y).getColor() != convTurn) {
				
					if (board.getField(x, y).getClass()==Bishop.class) {
						
						value=value+3;
					}
					if (board.getField(x, y).getClass()==King.class) {
						value=value+5000;
					}
				
					if (board.getField(x, y).getClass()==Knight.class) {
						value=value+3;
					}
					
					if (board.getField(x, y).getClass()==Pawn.class) {
						value=value+1;
					}
					
					if (board.getField(x, y).getClass()==Queen.class) {
						value=value+10;
					}
					
					if (board.getField(x, y).getClass()==Rook.class) {
						value=value+5;
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
		System.out.println(rnd.nextInt(possibleMoves.size()));
		System.out.println(rndMove);
		board.getField(rndMove.from1, rndMove.from2).move(board,rndMove.from1,rndMove.from2,Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2));
		
		
		GuiCalcs Test = new GuiCalcs();
        String from1 =Test.numberToString(possibleMoves.get(min).from1);
        String to1 =Test.numberToString(possibleMoves.get(min).to1);
        int from2= Test.numberToNumber(possibleMoves.get(min).from2);
        int to2= Test.numberToNumber(possibleMoves.get(min).to2);
        System.out.println(from1+Integer.toString(from2));
        System.out.println("TO");
        System.out.println(to1+Integer.toString(to2));
        System.out.println("420");
		
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
		System.out.println(sortedList);
		System.out.println(min);
		System.out.println(min);
		System.out.println(sortedList.size());
		if (sortedList.size()==0 ) {
			
			DoRndMove(board);
			 System.out.println("320");
			
		}
		
		else {
			System.out.println(sortedList.get(sortedList.size()-1)==sortedList.get(0));
			System.out.println("müssen gleich sein:");
			System.out.println(sortedList.get(sortedList.size()-1));
			System.out.println(sortedList.get(0));
			
			if(sortedList.get(sortedList.size()-1).equals(sortedList.get(0))) {
				System.out.println("3");
				DoRndMove(board);
			}
			else {
				Zug minMove = possibleMoves.get(min);	
				board.getField(minMove.from1, minMove.from2).move(board,minMove.from1,minMove.from2,Integer.toString(minMove.to1)+Integer.toString(minMove.to2));
			}
			GuiCalcs Test = new GuiCalcs();
	        String from1 =Test.numberToString(possibleMoves.get(min).from1);
	        String to1 =Test.numberToString(possibleMoves.get(min).to1);
	        int from2= Test.numberToNumber(possibleMoves.get(min).from2);
	        int to2= Test.numberToNumber(possibleMoves.get(min).to2);
	        System.out.println(from1+Integer.toString(from2));
	        System.out.println("TO");
	        System.out.println(to1+Integer.toString(to2));
		}
	
	}
} 
