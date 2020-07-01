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
		// black figures
		board.setField(0, 1, new Pawn(0, 1, "b"));
		board.setField(4, 3, new Pawn(4,3, "b"));
		board.setField(5, 2, new Pawn(5,2, "b"));
		board.setField(6, 2, new Pawn(6,2, "b"));
		board.setField(7, 2, new Pawn(7,2, "b"));
		board.setField(0, 0, new King(0,0, "b"));
		board.setField(1, 1, new Bishop(1,1, "b"));
		board.setField(0, 3, new Queen(0,3, "b"));
		board.setField(2, 5, new Rook(2,5, "b"));
		// white figures
		board.setField(0, 6, new Pawn(0,6, "w"));
		board.setField(2, 6, new Pawn(2,6, "w"));
		board.setField(5, 4, new Pawn(5,4, "w"));
		board.setField(6,3, new Pawn(6,3, "w"));
		board.setField(7, 2, new Pawn(7,2, "w"));
		board.setField(0, 7, new King(0,7, "w"));
		board.setField(1, 6, new Knight(1,6,"w"));
		board.setField(2, 7, new Rook(2,7, "w"));
		board.setField(4, 7, new Queen(4,7, "w"));
	}
	
	public void startPuzzle4() {
		// black figures
		board.setField(1, 2, new Pawn(1,2, "b"));
		board.setField(2, 3, new Pawn(2,3, "b"));
		board.setField(4, 2, new Pawn(4,2, "b"));
		board.setField(5, 1, new Pawn(5,1, "b"));
		board.setField(6, 1, new Pawn(6,1, "b"));
		board.setField(7, 2, new Pawn(7,2, "b"));
		board.setField(1, 3, new Bishop(1,3, "b"));
		board.setField(2, 4, new Knight(2,4, "b"));
		board.setField(2, 1, new Queen(2,1, "b"));
		board.setField(4, 1, new Bishop(4,1, "b"));
		board.setField(5, 0, new Rook(5,0, "b"));
		board.setField(6, 0, new King(6,0,"b"));
		// white figures
		board.setField(0, 6, new Pawn(0,6,"w"));
		board.setField(1, 6, new Pawn(1,6,"w"));
		board.setField(2, 5, new Pawn(2,5,"w"));
		board.setField(5, 4, new Pawn(5,4,"w"));
		board.setField(6, 6, new Pawn(6,6,"w"));
		board.setField(7, 6, new Pawn(7,6,"w"));
		board.setField(2, 6, new Bishop(2,6,"w"));
		board.setField(3, 7, new Rook(3,7,"w"));
		board.setField(4, 5, new Bishop(4,5,"w"));
		board.setField(4, 3, new Knight(4,3,"w"));
		board.setField(5, 5, new Queen(5,5,"w"));
		board.setField(6, 7, new King(6,7,"w"));
	}
	
	public void startPuzzle5() {
		// black figures
		board.setField(2, 1, new Pawn(2,1,"b"));
		board.setField(3, 2, new Pawn(3,2,"b"));
		board.setField(5, 1, new Pawn(5,1,"b"));
		board.setField(6, 1, new Pawn(6,1,"b"));
		board.setField(7, 1, new Pawn(7,1,"b"));
		board.setField(1, 1, new Queen(1,1,"b"));
		board.setField(2, 2, new Bishop(2,2,"b"));
		board.setField(2, 3, new Bishop(2,3,"b"));
		board.setField(4, 3, new Knight(4,3,"b"));
		board.setField(5, 0, new Rook(5,0,"b"));
		board.setField(6, 0, new King(6,0,"b"));
		// white
		board.setField(1, 5, new Pawn(1,5,"w"));
		board.setField(2, 4, new Pawn(2,4,"w"));
		board.setField(5, 6, new Pawn(5,6,"w"));
		board.setField(6, 6, new Pawn(6,6,"w"));
		board.setField(7, 6, new Pawn(7,6,"w"));
		board.setField(2, 6, new Queen(2,6,"w"));
		board.setField(2, 5, new Bishop(2,5,"w"));
		board.setField(3, 3, new Knight(3,3,"w"));
		board.setField(4, 5, new Rook(4,5,"w"));
		board.setField(5, 7, new Knight(5,7,"w"));
		board.setField(6, 7, new King(6,7,"w"));
	}
	
	public void startPuzzle6() {
		// black
		board.setField(0, 1, new Pawn(0,1,"b"));
		board.setField(1, 1, new Pawn(1,1,"b"));
		board.setField(2, 2, new Pawn(2,2,"b"));
		board.setField(7, 3, new Pawn(7,3,"b"));
		board.setField(0, 0, new King(0,0, "b"));
		board.setField(1, 2, new Bishop(1,2,"b"));
		board.setField(2, 1, new Knight(2,1,"b"));
		board.setField(5, 0, new Rook(5,0,"b"));
		board.setField(5, 1, new Queen(5,1,"b"));
		// white
		board.setField(0, 5, new Pawn(0,5,"w"));
		board.setField(1, 6, new Pawn(1,6,"w"));
		board.setField(2, 5, new Pawn(2,5,"w"));
		board.setField(3, 4, new Pawn(3,4,"w"));
		board.setField(7, 4, new Pawn(7,4,"w"));
		board.setField(0,7, new King(0,7,"w"));
		board.setField(5, 2, new Bishop(5,2,"w"));
		board.setField(5, 4, new Rook(5,4,"w"));
		board.setField(7, 5, new Queen(7,5,"w"));
	}
	
	public void startPuzzle7() {
		// black
		board.setField(0, 2, new Pawn(0,2,"b"));
		board.setField(2, 1, new Pawn(2,1,"b"));
		board.setField(6, 2, new Pawn(6,2,"b"));
		board.setField(7, 1, new Pawn(7,1,"b"));
		board.setField(1, 1, new King(1,1,"b"));
		board.setField(2, 2, new Rook(2,2,"b"));
		board.setField(2, 4, new Rook(2,4,"b"));
		// white
		board.setField(0, 3, new Pawn(0,3,"w"));
		board.setField(1, 4, new Pawn(1,4,"w"));
		board.setField(4, 4, new Pawn(4,4,"w"));
		board.setField(7, 6, new Pawn(7,6,"w"));
		board.setField(0, 4, new King(0,4,"w"));
		board.setField(3, 3, new Queen(3,3,"w"));
	}
	
	public void startPuzzle8() {
		// black
		board.setField(1, 3, new Pawn(1,3, "b"));
		board.setField(2, 5, new Pawn(2,5, "b"));
		board.setField(5, 2, new Pawn(5,2, "b"));
		board.setField(6, 1, new Pawn(6,1, "b"));
		board.setField(7, 2, new Pawn(7,2, "b"));
		board.setField(2, 2, new King(2,2, "b"));
		board.setField(0, 6, new Rook(0,6, "b"));
		// white
		board.setField(4, 2, new Pawn(4,2, "w"));
		board.setField(5, 3, new Pawn(5,3, "w"));
		board.setField(6, 4, new Pawn(6,4, "w"));
		board.setField(7, 6, new Pawn(7,6, "w"));
		board.setField(3, 4, new Rook(3,4, "w"));
		board.setField(5, 7, new King(5,7, "w"));
	}
	
	public void startPuzzle9() {
		// black
		board.setField(0, 1, new Pawn(0,1,"b"));
		board.setField(1, 2, new Pawn(1,2,"b"));
		board.setField(2, 1, new Pawn(2,1,"b"));
		board.setField(6, 2, new Pawn(6,2,"b"));
		board.setField(7, 1, new Pawn(7,1,"b"));
		board.setField(1, 0, new King(1,0, "b"));
		board.setField(1, 1, new Bishop(1,1,"b"));
		board.setField(1, 4, new Knight(1,4,"b"));
		board.setField(4, 1, new Knight(4,1,"b"));
		board.setField(5, 4, new Queen(5,4,"b"));
		board.setField(7, 0, new Rook(7,0,"b"));
		// white
		board.setField(0, 6, new Pawn(0,6,"w"));
		board.setField(1, 5, new Pawn(1,5,"w"));
		board.setField(2, 6, new Pawn(2,6,"w"));
		board.setField(6, 4, new Pawn(6,4,"w"));
		board.setField(7, 5, new Pawn(7,5,"w"));
		board.setField(1, 7, new King(1,7,"w"));
		board.setField(2, 7, new Rook(2,7,"w"));
		board.setField(3, 5, new Bishop(3,5,"w"));
		board.setField(4, 4, new Knight(4,4,"w"));
		board.setField(7, 4, new Knight(7,4,"w"));
		board.setField(6, 7, new Queen(6,7,"w"));
		
	}
	
	public void startPuzzle10() {
		// black
		board.setField(0, 1, new Pawn(0,1,"b"));
		board.setField(1, 1, new Pawn(1,1,"b"));
		board.setField(2, 1, new Pawn(2,1,"b"));
		board.setField(5, 2, new Pawn(5,2,"b"));
		board.setField(6, 1, new Pawn(6,1,"b"));
		board.setField(7, 1, new Pawn(7,1,"b"));
		board.setField(1, 0, new King(1,0,"b"));
		board.setField(3, 1, new Queen(3,1,"b"));
		board.setField(3, 3, new Rook(3,3,"b"));
		board.setField(3, 4, new Knight(3,4,"b"));
		// white
		board.setField(0, 5, new Pawn(0,5,"w"));
		board.setField(1, 6, new Pawn(1,6,"w"));
		board.setField(2, 6, new Pawn(2,6,"w"));
		board.setField(3, 5, new Pawn(3,5,"w"));
		board.setField(6, 5, new Pawn(6,5,"w"));
		board.setField(7, 6, new Pawn(7,6,"w"));
		board.setField(1, 7, new King(1,7,"w"));
		board.setField(2, 5, new Queen(2,5,"w"));
		board.setField(4, 4, new Rook(4,4,"w"));
		board.setField(5, 4, new Bishop(5,4,"w"));
	}

	
}
