package figures;

import game.Board;
import game.Figures;

/**
 * Class for the figure: pawn
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Pawn extends Figures {
	
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the pawn 
	 */
	public int pos1;
	
	/**
	 * the y axis position of the pawn
	 */
	public int pos2;
	
	/**
	 * the color of the pawn
	 */
	private String color;
	
	/**
	 * check if move real
	 */
	boolean realMove;
	
	/**
	 * the constructor creates a new pawn object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the pawn
	 * @param pos2 y axis position of the pawn
	 * @param color color of the pawn, valid input: "w" for white, "b" for black
	 */
	public Pawn(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 4;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the pawn as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "P";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "p";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of pawn
	 * @param pos2 new y axis position of pawn
	 */
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the pawn as a String
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * get-method of Type
	 * @return type of the pawn as an Integer
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * checks if the current move is valid
	 * @param board ,the board on which the move is tested on
	 * @param x for the x axis position to move to
	 * @param y for the y axis position to move to
	 * @return false for invalid move else go to validMove1
	 */
	public boolean validMove(Board board,int x, int y) {
	
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement stackTraceElement = stackTraceElements[2];
		if(stackTraceElement.getMethodName() == "move2"){
			realMove =true;
			}
		else {
			realMove =false;
		}
		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		return validMove1(board,x,y);
	}
	
	/**
	 * check for white en passant move
	 * @param board the board the move is on
	 * @param x the x axis position to move
	 * @param y the y axis position to move
	 * @return true if en passant move is valid, false if not and else continue to validmove2
	 */
	public boolean validMove1(Board board, int x, int y) {
		// en passant for white
		if(realMove &&this.color=="w"&&pos2==3&&y==2&&board.movedList.get(board.movedList.size()-1).getFigure().getType()==4&&    
				board.movedList.get(board.movedList.size()-1).getTo2()-board.movedList.get(board.movedList.size()-1).getFrom2()  ==2 ) {
				if (checkStuff1(board,x,y)) {
					board.setNull(board.movedList.get(board.movedList.size()-1).getTo1(),board.movedList.get(board.movedList.size()-1).getTo2());
					return true; 
				}
				return validmove2(board,x,y);
		}
		
		return validmove2(board,x,y);
	}
	
	/**
	 * check for black en passant move
	 * @param board the board the move is on
	 * @param x the x axis position to move
	 * @param y the y axis position to move
	 * @return true if en passant move is valid, false if not and else continue to validmove3
	 */
	public  boolean validmove2(Board board, int x, int y){	
		// en passant for black
		if(realMove &&this.color=="b"&&pos2==4&&y==5&&board.movedList.get(board.movedList.size()-1).getFigure().getType()==4 &&    
			board.movedList.get(board.movedList.size()-1).getTo2()-board.movedList.get(board.movedList.size()-1).getFrom2()  ==-2) {
				if(checkStuff2(board,x,y) ) {
					board.setNull(board.movedList.get(board.movedList.size()-1).getTo1(),board.movedList.get(board.movedList.size()-1).getTo2());
					return true; 
				}
				return validmove3(board,x,y);			
		}
		return validmove3(board,x,y);
	}
	
	/**
	 * method to check if last move was double pawn move by black
	 * @param board the board to move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if last move was double move
	 */
	public boolean checkStuff1(Board board, int x, int y) {
		return this.pos1 != 8&& board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1+1, pos2) &&x==pos1+1  ||
				this.pos1 != 0&& board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1-1, pos2) &&x==pos1-1;
	}
	
	/**
	 * method to check if last move was double pawn move by white
	 * @param board the board to move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if last move was double pawn move
	 */
	public boolean checkStuff2(Board board, int x, int y) {
		return this.pos1 != 8&& board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1-1, pos2) &&x==pos1-1 || 
				this.pos1 != 0&& board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1+1, pos2) &&x==pos1+1 ;
	}
	
	/**
	 * check if normal is possible
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if the normal move is possible, false if not or go on to validMove3_2
	 */
	public boolean validmove3(Board board, int x, int y) {

		// normal move white
		if(this.color =="w" && this.pos1 == x && this.pos2 == y+1) {
			return board.getField(x, this.pos2-1) == null;	
		}
		
		// normal move black
		else if(this.color =="b" && this.pos1 == x && this.pos2 == y-1) {
			return board.getField(x, this.pos2+1) == null;
		}
		
		return validMove3_2(board,x,y);
	}
	
	/**
	 * check if double move for white is possible
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if the double move is possible, false if not or go on to validMove4
	 */
	public boolean validMove3_2(Board board, int x, int y) {
		
	// double move white
		if(this.color =="w" && this.pos1 == x && this.pos2 == y+2 && this.pos2 == 6) {
			if(board.getField(x, this.pos2-1) != null) {
				return false;
			}
			else if(board.getField(x, this.pos2-2) != null) {
				return false;
			}			
				return true;
		}
		return validmove4(board,x,y);
	}
	
	/**
	 * check if double move for black is possible
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if the double move is possible, false if not or go on to validMove5
	 */
	public boolean validmove4(Board board, int x, int y){
		// double move black
		if(this.color =="b" && this.pos1 == x && this.pos2 == y-2 && this.pos2 == 1) {
			if(board.getField(x, this.pos2+1) != null) {
				return false;
			}
			else if(board.getField(x, this.pos2+2) != null) {
				return false;
			}
			
				return true;
			
		}
		return validMove5(board,x,y);
	}
	
	/**
	 * check if take move for black is possible
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if take move is possible, false if not or go on to validMove6
	 */
	public boolean validMove5(Board board, int x, int y){
		
		// take move black
		if(this.color =="b" && this.pos1 == x+1 && this.pos2 == y-1 || this.color =="b" && this.pos1 == x-1 && this.pos2 == y-1) {
			if(board.getField(x, y)!= null){
				return board.getField(x, y).getColor()=="w";
			}
			else {
				return false;
			}
		}
		
		return validMove6(board,x,y);
	}
	
	/**
	 * check if take move for white is possible
	 * @param board the board the move is on
	 * @param x the x axis position to move to
	 * @param y the y axis position to move to
	 * @return true if take move is possible 
	 */
	public boolean validMove6(Board board, int x, int y) {
		// take move white
		if(this.color =="w" && this.pos1 == x+1 && this.pos2 == y+1 || this.color =="w" && this.pos1 == x-1 && this.pos2 == y+1) {
			if(board.getField(x, y)!= null){
				return board.getField(x, y).getColor()=="b";
				
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}


