package figures;

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
	
	public boolean validMove(int x , int y) {
		
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		//top left
		else if(this.pos1 == x-2 && this.pos2 == y-1 || this.pos1 == x-1 && this.pos2 == y-2) {
			this.setPos(x,y);
			return true;
		}
		//bottom left
		else if(this.pos1 == x+1 && this.pos2 == y-2 || this.pos1 == x+2 && this.pos2 == y-1) {
			this.setPos(x,y);
			return true;
		}
		//top right
		else if(this.pos1 == x-2 && this.pos2 == y+1 || this.pos1 == x-1 && this.pos2 == y+2) {
			this.setPos(x,y);
			return true;
		}
		//bottom right
		else if(this.pos1 == x+2 && this.pos2 == y+1 || this.pos1 == x+1 && this.pos2 == y+1) {
			this.setPos(x,y);
			return true;
		}
		
		else return false;
	}
}

