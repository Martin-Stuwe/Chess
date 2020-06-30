package game;

import figures.*;

public class Puzzle {
	
	public Board board;
	
	public void startPuzzle1() {
		board.setField(1, 1, new Bishop(1, 1, "w"));
		board.setField(7, 1, new Rook(7,1, "b"));
		board.setField(6, 4, new Knight(6,4, "w"));
		board.setField(6, 6, new Knight(6,6, "w"));
		board.setField(5, 6, new Pawn(5,6, "b"));
		board.setField(5,7, new King(5,7, "w"));
		board.setField(7,7, new King(7,7, "b"));
	}
	
	public void startPuzzle2() {
		board.setStart();
		// e4
		board.getField(4,6).move(board, 4, 6, "44");
		// e5
		board.getField(4,1).move(board, 4, 1, "43");
		// Nf3
		board.getField(6,7).move(board, 6,7, "55");
		// h6
		board.getField(7, 1).move(board, 7, 1, "72");
		// Nc3
		board.getField(1, 7).move(board, 1, 7, "35");
		// d6
		board.getField(3, 1).move(board,3,1,"32");
		// Bc4
		board.getField(5, 7).move(board, 5, 7, "24");
		// Bg4
		board.getField(2, 0).move(board, 2, 0,"64");
		
		board.movedList.clear();
	}
	
	public void startPuzzle3() {
		
	}
	
	public void startPuzzle4() {
		
	}
	
	public void startPuzzle5() {
		
	}
	
	public void startPuzzle6() {
		
	}
	
	public void startPuzzle7() {
		
	}
	
	public void startPuzzle8() {
		
	}
	
	public void startPuzzle9() {
		
	}
	
	public void startPuzzle10() {
		
	}

	
}
