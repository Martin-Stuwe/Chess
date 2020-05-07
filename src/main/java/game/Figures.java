package game;

import java.time.temporal.ValueRange;

public class Figures {
	int Pos1; 
	int Pos2;
	protected int type;
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
	public int getType() {
		
		return type;
	}
	
	public boolean validMove(int x, int y) {
		
		return false;
	}
	
	
	public Boolean move(Board board, int pos1from, int pos2from, int pos1to, int pos2to) { //Move takes int values convert before this
		
	
	switch (board.Positionen[pos1from][pos2from].getType()) {
	 case 1:
		if (board.Positionen[pos1from][pos2from].validMove(pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		break;
	case 2:
		if (board.Positionen[pos1from][pos2from].validMove(pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		break;
	case 3:
		if (board.Positionen[pos1from][pos2from].validMove(pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		break;
	case 4:
		if (board.Positionen[pos1from][pos2from].validMove(pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		break;
	case 5:
		if (board.Positionen[pos1from][pos2from].validMove(pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		break;
	case 6:
		if (board.Positionen[pos1from][pos2from].validMove(pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		break;
		default:
			System.out.println("!Move not allowed");
			return false;
	}
	
	board.Positionen[pos1to][pos2to] = board.getField(pos1from,pos2from);
	board.Positionen[pos1from][pos2from] = null;
	board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
	return true;
	//board.initializeBoard(); 
	}
	
	
	
	
	
}
