package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import figures.*;
import schach.Console;

public class AI {

	public static List<Zug> possibleMoves = new ArrayList<Zug>();
	public static List<Integer> EnemyValue = new ArrayList<Integer>();
	private static String convTurn;
	private static int min;

	
	public static void Calculate(Board board) {
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
			board.initializeBoard();
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
		board.positionen[possibleMoves.get(z).from1][possibleMoves.get(z).from2]=board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2];
		board.positionen[possibleMoves.get(z).to1][possibleMoves.get(z).to2]=f;
		}
		board.setCurrentTurn(1);
		board = restBoard;
	}
	

	
	
	public static void findPossMoves(Board board) {
		switch (board.getCurrentTurn()) {
		case 0:
			convTurn = "w";
		case 1:	
			convTurn = "b";
	}
		possibleMoves.removeAll(possibleMoves);
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				for (int x=0;x<8;x++) {
					for (int y=0;y<8;y++) {
						if(board.getField(i, j)!=null&&convTurn==board.getField(i, j).getColor()&&Figures.hasPossibleMove(board,i,j,Integer.toString(x)+Integer.toString(y))) {
							Zug zug = new Zug(board.getField(i, j),i,j,Integer.toString(x)+Integer.toString(y));
							possibleMoves.add(zug);
						}
					}
				}
			}
		}
	}
	
	
	
	
	public static void DoRndMove(Board board) {
		Random rnd= new Random();

		Zug rndMove = possibleMoves.get(rnd.nextInt(possibleMoves.size()));	
		System.out.println(rnd.nextInt(possibleMoves.size()));
		System.out.println(rndMove);
		Figures.move(board,rndMove.from1,rndMove.from2,Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2));
		return;
	}
	
	
	
	
	
	public static void DoMinMove(Board board) {
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
			Figures.move(board,possibleMoves.get(min).from1,possibleMoves.get(min).from2,Integer.toString(possibleMoves.get(min).to1)+Integer.toString(possibleMoves.get(min).to2));
		}
	
	}
	
	public static String ConvertSysInToConsole(int from1, int from2, int to1, int to2) {
		String pos1new;
		switch (from1) {
		case 0:
			pos1new ="a";
			break;
		case 1:
			pos1new ="b";
			break;
		case 2:
			pos1new ="c";
			break;
		case 3:
			pos1new ="d";
			break;
		case 4:
			pos1new ="e";
			break;
		case 5:
			pos1new ="f";
			break;
		case 6:
			pos1new ="g";
			break;
		case 7:
			pos1new ="g";
			break;
		default:
			pos1new="420";
			return "420";
		}
		from2 =-1*(from2+8);
		
		return pos1new;
		
	}
	
}
