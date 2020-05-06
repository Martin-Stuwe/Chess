package game;
import java.time.temporal.ValueRange;

import figures.*;

public class Board {
	
	String Feld; //store for the actual board
	
	Figures[][] Positionen= new Figures[8][8]; //Array to store each field later change to figure or field object
	String[][] PositionenS = new String[8][8];
	
	//Field object for highlighting prob needed
	
	Rook Rook1b = new Rook(0,0,"b");
	Rook Rook2b = new Rook(7,0,"b");
	Rook Rook1w = new Rook(0,7,"w");
	Rook Rook2w = new Rook(7,7,"w");
	Knight Knight1b = new Knight(1,0,"b");
	Knight Knight2b = new Knight(6,0,"b");
	Knight Knight1w = new Knight(1,7,"w");
	Knight Knight2w = new Knight(6,7,"w");
	Bishop Bishop1b = new Bishop(2,0,"b");
	Bishop Bishop2b = new Bishop(0,5,"b");
	Bishop Bishop1w = new Bishop(2,7,"w");
	Bishop Bishop2w = new Bishop(5,7,"w");
	Queen Queen1b = new Queen(3,0,"b");
	Queen Queen1w = new Queen(3,7,"w");
	King King1b	= new King(4,0,"b");
	King King1w = new King(4,7,"w");
		
	public void initializeBoard() { //Method to init the console based board. Also acts as updater
		
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(Positionen[i][y] == null) {
					PositionenS[i][y] = " ";
				}
				
				else {
					PositionenS[i][y] = Positionen[i][y].getBoardVisual();
				}
			}
			
		} //test
		
		this.Feld = "8"+" "+  PositionenS[0][0] +" "+  PositionenS[1][0] +" "+  PositionenS[2][0] +" "+  PositionenS[3][0] +" "+ PositionenS[4][0] +" "+  PositionenS[5][0] +" "+  PositionenS[6][0] +" "+  PositionenS[7][0] + "\n" 
				  + "7"+" "+  PositionenS[0][1] +" "+  PositionenS[1][1] +" "+  PositionenS[2][1] +" "+  PositionenS[3][1] +" "+ PositionenS[4][1] +" "+  PositionenS[5][1] +" "+  PositionenS[6][1] +" "+  PositionenS[7][1] +"\n" 
				  + "6"+" "+  PositionenS[0][2] +" "+  PositionenS[1][2] +" "+  PositionenS[2][2] +" "+  PositionenS[3][2] +" "+ PositionenS[4][2] +" "+  PositionenS[5][2] +" "+  PositionenS[6][2] +" "+  PositionenS[7][2]+"\n" 
				  + "5"+" "+  PositionenS[0][3] +" "+  PositionenS[1][3] +" "+  PositionenS[2][3] +" "+  PositionenS[3][3] +" "+ PositionenS[4][3] +" "+  PositionenS[5][3] +" "+  PositionenS[6][3] +" "+  PositionenS[7][3] +"\n"
				  + "4"+" "+  PositionenS[0][4] +" "+  PositionenS[1][4] +" "+  PositionenS[2][4] +" "+  PositionenS[3][4] +" "+ PositionenS[4][4] +" "+  PositionenS[5][4] +" "+  PositionenS[6][4] +" "+  PositionenS[7][4] +"\n" 
				  + "3"+" "+  PositionenS[0][5] +" "+  PositionenS[1][5] +" "+  PositionenS[2][5] +" "+  PositionenS[3][5] +" "+ PositionenS[4][5] +" "+  PositionenS[5][5] +" "+  PositionenS[6][5] +" "+  PositionenS[7][5] +"\n"
				  + "2"+" "+  PositionenS[0][6] +" "+  PositionenS[1][6] +" "+  PositionenS[2][6] +" "+  PositionenS[3][6] +" "+ PositionenS[4][6] +" "+  PositionenS[5][6] +" "+  PositionenS[6][6] +" "+  PositionenS[7][6] +"\n" 
				  + "1"+" "+  PositionenS[0][7] +" "+  PositionenS[1][7] +" "+  PositionenS[2][7] +" "+  PositionenS[3][7] +" "+ PositionenS[4][7] +" "+  PositionenS[5][7] +" "+  PositionenS[6][7] +" "+  PositionenS[7][7] +"\n"
				  + " "+" a"+" b"+" c"+ " d"+" e"+" f"+" g"+" h";
	} 
	
	public void setStart() {
		setField(0,0, Rook1b);
		setField(1,0, Knight1b);
		setField(2,0, Bishop1b);
		setField(3,0, Queen1b);
		setField(4,0, King1b);
		setField(5,0, Bishop2b);
		setField(6,0, Knight2b);
		setField(7,0, Rook2b);
		setField(0,7, Rook1w);
		setField(1,7, Knight1w);
		setField(2,7, Bishop1w);
		setField(3,7, Queen1w);
		setField(4,7, King1w);
		setField(5,7, Bishop2w);
		setField(6,7, Knight2w);
		setField(7,7, Rook2w);
		for (int i = 0;i<8; i++) {
			Pawn Pawnb = new Pawn(i,1,"b");
			Pawn Pawnw = new Pawn(i,6,"w");
			setField(i,1, Pawnb);
			setField(i,6, Pawnw);
		}
	}
	
	
	public Figures getField(int pos1, int pos2) {
		return this.Positionen[pos1][pos2];
	}
	
	
	public void setField(int pos1, int pos2, Figures setTo) {
		this.Positionen[pos1][pos2] = setTo;
	}
	public String ConvertMoveInput(Board board, char pos1from, int pos2from) { //UserInput umwandeln für gewählte Figur.
		int pos1new;
		switch (pos1from) {
		case 'a':
			pos1new =0;
			break;
		case 'b':
			pos1new =1;
			break;
		case 'c':
			pos1new =2;
			break;
		case 'd':
			pos1new =3;
			break;
		case 'e':
			pos1new =4;
			break;
		case 'f':
			pos1new =5;
			break;
		case 'g':
			pos1new =6;
			break;
		case 'h':
			pos1new =7;
			break;
		default:
			throw new IllegalArgumentException("Invalid input");
		}
	int pos2new = -1*(pos2from-8);
	if (pos2new < 0 || pos2new >7) {
		throw new IllegalArgumentException("Invalid integer range cccc");
	}
	return pos1new+Integer.toString(pos2new);

	}
}
