package figures;

import game.Figures;

public class Bishop extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 
	public Bishop(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
	}
	
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "B";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "b";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	public boolean validMove(int x, int y) {
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		else if(this.pos1 == x-7 && this.pos2 == y-7 || this.pos1 == x-6 && this.pos2 == y-6 || this.pos1 == x-5 && this.pos2 == y-5 || this.pos1 == x-4 && this.pos2 == y-4 || this.pos1 == x-3 && this.pos2 == y-3|| this.pos1 == x-2 && this.pos2 == y-2 || this.pos1 == x-1 && this.pos2 == y-1) {
			return true;
		}
		
		else if(this.pos1 == x+7 && this.pos2 == y+7 || this.pos1 == x+6 && this.pos2 == y+6 || this.pos1 == x+5 && this.pos2 == y+5 || this.pos1 == x+4 && this.pos2 == y+4 || this.pos1 == x+3 && this.pos2 == y+3|| this.pos1 == x+2 && this.pos2 == y+2 || this.pos1 == x+1 && this.pos2 == y+1) {
			return true;
		}
		
		else if(this.pos1 == x+7 && this.pos2 == y-7 || this.pos1 == x+6 && this.pos2 == y-6 || this.pos1 == x+5 && this.pos2 == y-5 || this.pos1 == x+4 && this.pos2 == y-4 || this.pos1 == x+3 && this.pos2 == y-3|| this.pos1 == x+2 && this.pos2 == y-2 || this.pos1 == x+1 && this.pos2 == y-1) {
			return true;
		}
		
		else if(this.pos1 == x-7 && this.pos2 == y+7 || this.pos1 == x-6 && this.pos2 == y+6 || this.pos1 == x-5 && this.pos2 == y+5 || this.pos1 == x-4 && this.pos2 == y+4 || this.pos1 == x-3 && this.pos2 == y+3|| this.pos1 == x-2 && this.pos2 == y+2 || this.pos1 == x-1 && this.pos2 == y+1) {
			return true;
		}
		
		else return false;
	}
	
}

