/**
* Class for the Chess Figures
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* Gruppe 23
*/


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
		Figures RestoreFrom=board.Positionen[pos1from][pos2from];
		Figures RestoreTo=board.Positionen[pos1to][pos2to];
		
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
			if(board.Positionen[pos1to][pos2to]!= null) {
			if(board.Positionen[pos1to][pos2to].getColor() == "b") {
				board.beaten.add(board.Positionen[pos1to][pos2to].getBoardVisual());
			}
			}
			
			board.setCurrentTurn(1);
				}
		else if(board.getCurrentTurn()==1) {
			if(board.Positionen[pos1to][pos2to]!= null) {
			if(board.Positionen[pos1to][pos2to].getColor() == "w") {
				board.beaten.add(board.Positionen[pos1to][pos2to].getBoardVisual());
			}}
			board.setCurrentTurn(0);
				}
	
	board.Positionen[pos1to][pos2to] = board.getField(pos1from,pos2from);
	board.Positionen[pos1from][pos2from] = null;
	board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
	
				
		 if(board.checkCheck()== true) {
			 if(board.blackCheck ==true) {
				 if(board.getCurrentTurn()==0) {
			 board.Positionen[pos1to][pos2to] = RestoreTo;
			 board.Positionen[pos1from][pos2from] = RestoreFrom;
			 if(board.Positionen[pos1to][pos2to]!= null) {
				 board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
			 }
			 if(board.Positionen[pos1from][pos2from]!= null) {
				 board.Positionen[pos1from][pos2from].setPos(pos1from, pos2from);
			 }
			 board.setCurrentTurn(1);
			}
			
			 System.out.println("!Move not allowed");
			return false;
		 }
	 
		 else if(board.whiteCheck ==true) {
			 if(board.getCurrentTurn()==1) {
					
			 
				 board.Positionen[pos1to][pos2to] = RestoreTo;
				 board.Positionen[pos1from][pos2from] = RestoreFrom;
				 if(board.Positionen[pos1to][pos2to]!= null) {
					 board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
				 }
				 if(board.Positionen[pos1from][pos2from]!= null) {
					 board.Positionen[pos1from][pos2from].setPos(pos1from, pos2from);
				 }
				 board.setCurrentTurn(0);
				}
				
				 System.out.println("!Move not allowed");
				return false;
			 }	 
	 }
		 
		 board.Positionen[pos1to][pos2to].setHasMoved(true);
	return true;
	//board.initializeBoard(); 
	}
	
	
	public Boolean hasPossibleMove(Board board, int pos1from, int pos2from, int pos1to, int pos2to) { //Move takes int values convert before this
		Figures RestoreFrom=board.Positionen[pos1from][pos2from];
		Figures RestoreTo=board.Positionen[pos1to][pos2to];
		
		if (board.Positionen[pos1from][pos2from] == null) {
			
			return false;
			
		}
		if(board.getCurrentTurn()==0) {
			if(board.Positionen[pos1from][pos2from].getColor() !="w") {
			
				return false;		
			}
				}
		if(board.getCurrentTurn()==1) {
			if(board.Positionen[pos1from][pos2from].getColor() !="b") {
			
				return false;		
			}
				}
		
		if (board.Positionen[pos1from][pos2from].validMove(board,pos1to, pos2to) == false) {
		
			return false;
		}
		if(board.Positionen[pos1to][pos2to]!= null) {
		if (board.Positionen[pos1from][pos2from].getColor() == board.Positionen[pos1to][pos2to].getColor()) {
		
			return false;
		}
		
		}
		
	
	board.Positionen[pos1to][pos2to] = board.getField(pos1from,pos2from);
	board.Positionen[pos1from][pos2from] = null;
	board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
	
			if(board.checkCheck()==true) {
				board.Positionen[pos1to][pos2to] = RestoreTo;
				 board.Positionen[pos1from][pos2from] = RestoreFrom;
				 if(board.Positionen[pos1to][pos2to]!= null) {
					 board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
				 }
				 if(board.Positionen[pos1from][pos2from]!= null) {
					 board.Positionen[pos1from][pos2from].setPos(pos1from, pos2from);
				 }
				return false;
			}
			
		
	
	 
		 board.Positionen[pos1to][pos2to] = RestoreTo;
		 board.Positionen[pos1from][pos2from] = RestoreFrom;
		 if(board.Positionen[pos1to][pos2to]!= null) {
			 board.Positionen[pos1to][pos2to].setPos(pos1to, pos2to);
		 }
		 if(board.Positionen[pos1from][pos2from]!= null) {
			 board.Positionen[pos1from][pos2from].setPos(pos1from, pos2from);
		 }
	 
	
	return true;
	//board.initializeBoard(); 
}
	
}
	