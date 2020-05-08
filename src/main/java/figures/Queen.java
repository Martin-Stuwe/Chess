package figures;

import game.Board;
import game.Figures;

public class Queen extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 
	public Queen(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 5;
	}
	
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "Q";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "q";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	public String getColor(){
		return color;
	}
	
	// possible move restriction queen
	public boolean validMove(Board board,int x, int y) {
		boolean emptySpaces = true;
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		 
		else if(this.pos1 == x-7 && this.pos2 == y-7 || this.pos1 == x-6 && this.pos2 == y-6 || this.pos1 == x-5 && this.pos2 == y-5 || this.pos1 == x-4 && this.pos2 == y-4 || this.pos1 == x-3 && this.pos2 == y-3|| this.pos1 == x-2 && this.pos2 == y-2 || this.pos1 == x-1 && this.pos2 == y-1) {
			for(int i=this.pos1+1 , k=this.pos2+1;i<x && k<y  ; i++ ,k++) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
			this.setPos(x,y);
			return true;
			}
			else {
				return false;
			}
		}
		 
		else if(this.pos1 == x+7 && this.pos2 == y+7 || this.pos1 == x+6 && this.pos2 == y+6 || this.pos1 == x+5 && this.pos2 == y+5 || this.pos1 == x+4 && this.pos2 == y+4 || this.pos1 == x+3 && this.pos2 == y+3|| this.pos1 == x+2 && this.pos2 == y+2 || this.pos1 == x+1 && this.pos2 == y+1) {
			for(int i=this.pos1-1 , k=this.pos2-1;i>x && k>y  ; i-- ,k--) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
			this.setPos(x,y);
			return true;
			}
			else {
				return false;
			}
		}
		
		else if(this.pos1 == x+7 && this.pos2 == y-7 || this.pos1 == x+6 && this.pos2 == y-6 || this.pos1 == x+5 && this.pos2 == y-5 || this.pos1 == x+4 && this.pos2 == y-4 || this.pos1 == x+3 && this.pos2 == y-3|| this.pos1 == x+2 && this.pos2 == y-2 || this.pos1 == x+1 && this.pos2 == y-1) {
			for(int i=this.pos1-1 , k=this.pos2+1;i>x && k<y  ; i-- ,k++) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
			this.setPos(x,y);
			return true;
			}
			else {
				return false;
			}
		}
		
		else if(this.pos1 == x-7 && this.pos2 == y+7 || this.pos1 == x-6 && this.pos2 == y+6 || this.pos1 == x-5 && this.pos2 == y+5 || this.pos1 == x-4 && this.pos2 == y+4 || this.pos1 == x-3 && this.pos2 == y+3|| this.pos1 == x-2 && this.pos2 == y+2 || this.pos1 == x-1 && this.pos2 == y+1) {
			for(int i=this.pos1+1 , k=this.pos2-1;i<x && k>y  ; i++ ,k--) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
			this.setPos(x,y);
			return true;
			}
			else {
				return false;
			}
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
				this.setPos(x,y);
				this.setHasMoved(true);
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
				this.setPos(x,y);
				this.setHasMoved(true);
				return true;
				}
				else {
					return false;
				}
		}
		else return false;
	}
}

