package figures;

import game.Board;
import game.Figures;

/**
 * Class for the figure: rook
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Rook extends Figures {
	 
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	 
	/**
	 * the x axis position of the rook
	 */
	public int pos1;
	 
	/**
	 * the y axis position of the rook 
	 */
	public int pos2;
	 
	/**
	 * the color of the rook
	 */
	private String color;
	 
	/**
	 * check if the rook has moved already
	 */
	private boolean hasMoved;
	
	private boolean emptySpaces;
	

    protected static int [] rookTable = {
          0,  0,  0,  0,  0,  0,  0,  0,
          5, 10, 10, 10, 10, 10, 10,  5,
         -5,  0,  0,  0,  0,  0,  0, -5,
         -5,  0,  0,  0,  0,  0,  0, -5,
         -5,  0,  0,  0,  0,  0,  0, -5,
         -5,  0,  0,  0,  0,  0,  0, -5,
         -5,  0,  0,  0,  0,  0,  0, -5,
          0,  0,  0,  5,  5,  0,  0,  0 };
	
	/**
	 * the constructor creates a new rook object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the rook
	 * @param pos2 y axis position of the rook
	 * @param color color of the rook, valid input: "w" for white, "b" for black
	 */
	public Rook(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 6;
		this.hasMoved = false;
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of rook
	 * @param pos2 new y axis position of rook
	 */
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the rook as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "R";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "r";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	public static int[] getTable() {
		return rookTable;
	}
	
	/**
	 * get-method of hasMoved
	 * @return true if has moved
	 * @return false if king hasn't moved yet
	 */
	public boolean isHasMoved() {
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
	 * get-method of color
	 * @return color of the rook as a String
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Checks if the current move is valid
	 * @param board the board on which the move is tested on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true for valid move false for invalid move 
	 */
	public boolean validMove(Board board,int x, int y) {
		emptySpaces = true;
		
		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		return validMove1(board,x,y);
	}
	
	/**
	 * method to check if move is on the horizental line
	 * @param board the board on which the move is tested on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if move is valid, false if not or goes on to validMove2
	 */
	public boolean validMove1(Board board, int x, int y) {
		
		// horizontal line + check if there are other figures in the way
		if(this.pos1 == x && this.pos2 != y) {
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
			
			return emptySpaces;			
		}
		return validMove2(board,x,y);
	}
	
	/**
	 * method to check if move is on the vertical line
	 * @param board the board on which the move is tested on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if move is valid, else false
	 */
	public boolean validMove2(Board board, int x, int y) {
		
		// vertical line + check if there are other figures in the way
		if(this.pos1 != x && this.pos2 == y) {
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
			
			return emptySpaces;		
		}
		
		else {
			return false;
		}
	}
		
}

