package figures;

import game.Board;
import game.Figures;

/**
* Class for the figure: pawn
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* Gruppe 23
*/
public class Pawn extends Figures {
	
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the pawn 
	 */
	private int pos1;
	
	/**
	 * the y axis position of the pawn
	 */
	private int pos2;
	
	/**
	 * the color of the pawn
	 */
	private String color;
	
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
	 * Checks if the current move is valid
	 * @param board ,the board on which the move is tested on
	 * @param x for the x axis position to move to
	 * @param y for the y axis position to move to
	 * @return true for valid move 
	 * @return false for invalid move
	 */
	public boolean validMove(Board board,int x, int y) {

		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		// en passant for white
		else if(this.color=="w"&&pos2==3&&y==2&&x==pos1+1&&board.movedList.getLast().getFigure().getType()==4 &&  
				board.movedList.getLast().getFigure()==board.getField(pos1+1, pos2) &&    
				board.movedList.getLast().getTo2()-board.movedList.getLast().getFrom2()  ==2) {
				board.setNull(board.movedList.getLast().getTo1(),board.movedList.getLast().getTo2());
				return true; 
				}
			
		// en passant for white
		else if(this.color=="w"&&pos2==3&&y==2&&x==pos1-1&&board.movedList.getLast().getFigure().getType()==4 &&  
				board.movedList.getLast().getFigure()==board.getField(pos1-1, pos2) &&    
				board.movedList.getLast().getTo2()-board.movedList.getLast().getFrom2()  ==2) {
				board.setNull(board.movedList.getLast().getTo1(),board.movedList.getLast().getTo2());
				return true; 
				}
		// en passant for black
		else if(this.color=="b"&&pos2==4&&y==5&&x==pos1-1&&board.movedList.getLast().getFigure().getType()==4 &&  
				board.movedList.getLast().getFigure()==board.getField(pos1-1, pos2) &&    
				board.movedList.getLast().getTo2()-board.movedList.getLast().getFrom2()  ==-2) {
				board.setNull(board.movedList.getLast().getTo1(),board.movedList.getLast().getTo2());
				return true; 
				}
			
		// en passant for black
		else if(this.color=="b"&&pos2==4&&y==5&&x==pos1+1&&board.movedList.getLast().getFigure().getType()==4 &&  
				board.movedList.getLast().getFigure()==board.getField(pos1+1, pos2) &&    
				board.movedList.getLast().getTo2()-board.movedList.getLast().getFrom2()  ==-2) {
				board.setNull(board.movedList.getLast().getTo1(),board.movedList.getLast().getTo2());
				return true; 
				}
		
		// normal move white
		else if(this.color =="w" && this.pos1 == x && this.pos2 == y+1) {
			
			if(board.getField(x, this.pos2-1) != null) {
				return false;
			}
			
			else {
				return true;
			}
		}
		
		// normal move black
		else if(this.color =="b" && this.pos1 == x && this.pos2 == y-1) {
			if(board.getField(x, this.pos2+1) != null) {
				return false;
			}
			
			else {
				return true;
			}
		}
		
		// double move white
		else if(this.color =="w" && this.pos1 == x && this.pos2 == y+2 && this.pos2 == 6) {
			if(board.getField(x, this.pos2-1) != null) {
				return false;
			}
			else if(board.getField(x, this.pos2-2) != null) {
				return false;
			}
			
			else {
				return true;
			}
		}
		
		// double move black
		else if(this.color =="b" && this.pos1 == x && this.pos2 == y-2 && this.pos2 == 1) {
			if(board.getField(x, this.pos2+1) != null) {
				return false;
			}
			else if(board.getField(x, this.pos2+2) != null) {
				return false;
			}
			
			else {
				return true;
			}
		}
		
		// take move black
		else if(this.color =="b" && this.pos1 == x+1 && this.pos2 == y-1 || this.color =="b" && this.pos1 == x-1 && this.pos2 == y-1) {
			if(board.getField(x, y)!= null){
				if(board.getField(x, y).getColor()!="w") {
					return false;
			}
			else {
					return true;
				}
			}
			else return false;
		}
		
		// take move white
		else if(this.color =="w" && this.pos1 == x+1 && this.pos2 == y+1 || this.color =="w" && this.pos1 == x-1 && this.pos2 == y+1) {
			if(board.getField(x, y)!= null){
				if(board.getField(x, y).getColor()!="b") {
					return false;
			}
			else {
					return true;
				}
			}
			else return false;
		}
		else return false;
	}
}

