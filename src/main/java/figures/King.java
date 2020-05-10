package figures;

import game.Board;
import game.Figures;

/**
 * Class for the figure: king
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 */
public class King extends Figures {
	
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the king 
	 */
	private int pos1;
	
	/**
	 * the y axis position of the king
	 */
	private int pos2;
	
	/**
	 * the color of the king
	 */	
	private String color;
	
	/**
	 * check if the king has moved already
	 */
	private boolean hasMoved;
	
	/**
	 * the constructor creates a new king object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the king
	 * @param pos2 y axis position of the king
	 * @param color color of the king, valid input: "w" for white, "b" for black
	 */
	public King(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 2;
		this.hasMoved = false;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the king as a String
	 */
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
	
	/**
	 * get-method of hasMoved
	 * @return true if has moved
	 * @return false if king hasn't moved yet
	 */
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	/**
	 * set-method of hasMoved
	 * @param hasMoved used after move
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of king
	 * @param pos2 new y axis position of king
	 */
	public void setPos(int pos1, int pos2) { 
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the king as a String
	 */
	public String getColor() {
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
	public boolean validMove(Board board, int x, int y) {
		
		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		// check if starting position equals ending position
		else if(this.pos1 == x && this.pos2 ==y) {
			return false;
		}
		
		// short castling (check hasMoved + emptySpaces + check if check)
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
		
		// long castling (check hasMoved + emptySpaces + check if check)
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
		
		// possible king standard moves (first checking x axis)
		else if(this.pos1 == x-1 || this.pos1 == x+1 ||this.pos1 == x) {
				if(this.pos2 == y-1 || this.pos2 == y+1 || this.pos2 == y) {	
					return true;
			}
				
			else return false;
		}
		
		// possible king standard moves (first checking y axis)
		else if(this.pos2 == y-1 || this.pos2 == y+1 || this.pos2 == y) {
				if(this.pos1 == x-1 || this.pos1 == x+1 || this.pos1 == x) {
					return true;
				}
			
				else return false;
			}
		
		else return false;
	}
	
}
