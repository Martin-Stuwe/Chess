package game;

public class Figures {
	int Pos1; 
	int Pos2;
	String boardVisual; //Zeichen/Grafik hier
	String color;
	
	
	public void setPos(int Pos1, int Pos2) { 
		this.Pos1 = Pos1;
		this.Pos2 = Pos2;
	}
	public int getPos1() {
		return Pos1; 
	}
	public int getPos2() {
		return Pos2; 
	}
	public String getBoardVisual() {
		
			return boardVisual;
		}
	
	
	public void move(Board board, char pos1from, int pos2from, char pos1to, int pos2to) { //Reactions in jeder Figurenunterklasse
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
	
	board.Positionen[pos1to][pos2to] = board.Positionen[pos1from][pos2from];
	board.Positionen[pos1from][pos2from] = null;
	
	board.initializeBoard(); 
	}
	
}
