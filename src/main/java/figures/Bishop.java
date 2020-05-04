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
	
}

