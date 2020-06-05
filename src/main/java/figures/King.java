package figures;

import game.Board;
import game.Figures;
import game.Zug;

/**
 * Class for the figure: king
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class King extends Figures {
	
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the king 
	 */
	public int pos1;
	
	/**
	 * the y axis position of the king
	 */
	public int pos2;
	
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
	private boolean realMove;
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
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement stackTraceElement = stackTraceElements[2];
		if(stackTraceElement.getMethodName() == "move2"){
			realMove =true;
			}
		else {
			realMove =false;
		}
		// check if the field to move to is on the board
		if(checkxy(x,y)) {
			return false;
		}
		
		// check if starting position equals ending position
		if(this.pos1 == x && this.pos2 ==y) {
			return false;
		}
		
		
		return check1(board,x,y);
	}
	
	/**
	 * check if move is on the board
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if move is off the board
	 */
	public boolean checkxy(int x,int y) {
		return x<0 || x>7|| y<0 || y>7 ;
	}
	
	/**
	 * method to check for short castling
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if short castling move was possible, else go on to check2
	 */
	public boolean check1(Board board, int x, int y) {
		// short castling (check hasMoved + emptySpaces + check if check)
		if(this.pos1 == x-2 && this.pos2 == y &&board.getField(7, y)!= null 
				&& board.getField(6, y) == null && board.getField(5, y)== null) {
					if(checkStuff1(board,x,y) ) {
						if(realMove) {
						board.setField(5, y, board.getField(7, y));
						board.setNull(7, y);
						}
						return true;
					}
					
					else {
						return false;
			}
		}
		return check2(board,x,y);
	}
	/**
	 * check if king and rook have moved
	 * @param board the board the move in on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if castling figures haven't moved yet
	 */
	public boolean checkStuff1(Board board, int x, int y) {
		return !this.hasMoved && !board.getField(7, y).isHasMoved()
		&& !Zug.checkField(board,4, y, this.color) && !Zug.checkField(board,5, y, this.color) && 
			!Zug.checkField(board,6, y, this.color);
	}
	
	/**
	 * check for long castling and normal king moves
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if move is valid
	 */
	public boolean check2(Board board, int x, int y) {
		// long castling (check hasMoved + emptySpaces + check if check)
		if(checkStuff3(board,x,y)) {
			if(checkStuff2(board,x,y)) {
				if(realMove) {
					board.setField(3, y, board.getField(0, y));
					board.setNull(0, y);
				}
					return true;
					}
					
		else {
			return false;
			}
		}
		
		// possible king standard moves (first checking x axis)
		else if((this.pos1 == x-1 || this.pos1 == x+1 ||this.pos1 == x)&&(this.pos2 == y-1 || this.pos2 == y+1 || this.pos2 == y)) {	
					return true;
			}
				
			return false;
		}
		
		
	/**
	 * check if long castling figures have moved
	 * @param board the board the move is on	
	 * @param x the x axis position to move to 
	 * @param y the y axis position to move to
	 * @return true if figures haven't moved yet
	 */
	public boolean checkStuff2(Board board, int x, int y) {
		return !this.hasMoved && !board.getField(0, y).isHasMoved()
				&& !Zug.checkField(board,4, y, this.color) && !Zug.checkField(board,3, y, this.color)&& 
				!Zug.checkField(board,2, y, this.color);
		}
		
	/**
	 * method to check if next move is supposed to be castling
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if next move is supposed to be castling
	 */
	public boolean checkStuff3(Board board, int x, int y) {
		return this.pos1 == x+2 && this.pos2 == y && board.getField(0, y)!= null 
			&& board.getField(3, y) == null && board.getField(2, y)== null;
		}
	}

