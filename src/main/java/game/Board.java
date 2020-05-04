package game;
import figures.*;

public class Board {
	
	String Feld; //store for the actual board
	
	Figures[][] Positionen= new Figures[8][8]; //Array to store each field later change to figure or field object
	
	Rook Rook1b = new Rook();
	Rook Rook2b = new Rook();
	Rook Rook1w = new Rook();
	Rook Rook2w = new Rook();
	Knight Knight1b = new Knight();
	Knight Knight2b = new Knight();
	Knight Knight1w = new Knight();
	Knight Knight2w = new Knight();
	Bishop Bishop1b = new Bishop();
	Bishop Bishop2b = new Bishop();
	Bishop Bishop1w = new Bishop();
	Bishop Bishop2w = new Bishop();
	Queen Queen1b = new Queen();
	Queen Queen1w = new Queen();
	King King1b	= new King();
	King King1w = new King();
		
	public void initializeBoard() { //Method to init the console based board. Also acts as updater
		
		this.Feld = "8"+ Positionen[0][0] + Positionen[0][1] + Positionen[0][2] + Positionen[0][3] +Positionen[0][4] + Positionen[0][5] + Positionen[0][6] + Positionen[0][7] + "\n"
				+ "7"+ Positionen[1][0] + Positionen[1][1] + Positionen[1][2] + Positionen[1][3] +Positionen[1][4] + Positionen[1][5] + Positionen[1][6] + Positionen[1][7]+"\n"
				+ "6"+ Positionen[2][0] + Positionen[2][1] + Positionen[2][2] + Positionen[2][3] +Positionen[2][4] + Positionen[2][5] + Positionen[2][6] + Positionen[2][7]+"\n"
				+ "5"+ Positionen[3][0] + Positionen[3][1] + Positionen[3][2] + Positionen[3][3] +Positionen[3][4] + Positionen[3][5] + Positionen[3][6] + Positionen[3][7]+"\n" 
				+ "4"+ Positionen[4][0] + Positionen[4][1] + Positionen[4][2] + Positionen[4][3] +Positionen[4][4] + Positionen[4][5] + Positionen[4][6] + Positionen[4][7] +"\n"
				+ "3"+ Positionen[5][0] + Positionen[5][1] + Positionen[5][2] + Positionen[5][3] +Positionen[5][4] + Positionen[5][5] + Positionen[5][6] + Positionen[5][7] +"\n"
				+ "2"+ Positionen[6][0] + Positionen[6][1] + Positionen[6][2] + Positionen[6][3] +Positionen[6][4] + Positionen[6][5] + Positionen[6][6] + Positionen[6][7] +"\n"
				+ "1"+ Positionen[7][0] + Positionen[7][1] + Positionen[7][2] + Positionen[7][3] +Positionen[7][4] + Positionen[7][5] + Positionen[7][6] + Positionen[7][7] +"\n"
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
			Pawn Pawnb = new Pawn();
			Pawn Pawnw = new Pawn();
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
