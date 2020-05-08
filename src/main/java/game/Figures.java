package game;

import java.time.temporal.ValueRange;

public class Figures {
	int pos1; 
	int pos2;
	protected int type;
	String boardVisual; //Zeichen/Grafik here
	String color;
	private boolean hasMoved;
	
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	public int getPos1() {
		return pos1; 
	}
	public int getPos2() {
		return pos2; 
	}
	public String getBoardVisual() {
		
			return boardVisual;
		}
	public int getType() {
		
		return type;
	}
	
	public String getColor() {
		return color;
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	public boolean validMove(Board board,int x, int y) {
		
		return false;
	}
	
	
	public Boolean move(Board board, int pos1from, int pos2from, int pos1to, int pos2to) { //Move takes int values convert before this
		
		if (board.Positionen[pos1from][pos2from] == null) {
			System.out.println("!Move not allowed");
			return false;
			
		}
		if(board.getCurrentTurn()==0) {
			if(board.Positionen[pos1from][pos2from].getColor() !="w") {
				System.out.println("!Move not allowed");
				return false;		
			}
				}
		if(board.getCurrentTurn()==1) {
			if(board.Positionen[pos1from][pos2from].getColor() !="b") {
				System.out.println("!Move not allowed");
				return false;		
			}
				}
		
		if (board.Positionen[pos1from][pos2from].validMove(board,pos1to, pos2to) == false) {
			System.out.println("!Move not allowed");
			return false;
		}
		if(board.Positionen[pos1to][pos2to]!= null) {
		if (board.Positionen[pos1from][pos2from].getColor() == board.Positionen[pos1to][pos2to].getColor()) {
			System.out.println("!Move not allowed");
			return false;
		}
		
		}
		if(board.getCurrentTurn()==0) {
			board.setCurrentTurn(1);
				}
		else if(board.getCurrentTurn()==1) {
			board.setCurrentTurn(0);
				}
	
	board.Positionen[pos1to][pos2to] = board.getField(pos1from,pos2from);
	board.Positionen[pos1from][pos2from] = null;
	board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
	return true;
	//board.initializeBoard(); 
	}
	
	
	
	
	
}
