package figures;

import game.Board;
import game.Figures;

/**
* Class for the figure: knight
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
*/
public class Knight extends Figures {
	
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the knight 
	 */
	private int pos1;
	
	/**
	 * the y axis position of the knight 
	 */
	private int pos2;
	
	/**
	 * the color of the knight
	 */
	private String color;
	
	/**
	 * the constructor creates a new knight object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the knight
	 * @param pos2 y axis position of the knight
	 * @param color color of the knight, valid input: "w" for white, "b" for black
	 */
	public Knight(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 3;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the knight as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "N";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "n";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of knight
	 * @param pos2 new y axis position of knight
	 */
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the knight as a String
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
	public boolean validMove(Board board,int x , int y) {
		
		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		// top left
		else if(this.pos1 == x-2 && this.pos2 == y-1 || this.pos1 == x-1 && this.pos2 == y-2) {
			
			return true;
		}
		
		// top right
		else if(this.pos1 == x+1 && this.pos2 == y-2 || this.pos1 == x+2 && this.pos2 == y-1) {
			
			return true;
		}
		
		// bottom left
		else if(this.pos1 == x-2 && this.pos2 == y+1 || this.pos1 == x-1 && this.pos2 == y+2) {
			
			return true;
		}
		
		// bottom right
		else if(this.pos1 == x+2 && this.pos2 == y+1 || this.pos1 == x+1 && this.pos2 == y+2) {
			
			return true;
		}
		
		else return false;
	}
}

