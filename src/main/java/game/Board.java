package game;
import figures.*;

public class Board {
	
	String Feld; //store for the actual board
	
	Figures[][] Positionen= new Figures[8][8]; //Array to store each field later change to figure or field object
	String[][] PositionenS = new String[8][8];
	
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
		
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(Positionen[i][y] == null) {
					PositionenS[i][y] = "";
				}
				
				else {
					PositionenS[i][y] = Positionen[i][y].getBoardVisual();
				}
			}
			
		}
		
		this.Feld = "8"+ PositionenS[0][0] + PositionenS[0][1] + PositionenS[0][2] + PositionenS[0][3] +PositionenS[0][4] + PositionenS[0][5] + PositionenS[0][6] + PositionenS[0][7] + "\n"
				+ "7"+ PositionenS[1][0] + PositionenS[1][1] + PositionenS[1][2] + PositionenS[1][3] +PositionenS[1][4] + PositionenS[1][5] + PositionenS[1][6] + PositionenS[1][7] +"\n"
				+ "6"+ PositionenS[2][0] + PositionenS[2][1] + PositionenS[2][2] + PositionenS[2][3] +PositionenS[2][4] + PositionenS[2][5] + PositionenS[2][6] + PositionenS[2][7]+"\n"
				+ "5"+ PositionenS[3][0] + PositionenS[3][1] + PositionenS[3][2] + PositionenS[3][3] +PositionenS[3][4] + PositionenS[3][5] + PositionenS[3][6] + PositionenS[3][7]+"\n" 
				+ "4"+ PositionenS[4][0] + PositionenS[4][1] + PositionenS[4][2] + PositionenS[4][3] +PositionenS[4][4] + PositionenS[4][5] + PositionenS[4][6] + PositionenS[4][7] +"\n"
				+ "3"+ PositionenS[5][0] + PositionenS[5][1] + PositionenS[5][2] + PositionenS[5][3] +PositionenS[5][4] + PositionenS[5][5] + PositionenS[5][6] + PositionenS[5][7] +"\n"
				+ "2"+ PositionenS[6][0] + PositionenS[6][1] + PositionenS[6][2] + PositionenS[6][3] +PositionenS[6][4] + PositionenS[6][5] + PositionenS[6][6] + PositionenS[6][7] +"\n"
				+ "1"+ PositionenS[7][0] + PositionenS[7][1] + PositionenS[7][2] + PositionenS[7][3] +PositionenS[7][4] + PositionenS[7][5] + PositionenS[7][6] + PositionenS[7][7] +"\n"
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
	
	
	public void move(char pos1from, int pos2from, char pos1to, int pos2to) {
		switch (pos1from) {
		case 'a':
			pos1from =0;
			break;
		case 'b':
			pos1from =1;
			break;
		case 'c':
			pos1from =2;
			break;
		case 'd':
			pos1from =3;
			break;
		case 'e':
			pos1from =4;
			break;
		case 'f':
			pos1from =5;
			break;
		case 'g':
			pos1from =7;
			break;
		case 'h':
			pos1from =7;
			break;
		default:
			throw new IllegalArgumentException("Invalid input");
		}
	pos2from = -1*(pos2from-8);
	
	Positionen[pos1to][pos2to] = Positionen[pos1from][pos2from];
	Positionen[pos1from][pos2from] = null;
	
	initializeBoard();
	}
	
	

}
