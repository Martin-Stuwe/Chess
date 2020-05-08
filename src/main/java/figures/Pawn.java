package figures;

import game.Board;
import game.Figures;

public class Pawn extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 
	public Pawn(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 4;
	}
	
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "P";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "p";
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
	
	public boolean validMove(Board board,int x, int y) {

		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		else if(this.color =="w" && this.pos1 == x && this.pos2 == y+1) {
			this.setPos(x,y);
			return true;
		}
		else if(this.color =="b" && this.pos1 == x && this.pos2 == y-1) {
			this.setPos(x,y);
			return true;
		}
		else if(this.color =="w" && this.pos1 == x && this.pos2 == y+2 && this.pos2 == 6) {
			this.setPos(x,y);
			return true;
		}
		else if(this.color =="b" && this.pos1 == x && this.pos2 == y-2 && this.pos2 == 1) {
			this.setPos(x,y);
			return true;
		}
		else return false;
	}
}

