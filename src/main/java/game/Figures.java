package game;

import java.time.temporal.ValueRange;

public class Figures {
	int Pos1; 
	int Pos2;
	String boardVisual; //Zeichen/Grafik here
	String color;
	int canMoveTop=0;
	int canMoveTopLeft=0;
	int canMoveTopRight=0;
	int canMoveLeft=0;
	int canMoveRight=0;
	int canMoveBottomLeft=0;
	int canMoveBottomRight=0;
	int canMoveBottom=0;
	
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
	
	public boolean validMove(int x, int y) {
		
		return false;
	}
	
	
	public void move(Board board, char pos1from, int pos2from, char pos1to, int pos2to) { //Reactions in jeder Figurenunterklasse
	
	String ConvertedFrom=board.ConvertMoveInput(board, pos1from, pos2from);	
	String ConvertedTo = board.ConvertMoveInput(board, pos1to, pos2to);
	
	pos1from = ConvertedFrom.charAt(0);
	pos2from = ConvertedFrom.charAt(1);
	
	pos1to = ConvertedTo.charAt(0);   
	pos2to = ConvertedTo.charAt(1);
	
	
	board.Positionen[pos1to][pos2to] = board.Positionen[pos1from][pos2from];
	board.Positionen[pos1from][pos2from] = null;
	
	board.initializeBoard(); 
	}
	
	
	
	
	
}
