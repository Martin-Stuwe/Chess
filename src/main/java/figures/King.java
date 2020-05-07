package figures;

import game.Figures;

public class King extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 
	public King(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 2;
	}
	
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "K";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "k";
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
	// possible move restriction for king
	public boolean validMove(int x, int y) {
		
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		else if(this.pos1 == x && this.pos2 ==y) {
			return false;
		}
		else if(this.pos1 == x-1 || this.pos1 == x || this.pos1 != x+1) {
			this.setPos(x,y);
			return true;
		}
		else if(this.pos2 != y-1 || this.pos2 != y || this.pos2 != y+1) {
			this.setPos(x,y);
			return true;
		}
		else return false;
	}
	
}

