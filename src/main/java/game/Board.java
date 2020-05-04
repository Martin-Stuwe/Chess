package game;
import figures.*;

public class Board {
	
	String Feld; //store for the actual board
	
	Figures[][] Positionen= new Figures[8][8]; //Array to store each field later change to figure or field object
	
	Rook Rook1b = new Rook(0,0,"b");
	Rook Rook2b = new Rook(0,7,"b");
	Rook Rook1w = new Rook(7,0,"w");
	Rook Rook2w = new Rook(7,7,"w");
	Knight Knight1b = new Knight(0,1,"b");
	Knight Knight2b = new Knight(0,6,"b");
	Knight Knight1w = new Knight(7,1,"w");
	Knight Knight2w = new Knight(7,6,"w");
	Bishop Bishop1b = new Bishop(0,2,"b");
	Bishop Bishop2b = new Bishop(0,5,"b");
	Bishop Bishop1w = new Bishop(7,2,"w");
	Bishop Bishop2w = new Bishop(7,5,"w");
	Queen Queen1b = new Queen(0,3,"b");
	Queen Queen1w = new Queen(7,3,"w");
	King King1b	= new King(0,4,"b");
	King King1w = new King(7,4,"w");
		
	public void initializeBoard() { //Method to init the console based board. Also acts as updater
		
		this.Feld = "8"+ Positionen[0][0].getBoardVisual() + Positionen[0][1].getBoardVisual() + Positionen[0][2].getBoardVisual() + Positionen[0][3].getBoardVisual() +Positionen[0][4].getBoardVisual() + Positionen[0][5].getBoardVisual() + Positionen[0][6].getBoardVisual() + Positionen[0][7].getBoardVisual() + "\n"
				+ "7"+ Positionen[1][0].getBoardVisual() + Positionen[1][1].getBoardVisual() + Positionen[1][2].getBoardVisual() + Positionen[1][3].getBoardVisual() +Positionen[1][4].getBoardVisual() + Positionen[1][5].getBoardVisual() + Positionen[1][6].getBoardVisual() + Positionen[1][7].getBoardVisual()+"\n"
				+ "6"+ Positionen[2][0] + Positionen[2][1] + Positionen[2][2] + Positionen[2][3] +Positionen[2][4] + Positionen[2][5] + Positionen[2][6] + Positionen[2][7]+"\n"
				+ "5"+ Positionen[3][0] + Positionen[3][1] + Positionen[3][2] + Positionen[3][3] +Positionen[3][4] + Positionen[3][5] + Positionen[3][6] + Positionen[3][7]+"\n" 
				+ "4"+ Positionen[4][0] + Positionen[4][1] + Positionen[4][2] + Positionen[4][3] +Positionen[4][4] + Positionen[4][5] + Positionen[4][6] + Positionen[4][7] +"\n"
				+ "3"+ Positionen[5][0] + Positionen[5][1] + Positionen[5][2] + Positionen[5][3] +Positionen[5][4] + Positionen[5][5] + Positionen[5][6] + Positionen[5][7] +"\n"
				+ "2"+ Positionen[6][0].getBoardVisual() + Positionen[6][1].getBoardVisual() + Positionen[6][2].getBoardVisual() + Positionen[6][3].getBoardVisual() +Positionen[6][4].getBoardVisual() + Positionen[6][5].getBoardVisual() + Positionen[6][6].getBoardVisual() + Positionen[6][7].getBoardVisual() +"\n"
				+ "1"+ Positionen[7][0].getBoardVisual() + Positionen[7][1].getBoardVisual() + Positionen[7][2].getBoardVisual() + Positionen[7][3].getBoardVisual() +Positionen[7][4].getBoardVisual() + Positionen[7][5].getBoardVisual() + Positionen[7][6].getBoardVisual() + Positionen[7][7].getBoardVisual() +"\n"
				+ " "+"abcdefgh";
	} 
	
	
	public void setStart() {
		setField(0,0, Rook1b);
		setField(0,1, Knight1b);
		setField(0,2, Bishop1b);
		setField(0,3, Queen1b);
		setField(0,4, King1b);
		setField(0,5, Bishop2b);
		setField(0,6, Knight2b);
		setField(0,7, Rook2b);
		setField(7,0, Rook1w);
		setField(7,1, Knight1w);
		setField(7,2, Bishop1w);
		setField(7,3, Queen1w);
		setField(7,4, King1w);
		setField(7,5, Bishop2w);
		setField(7,6, Knight2w);
		setField(7,7, Rook2w);
		for (int i = 0;i<8; i++) {
			Pawn Pawnb = new Pawn(1,i,"b");
			Pawn Pawnw = new Pawn(6,i,"w");
			setField(1,i, Pawnb);
			setField(6,i, Pawnw);
		}
	}
	
	
	public Figures getField(int pos1, int pos2) {
		return this.Positionen[pos1][pos2];
	}
	
	
	public void setField(int pos1, int pos2, Figures setTo) {
		this.Positionen[pos1][pos2] = setTo;
	}
	
	
	public void move(int pos1from, int pos2from, int pos1to, int pos2to) {
	Positionen[pos1to][pos2to] = Positionen[pos1from][pos2from];
	Positionen[pos1from][pos2from] = null;
	}
	
	

}
