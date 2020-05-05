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
	// possible move restriction for king
	public boolean validMove(int x, int y) {
		
		if(this.pos1 != x-1 || this.pos1 != x || this.pos1 != x+1) {
			return false;
		}
		else if(this.pos2 != y-1 || this.pos2 != y || this.pos2 != y+1) {
			return false;
		}
		else if(this.pos1 == x && this.pos2 ==y) {
			return false;
		}
		else if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}

		else return true;
	}
	
}

