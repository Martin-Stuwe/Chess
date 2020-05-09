package figures;

import game.Board;
import game.Figures;

public class Rook extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 private boolean hasMoved;
	 
	public Rook(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 6;
		this.hasMoved = false;
	}
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "R";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "r";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	
	public String getColor() {
		return color;
	}
	
	// possible move restriction for Rook
	public boolean validMove(Board board,int x, int y) {
		boolean emptySpaces = true;
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		else if(this.pos1 == x && this.pos2 != y) {
			
			if(y > this.pos2) {
				for(int i=this.pos2+1;i<y; i++) {
					if(board.getField(x, i) != null) {
						emptySpaces= false;
					}
				}
				
			}
		else {
			for(int i=this.pos2-1;i>y; i--) {
				if(board.getField(x, i) != null) {
					emptySpaces= false;
					}
				}
			}
			
			if(emptySpaces ==true) {
				
				
				return true;
				}
			else {
				return false;
			}
			
		}
		else if(this.pos1 != x && this.pos2 == y) {
			
			if(x > this.pos1) {
				for(int i=this.pos1+1;i<x; i++) {
					if(board.getField(i, y) != null) {
						emptySpaces= false;
					}
				}
				
			}
			else {
			for(int i=this.pos1-1;i>x; i--) {
				if(board.getField(i, y) != null) {
					emptySpaces= false;
					}
				}
			}
			
			if(emptySpaces ==true) {
				
				
				return true;
				}
			
			else {
				return false;
			}
		}
		
		
		else return false;
	}
	
	
	
}

