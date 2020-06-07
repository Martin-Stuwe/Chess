package game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import figures.*;
import schach.Console;

public class AI {

	public List<Zug> possibleMoves;
	public List<Zug> enPossibleMoves ;
	public List<Integer> EnemyValue ;
	public List<Integer> AIValue ;
	public List<Integer> AILoss ;
	private String convTurn;
	private int min;
	private int color;
	
	
	public AI(int color) {
		this.color = color;
		possibleMoves = new ArrayList<Zug>();
		enPossibleMoves = new ArrayList<Zug>();
		EnemyValue = new ArrayList<Integer>();
		AIValue = new ArrayList<Integer>();
		AILoss = new ArrayList<Integer>();
	}
	
	public void setColor(int i) {
		this.color =i;
	}
	public int getColor() {
		return color;
	}
	
	
	public void findPossMoves(Board board, int turn ) {
		List<Zug> possibleMoveList = new ArrayList<Zug>();
	
		switch (turn) {
		case 0:
			convTurn = "w";
		case 1:	
			convTurn = "b";
	}
		 
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				for (int x=0;x<8;x++) {
					for (int y=0;y<8;y++) {
						if(board.getField(i, j)!=null&&convTurn==board.getField(i, j).getColor()&&Figures.hasPossibleMove(board,i,j,Integer.toString(x)+Integer.toString(y))) {
							if(board.getField(x, y)!= null) {
								
							}
							Zug zug = new Zug(board.getField(i, j),i,j,Integer.toString(x)+Integer.toString(y));
							possibleMoveList.add(zug);
							
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
	
	
	
	public void Calculate(Board board) {
		System.out.println("Calculate");
		EnemyValue.removeAll(EnemyValue);


		Board restBoard = board;
		switch (board.getCurrentTurn()) {
			case 0:
				convTurn = "w";
			case 1:	
				convTurn = "b";
		}
		
		for (int z=0;z<possibleMoves.size();z++) {
			EnemyValue.add(0);
			Figures f = board.getField(possibleMoves.get(z).to1,possibleMoves.get(z).to2);
			board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2]=board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2];
			board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2]=null;
			for (int x=0;x<8;x++) {
				for (int y=0;y<8;y++) {
					if (board.getField(x, y)!=null&&board.getField(x, y).getColor() != convTurn) {
					
						if (board.getField(x, y).getClass()==Bishop.class) {
							
						EnemyValue.set(z, EnemyValue.get(z)+3);
						}
						if (board.getField(x, y).getClass()==King.class) {
						EnemyValue.set(z, EnemyValue.get(z)+5000);
						}
					
						if (board.getField(x, y).getClass()==Knight.class) {
							EnemyValue.set(z, EnemyValue.get(z)+3);
						}
						
						if (board.getField(x, y).getClass()==Pawn.class) {
							EnemyValue.set(z, EnemyValue.get(z)+1);
						}
						
						if (board.getField(x, y).getClass()==Queen.class) {
							EnemyValue.set(z, EnemyValue.get(z)+10);
						}
						
						if (board.getField(x, y).getClass()==Rook.class) {
							EnemyValue.set(z, EnemyValue.get(z)+5);
						}
						
					}
				}	
				
			}
		
		if (convTurn == "b") {
		
		findPossMoves(board, 0);
		}
		else {findPossMoves(board,1);}
		for (int x=0; x<enPossibleMoves.size();x++) {
		
		if (board.getField(enPossibleMoves.get(x).to1,enPossibleMoves.get(x).to2)!=null){
			
			
			int valuex=0;
			
			
			int y = calculateFigure(board.getField(enPossibleMoves.get(x).to1,enPossibleMoves.get(x).to2),board.getField(enPossibleMoves.get(x).to1,enPossibleMoves.get(x).to2).getColor());
		
			if (y>valuex) {
				valuex=y;
			}
			EnemyValue.set(z, EnemyValue.get(z)+valuex);
		}}
					
		board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2]=board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2];
		board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2]=f;
		}
		board.setCurrentTurn(1);
		
	}
	

	
	

	public String convertTurn(int turn) {
		switch (turn) {
		case 0:
			convTurn = "w";
		case 1:	
			convTurn = "b";
	}
		return convTurn;
	}
	
	
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
	
	
	public void DoRndMove(Board board) {
		Random rnd= new Random();

		Zug rndMove = possibleMoves.get(rnd.nextInt(possibleMoves.size()));	
		System.out.println(rnd.nextInt(possibleMoves.size()));
		System.out.println(rndMove);
		if(!board.getField(possibleMoves.get(min).from1,possibleMoves.get(min).from2).move(board,possibleMoves.get(min).from1,possibleMoves.get(min).from2,Integer.toString(possibleMoves.get(min).to1)+Integer.toString(possibleMoves.get(min).to2))) {
			DoRndMove(board);
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
	
	
	
	
	
	public void DoMinMove(Board board) {
		List<Integer> sortedList = new ArrayList<>(EnemyValue);
		Collections.sort(sortedList);
		for (int x = 0; x<EnemyValue.size();x++) {
			if(EnemyValue.get(x)==sortedList.get(0)) {
				min = x;
			}
		}

		System.out.println(EnemyValue.get(0));
				
		if (sortedList.get(sortedList.size()-1).equals(sortedList.get(0))) {
			
			DoRndMove(board);
			
			
		}
		else {
			if(!board.getField(possibleMoves.get(min).from1,possibleMoves.get(min).from2).move(board,possibleMoves.get(min).from1,possibleMoves.get(min).from2,Integer.toString(possibleMoves.get(min).to1)+Integer.toString(possibleMoves.get(min).to2))) {
				DoRndMove(board);
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
