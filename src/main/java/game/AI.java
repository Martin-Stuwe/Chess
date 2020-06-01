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
		Console AIconsole = new Console();
		AIconsole.input="AI Move";
		Board restBoard = board;
		switch (board.getCurrentTurn()) {
			case 0:
				convTurn = "w";
			case 1:	
				convTurn = "b";
		}
		
		for (int z=0;z<possibleMoves.size();z++) {
			EnemyValue.add(0);
		StartGame.convertAndMoveCheck(board,Integer.toString(possibleMoves.get(z).from1)+Integer.toString(possibleMoves.get(z).from2)+Integer.toString(possibleMoves.get(z).to1)+Integer.toString(possibleMoves.get(z).to2),AIconsole);
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
		}
		board = restBoard;
	}

	
	
	public static void findPossMoves(Board board) {
		possibleMoves.removeAll(possibleMoves);
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				for (int x=0;x<8;x++) {
					for (int y=0;y<8;y++) {
						if(board.getField(i, j)!=null&&Figures.hasPossibleMove(board,i,j,Integer.toString(x)+Integer.toString(y))) {
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
		Console AIconsole = new Console();
		AIconsole.input="AI Move";
		
		StartGame.convertAndMoveCheck(board,Integer.toString(rndMove.from1)+Integer.toString(rndMove.from2)+Integer.toString(rndMove.to1)+Integer.toString(rndMove.to2),AIconsole);
		
	}
	public static void DoMinMove(Board board) {
		List<Integer> sortedList = new ArrayList<>(EnemyValue);
		Collections.sort(sortedList);
		for (int x = 0; x<EnemyValue.size();x++) {
			if(EnemyValue.get(x)==sortedList.get(0)) {
				min = x;
			}
		}
						Console AIconsole = new Console();
		AIconsole.input="AI Move";
		
		StartGame.convertAndMoveCheck(board,Integer.toString(possibleMoves.get(min).from1)+Integer.toString(possibleMoves.get(min).from2)+Integer.toString(possibleMoves.get(min).to1)+Integer.toString(possibleMoves.get(min).to2),AIconsole);
		
	
	}
	
}
