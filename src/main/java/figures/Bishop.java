package figures;

import game.Figures;
import game.Board;

/**
 * Class for the figure: bishop
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */

public class Bishop extends Figures {
	 
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the bishop 
	 */
	 public int pos1;
	
	/**
	 * the y axis position of the bishop 
	 */
	 public int pos2;
	
	/**
	 * the color of the bishop
	 */
	private String color;
	/**
	 * the color of the bishop
	 */
	private boolean emptySpaces;
	
	
	/**
	 * the constructor creates a new bishop object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the bishop
	 * @param pos2 y axis position of the bishop
	 * @param color color of the bishop, valid input: "w" for white, "b" for black
	 */
	public Bishop(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		type = 1;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the bishop as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			boardVisual = "B";
			return boardVisual;
		}
		else if(this.color =="b") {
			boardVisual = "b";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of bishop
	 * @param pos2 new y axis position of bishop
	 */
	public void setPos(int pos1, int pos2) { 
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the bishop as a String
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
		
		emptySpaces = true;
		
		//check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}

		// top left diagonal + check if there are other figures in the way
		if( checkSame(x,y,-7,-7) || checkSame(x,y,-6,-6) || 
				checkSame(x,y,-5,-5)  || checkSame(x,y,-4,-4) || 
				checkSame(x,y,-3,-3)|| checkSame(x,y,-2,-2) || 
				checkSame(x,y,-1,-1)) {
			for(int i=this.pos1+1 , k=this.pos2+1;i<x && k<y  ; i++ ,k++) {
				notNull(board,i,k);
			}
			
			return emptySpaces;
		}
		return validMove2(board,x,y);
		}
		public boolean validMove2(Board board, int x, int y) {
		
		// bottom right diagonal + check if there are other figures in the way
		if( checkSame(x,y,7,7) || checkSame(x,y,6,6) || 
			checkSame(x,y,5,5)  || checkSame(x,y,4,4) || 
			checkSame(x,y,3,3)|| checkSame(x,y,2,2) || 
			checkSame(x,y,1,1)) {
			for(int i=this.pos1-1 , k=this.pos2-1;i>x && k>y  ; i-- ,k--) {
				notNull(board,i,k);
			}
			
			return emptySpaces;
		}
		return validMove3(board,x,y);
		}
		public boolean validMove3(Board board, int x, int y) {
		
		// top right diagonal + check if there are other figures in the way
		if(this.pos1 == x+7 && this.pos2 == y-7 || this.pos1 == x+6 && this.pos2 == y-6 || 
				checkSame(x,y,5,-5) || checkSame(x,y,4,-4) || 
				checkSame(x,y,3,-3)|| checkSame(x,y,2,-2) || 
				checkSame(x,y,1,-1)) {
			for(int i=this.pos1-1 , k=this.pos2+1;i>x && k<y  ; i-- ,k++) {
				notNull(board,i,k);
			}
			
			return emptySpaces;
		}
		return validMove4(board,x,y);
		}
		
		public boolean validMove4(Board board, int x, int y) {
		// bottom right diagonal + check if there are other figures in the way
		if(checkSame(x,y,-7,7) || checkSame(x,y,-6,6)|| 
				checkSame(x,y,-5,5) || checkSame(x,y,-4,4) || 
				checkSame(x,y,-3,3)|| checkSame(x,y,-2,2) || 
				checkSame(x,y,-1,1)) {
			for(int i=this.pos1+1 , k=this.pos2-1;i<x && k>y  ; i++ ,k--) {
				notNull(board,i,k);
			}
			return emptySpaces;
		}
		
		else { return false;
		}
	} // for loop ?
	public void notNull(Board board,int i, int k) {
		if(board.getField(i, k) != null) {
			emptySpaces= false;
		}
	}
	public boolean checkSame(int x, int y,int z1, int z2) {
		return (this.pos1 == x+z1&& this.pos2 == y+z2);
		
	}
}

