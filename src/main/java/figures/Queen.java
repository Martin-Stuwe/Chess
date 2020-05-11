package figures;

import game.Board;
import game.Figures;

/**
 * Class for the figure: queen
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Queen extends Figures {
	 
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the queen
	 */
	public int pos1;
	
	/**
	 * the y axis position of the queen 
	 */
	public int pos2;
	
	/**
	 * the color of the queen
	 */
	private String color;
	
	/**
	 * the constructor creates a new queen object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the queen
	 * @param pos2 y axis position of the queen
	 * @param color color of the queen, valid input: "w" for white, "b" for black
	 */
	public Queen(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 5;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the queen as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "Q";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "q";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of queen
	 * @param pos2 new y axis position of queen
	 */
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the queen as a String
	 */
	public String getColor(){
		return color;
	}
	
	/**
	 * Checks if the current move is valid
	 * @param board ,the board on which the move is tested on
	 * @param x for the x axis position to move to
	 * @param y for the y axis position to move to
	 * @return true for valid move 
	 * @return false for invalid move
	 */
	public boolean validMove(Board board,int x, int y) {
		boolean emptySpaces = true;
		
		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		// top left diagonal + check if there are other figures in the way
		else if(this.pos1 == x-7 && this.pos2 == y-7 || this.pos1 == x-6 && this.pos2 == y-6 || this.pos1 == x-5 && this.pos2 == y-5 || this.pos1 == x-4 && this.pos2 == y-4 || this.pos1 == x-3 && this.pos2 == y-3|| this.pos1 == x-2 && this.pos2 == y-2 || this.pos1 == x-1 && this.pos2 == y-1) {
			for(int i=this.pos1+1 , k=this.pos2+1;i<x && k<y  ; i++ ,k++) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		// bottom right diagonal + check if there are other figures in the way
		else if(this.pos1 == x+7 && this.pos2 == y+7 || this.pos1 == x+6 && this.pos2 == y+6 || this.pos1 == x+5 && this.pos2 == y+5 || this.pos1 == x+4 && this.pos2 == y+4 || this.pos1 == x+3 && this.pos2 == y+3|| this.pos1 == x+2 && this.pos2 == y+2 || this.pos1 == x+1 && this.pos2 == y+1) {
			for(int i=this.pos1-1 , k=this.pos2-1;i>x && k>y  ; i-- ,k--) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		// top right diagonal + check if there are other figures in the way
		else if(this.pos1 == x+7 && this.pos2 == y-7 || this.pos1 == x+6 && this.pos2 == y-6 || this.pos1 == x+5 && this.pos2 == y-5 || this.pos1 == x+4 && this.pos2 == y-4 || this.pos1 == x+3 && this.pos2 == y-3|| this.pos1 == x+2 && this.pos2 == y-2 || this.pos1 == x+1 && this.pos2 == y-1) {
			for(int i=this.pos1-1 , k=this.pos2+1;i>x && k<y  ; i-- ,k++) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		// bottom right diagonal + check if there are other figures in the way
		else if(this.pos1 == x-7 && this.pos2 == y+7 || this.pos1 == x-6 && this.pos2 == y+6 || this.pos1 == x-5 && this.pos2 == y+5 || this.pos1 == x-4 && this.pos2 == y+4 || this.pos1 == x-3 && this.pos2 == y+3|| this.pos1 == x-2 && this.pos2 == y+2 || this.pos1 == x-1 && this.pos2 == y+1) {
			for(int i=this.pos1+1 , k=this.pos2-1;i<x && k>y  ; i++ ,k--) {
				if(board.getField(i, k) != null) {
					emptySpaces= false;
				}
			}
			if(emptySpaces ==true) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		// horizontal line + check if there are other figures in the way
		else if(this.pos1 == x && this.pos2 != y) {
			if(y > this.pos2) {
				for(int i=this.pos2+1;i<y; i++) {
					if(board.getField(x, i) != null) {
						emptySpaces= false;
					}
				}
				
			}
			else {
				for(int i=this.pos2-1;i>y; i--) {
					if(board.getField(x, i) != null) {
						emptySpaces= false;
					}
				}
			}
			
			if(emptySpaces == true) {
				this.setHasMoved(true);
				return true;
				}
			
			else {
				return false;
			}
		}
		
		// vertical line + check if there are other figures in the way
		else if(this.pos1 != x && this.pos2 == y) {
			if(x > this.pos1) {
				for(int i=this.pos1+1;i<x; i++) {
					if(board.getField(i, y) != null) {
						emptySpaces= false;
					}
				}
				
			}
			else {
				for(int i=this.pos1-1;i>x; i--) {
					if(board.getField(i, y) != null) {
						emptySpaces= false;
					}
				}
			}
			
			if(emptySpaces ==true) {
				this.setHasMoved(true);
				return true;
				}
			
				else {
					return false;
				}
		}
		else return false;
	}
}

