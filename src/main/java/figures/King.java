/**
* Class for the figure: king
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* Gruppe 23
*/

package figures;

import game.Board;
import game.Figures;

public class King extends Figures {
	 private String boardVisual;
	 private int pos1;
	 private int pos2;
	 private String color;
	 private boolean hasMoved;
	 
	public King(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 2;
		this.hasMoved = false;
	}
	
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "K";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "k";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
		
	
	}
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	public String getColor() {
		return color;
	}
	
	/**
	* Checks if the current move is valid
	* @param x for the x axis position and y for the y axis position to move to
	* @return true for valid move false for invalid move
	*/
public boolean validMove(Board board, int x, int y) {

		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		else if(this.pos1 == x && this.pos2 ==y) {
			return false;
		}
		// short castling 
		else if(this.pos1 == x-2 && this.pos2 == y &&board.getField(7, y)!= null 
				&& board.getField(6, y) == null && board.getField(5, y)== null) {
			if(this.hasMoved == false && board.getField(7, y).getHasMoved() == false
					&& board.checkField(4, y, this.color)==false && board.checkField(5, y, this.color)==false && board.checkField(6, y, this.color)==false) {
			board.setField(5, y, board.getField(7, y));
			board.setNull(7, y);
			return true;
			}
			else return false;
		}
		
		// long castling 
		else if(this.pos1 == x+2 && this.pos2 == y && board.getField(0, y)!= null 
				&& board.getField(3, y) == null && board.getField(2, y)== null) {
			if(this.hasMoved == false && board.getField(0, y).getHasMoved() == false 
					&& board.checkField(4, y, this.color) == false && board.checkField(3, y, this.color) == false && board.checkField(2, y, this.color) == false) {
			board.setField(3, y, board.getField(0, y));
			board.setNull(0, y);
			return true;
			}
			else return false;
		}
		else if(this.pos1 == x-1 || this.pos1 == x+1 ||this.pos1 == x) {
			if(this.pos2 == y-1 || this.pos2 == y+1 || this.pos2 == y) {
			
			return true;
			}
			else return false;
		}
		else if(this.pos2 == y-1 || this.pos2 == y+1 || this.pos2 == y) {
			if(this.pos1 == x-1 || this.pos1 == x+1 || this.pos1 == x) {
		
			return true;
			}
			else return false;
		}
		
		else return false;
	}
	
}
