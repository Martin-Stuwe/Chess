package figures;

import game.Board;
import game.Figures;

public class Knight extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 
	public Knight(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 3;
	}
	
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "N";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "n";
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
	
	public String getColor() {
		return color;
	}
	
	public boolean validMove(Board board,int x , int y) {
		
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		else if(this.pos1 == x-2 && this.pos2 == y-1 || this.pos1 == x-1 && this.pos2 == y-2) {
			
			return true;
		}
		
		else if(this.pos1 == x+1 && this.pos2 == y-2 || this.pos1 == x+2 && this.pos2 == y-1) {
			
			return true;
		}
		
		else if(this.pos1 == x-2 && this.pos2 == y+1 || this.pos1 == x-1 && this.pos2 == y+2) {
			
			return true;
		}
		
		else if(this.pos1 == x+2 && this.pos2 == y+1 || this.pos1 == x+1 && this.pos2 == y+2) {
			
			return true;
		}
		
		else return false;
	}
}

